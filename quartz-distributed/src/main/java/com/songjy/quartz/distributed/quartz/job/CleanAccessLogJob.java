package com.songjy.quartz.distributed.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.quartz.*;
import org.springframework.context.ApplicationContext;

import java.io.File;
import java.io.FilenameFilter;
import java.util.regex.Pattern;

import static com.songjy.quartz.distributed.Constant.APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY;

/**
 * @author songjy
 * @date 2020-07-05
 */
@Slf4j
public class CleanAccessLogJob implements InterruptableJob {

    /**
     * access文件日志名称匹配正则
     */
    private static final Pattern PATTERN_ACCESS_LOG = Pattern.compile("access_log\56\\d{4}-\\d{2}-\\d{2}\56log");

    private ApplicationContext applicationContext;

    @Override
    public void execute(JobExecutionContext context) {
        try {
            applicationContext = (ApplicationContext) context.getScheduler().getContext().get(APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY);
        } catch (SchedulerException e) {
            log.error("No application context available in scheduler context for key:{}", APPLICATION_CONTEXT_SCHEDULER_CONTEXT_KEY);
            log.error(e.getMessage(), e);
            return;
        }

        String catalinaHome = System.getProperty("catalina.home");
        if (StringUtils.isBlank(catalinaHome)) {
            log.warn("目录【{}】不存在", catalinaHome);
            return;
        }

        File logs = new File(catalinaHome, "logs");

        if (!logs.exists() || !logs.isDirectory()) {
            log.warn("目录【{}】不存在", logs.getAbsolutePath());
            return;
        }

        File[] files = logs.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return PATTERN_ACCESS_LOG.matcher(name).matches();
            }
        });


        if (null == files || 0 == files.length) {
            return;
        }

        for (File file : files) {
            long lastModified = file.lastModified();
            /*日志只保留2天*/
            long diff = DateUtils.MILLIS_PER_DAY * 2;
            if ((System.currentTimeMillis() - lastModified) >= diff) {
                boolean delete = file.delete();
                log.warn("文件【{}】删除{}", file.getAbsolutePath(), delete ? "成功" : "失败");
            }
        }
    }

    @Override
    public void interrupt() {
        log.warn("任务{}强行中断", this.getClass().getName());
    }
}
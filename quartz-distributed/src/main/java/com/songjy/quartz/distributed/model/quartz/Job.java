package com.songjy.quartz.distributed.model.quartz;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author songjy
 */
@Getter
@Setter
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    private Integer jobId;

    /**
     * 任务名称
     */
    private String jobName;

    /**
     * 任务组名
     */
    private String jobGroup;

    /**
     * 任务方法
     */
    private String methodName;

    /**
     * 方法参数
     */
    private String methodParams;

    /**
     * cron执行表达式
     */
    private String cronExpression;

    /**
     * 计划执行错误策略（0默认 1继续 2等待 3放弃）
     */
    private String misfirePolicy;

    /**
     * 状态（0正常 1暂停）
     */
    private String status;

    /**
     * 创建者
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /** 触发器名 */
    private String triggerName;

    /** 触发器组 */
    private String triggerGroup;
}
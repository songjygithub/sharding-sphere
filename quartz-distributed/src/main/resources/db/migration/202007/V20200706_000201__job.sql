CREATE TABLE IF NOT EXISTS `sys_job` (
  `job_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '任务ID',
  `job_name` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '任务名称',
  `job_group` VARCHAR(64) NOT NULL DEFAULT '' COMMENT '任务组名',
  `method_name` VARCHAR(500) DEFAULT '' COMMENT '任务方法',
  `method_params` VARCHAR(200) DEFAULT '' COMMENT '方法参数',
  `cron_expression` VARCHAR(255) DEFAULT '' COMMENT 'cron执行表达式',
  `misfire_policy` VARCHAR(20) DEFAULT '0' COMMENT '计划执行错误策略（0默认 1继续 2等待 3放弃）',
  `status` CHAR(1) DEFAULT '0' COMMENT '状态（0正常 1暂停）',
  `create_by` VARCHAR(64) DEFAULT '' COMMENT '创建者',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  `update_by` VARCHAR(64) DEFAULT '' COMMENT '更新者',
  `update_time` DATETIME DEFAULT NULL COMMENT '更新时间',
  `remark` VARCHAR(500) DEFAULT '' COMMENT '备注信息',
  PRIMARY KEY (`job_id`,`job_name`,`job_group`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='定时任务调度表';

CREATE TABLE IF NOT EXISTS `sys_job_log` (
  `job_log_id` INT(11) NOT NULL AUTO_INCREMENT COMMENT '任务日志ID',
  `job_name` VARCHAR(64) NOT NULL COMMENT '任务名称',
  `job_group` VARCHAR(64) NOT NULL COMMENT '任务组名',
  `method_name` VARCHAR(500) DEFAULT NULL COMMENT '任务方法',
  `method_params` VARCHAR(200) DEFAULT '' COMMENT '方法参数',
  `job_message` VARCHAR(500) DEFAULT NULL COMMENT '日志信息',
  `status` CHAR(1) DEFAULT '0' COMMENT '执行状态（0正常 1失败）',
  `exception_info` TEXT COMMENT '异常信息',
  `create_time` DATETIME DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`job_log_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC COMMENT='定时任务调度日志表';
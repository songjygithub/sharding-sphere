/*!40101 SET NAMES utf8mb4 */ ;

/*!40101 SET SQL_MODE=''*/ ;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */ ;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */ ;

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */ ;

/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */ ;

/*Table structure for table `qrtz_blob_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_blob_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `blob_data` BLOB,
  PRIMARY KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) REFERENCES `qrtz_triggers` (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_calendars` */

CREATE TABLE IF NOT EXISTS `qrtz_calendars` (
  `sched_name` VARCHAR (120) NOT NULL,
  `calendar_name` VARCHAR (200) NOT NULL,
  `calendar` BLOB NOT NULL,
  PRIMARY KEY (`sched_name`, `calendar_name`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_cron_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_cron_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `cron_expression` VARCHAR (200) NOT NULL,
  `time_zone_id` VARCHAR (80) DEFAULT NULL,
  PRIMARY KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) REFERENCES `qrtz_triggers` (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_fired_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_fired_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `entry_id` VARCHAR (95) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `instance_name` VARCHAR (200) NOT NULL,
  `fired_time` BIGINT (13) NOT NULL,
  `sched_time` BIGINT (13) NOT NULL,
  `priority` INT (11) NOT NULL,
  `state` VARCHAR (16) NOT NULL,
  `job_name` VARCHAR (200) DEFAULT NULL,
  `job_group` VARCHAR (200) DEFAULT NULL,
  `is_nonconcurrent` VARCHAR (1) DEFAULT NULL,
  `requests_recovery` VARCHAR (1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`, `entry_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_job_details` */

CREATE TABLE IF NOT EXISTS `qrtz_job_details` (
  `sched_name` VARCHAR (120) NOT NULL,
  `job_name` VARCHAR (200) NOT NULL,
  `job_group` VARCHAR (200) NOT NULL,
  `description` VARCHAR (250) DEFAULT NULL,
  `job_class_name` VARCHAR (250) NOT NULL,
  `is_durable` VARCHAR (1) NOT NULL,
  `is_nonconcurrent` VARCHAR (1) NOT NULL,
  `is_update_data` VARCHAR (1) NOT NULL,
  `requests_recovery` VARCHAR (1) NOT NULL,
  `job_data` BLOB,
  PRIMARY KEY (
    `sched_name`,
    `job_name`,
    `job_group`
  )
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_locks` */

CREATE TABLE IF NOT EXISTS `qrtz_locks` (
  `sched_name` VARCHAR (120) NOT NULL,
  `lock_name` VARCHAR (40) NOT NULL,
  PRIMARY KEY (`sched_name`, `lock_name`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_paused_trigger_grps` */
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps` ;

CREATE TABLE IF NOT EXISTS `qrtz_paused_trigger_grps` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  PRIMARY KEY (`sched_name`, `trigger_group`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_scheduler_state` */

CREATE TABLE IF NOT EXISTS `qrtz_scheduler_state` (
  `sched_name` VARCHAR (120) NOT NULL,
  `instance_name` VARCHAR (200) NOT NULL,
  `last_checkin_time` BIGINT (13) NOT NULL,
  `checkin_interval` BIGINT (13) NOT NULL,
  PRIMARY KEY (`sched_name`, `instance_name`)
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_simple_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_simple_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `repeat_count` BIGINT (7) NOT NULL,
  `repeat_interval` BIGINT (12) NOT NULL,
  `times_triggered` BIGINT (10) NOT NULL,
  PRIMARY KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) REFERENCES `qrtz_triggers` (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_simprop_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_simprop_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `str_prop_1` VARCHAR (512) DEFAULT NULL,
  `str_prop_2` VARCHAR (512) DEFAULT NULL,
  `str_prop_3` VARCHAR (512) DEFAULT NULL,
  `int_prop_1` INT (11) DEFAULT NULL,
  `int_prop_2` INT (11) DEFAULT NULL,
  `long_prop_1` BIGINT (20) DEFAULT NULL,
  `long_prop_2` BIGINT (20) DEFAULT NULL,
  `dec_prop_1` DECIMAL (13, 4) DEFAULT NULL,
  `dec_prop_2` DECIMAL (13, 4) DEFAULT NULL,
  `bool_prop_1` VARCHAR (1) DEFAULT NULL,
  `bool_prop_2` VARCHAR (1) DEFAULT NULL,
  PRIMARY KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) REFERENCES `qrtz_triggers` (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*Table structure for table `qrtz_triggers` */

CREATE TABLE IF NOT EXISTS `qrtz_triggers` (
  `sched_name` VARCHAR (120) NOT NULL,
  `trigger_name` VARCHAR (200) NOT NULL,
  `trigger_group` VARCHAR (200) NOT NULL,
  `job_name` VARCHAR (200) NOT NULL,
  `job_group` VARCHAR (200) NOT NULL,
  `description` VARCHAR (250) DEFAULT NULL,
  `next_fire_time` BIGINT (13) DEFAULT NULL,
  `prev_fire_time` BIGINT (13) DEFAULT NULL,
  `priority` INT (11) DEFAULT NULL,
  `trigger_state` VARCHAR (16) NOT NULL,
  `trigger_type` VARCHAR (8) NOT NULL,
  `start_time` BIGINT (13) NOT NULL,
  `end_time` BIGINT (13) DEFAULT NULL,
  `calendar_name` VARCHAR (200) DEFAULT NULL,
  `misfire_instr` SMALLINT (2) DEFAULT NULL,
  `job_data` BLOB,
  PRIMARY KEY (
    `sched_name`,
    `trigger_name`,
    `trigger_group`
  ),
  KEY `sched_name` (
    `sched_name`,
    `job_name`,
    `job_group`
  ),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (
    `sched_name`,
    `job_name`,
    `job_group`
  ) REFERENCES `qrtz_job_details` (
    `sched_name`,
    `job_name`,
    `job_group`
  ) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4 ROW_FORMAT = DYNAMIC ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */ ;

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */ ;

/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */ ;

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */ ;
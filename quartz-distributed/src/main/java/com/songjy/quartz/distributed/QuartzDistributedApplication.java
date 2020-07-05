package com.songjy.quartz.distributed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songjy
 */
@SpringBootApplication
@MapperScan(basePackages = "com.songjy.quartz.distributed.mapper")
public class QuartzDistributedApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuartzDistributedApplication.class, args);
    }

}

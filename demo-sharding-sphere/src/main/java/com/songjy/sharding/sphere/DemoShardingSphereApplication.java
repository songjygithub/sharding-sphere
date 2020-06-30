package com.songjy.sharding.sphere;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author songjy
 */
//@SpringBootApplication(exclude = {org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class})
@SpringBootApplication
@MapperScan(basePackages = "com.songjy.sharding.sphere.mapper")
public class DemoShardingSphereApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoShardingSphereApplication.class, args);
    }

}

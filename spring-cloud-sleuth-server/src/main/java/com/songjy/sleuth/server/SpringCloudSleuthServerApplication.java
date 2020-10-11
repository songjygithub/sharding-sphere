package com.songjy.sleuth.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author songjy
 */
@SpringBootApplication
@EnableZipkinServer
public class SpringCloudSleuthServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudSleuthServerApplication.class, args);
    }

}

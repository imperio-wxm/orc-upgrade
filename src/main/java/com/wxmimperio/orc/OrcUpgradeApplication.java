package com.wxmimperio.orc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class OrcUpgradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrcUpgradeApplication.class, args);
    }
}

package com.wxmimperio.orc;

import com.wxmimperio.orc.common.HadoopUtils;
import com.wxmimperio.orc.pojo.GlobalProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan
@ServletComponentScan
public class OrcUpgradeApplication {

    public static ApplicationContext context;

    //允许跨域请求
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowCredentials(true)
                        .allowedMethods("GET", "POST", "DELETE", "PUT")
                        .maxAge(3600);
            }
        };
    }

    public static void main(String[] args) throws Exception {
        context = SpringApplication.run(OrcUpgradeApplication.class, args);
    }
}

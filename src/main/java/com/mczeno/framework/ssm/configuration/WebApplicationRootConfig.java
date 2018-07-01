package com.mczeno.framework.ssm.configuration;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目初始化配置
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@ComponentScan(value = "com.mczeno.framework.ssm",
        excludeFilters = {@Filter(type = FilterType.ANNOTATION, classes = {Controller.class, RestController.class})})
@PropertySource("classpath:/application.properties")
public class WebApplicationRootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

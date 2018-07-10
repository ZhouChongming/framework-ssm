package tech.mczeno.framework.ssm.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc 配置
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@Configuration
@EnableWebMvc
@ComponentScan(value = "tech.mczeno.framework.ssm.controller")
public class WebMvcConfig implements WebMvcConfigurer {

}

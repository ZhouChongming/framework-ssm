package tech.mczeno.framework.ssm.configuration;

import org.springframework.context.annotation.*;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 项目初始化配置
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
@Configuration
@ComponentScan(value = "tech.mczeno.framework.ssm",
        excludeFilters = {@Filter(type = FilterType.ANNOTATION, value = {EnableWebMvc.class})})
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:db.properties")
})
public class WebApplicationRootConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}

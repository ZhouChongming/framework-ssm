package tech.mczeno.framework.ssm.security;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * Spring Security 初始化
 * 继承 AbstractSecurityWebApplicationInitializer 类会自动注册 DelegatingFilterProxy
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

}

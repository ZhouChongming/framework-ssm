package tech.mczeno.framework.ssm.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.FilterInvocation;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 对请求的资源的投票决策
 * @author Chongming Zhou
 * @date 2018-07-09
 */
@Component("accessDecisionVoter")
public class CustomizeAccessDecisionVoter implements AccessDecisionVoter<Object> {

    private final Logger logger = LoggerFactory.getLogger(CustomizeAccessDecisionVoter.class);

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {
		if(authentication == null) {
            logger.warn("Authentication was null");
			return ACCESS_DENIED;
		}
		int result = ACCESS_ABSTAIN;
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String servletPath = null;
		String method = null;
		if (object != null && object instanceof FilterInvocation) {
            HttpServletRequest httpRequest = ((FilterInvocation) object).getHttpRequest();
            servletPath = httpRequest.getServletPath();
            method = httpRequest.getMethod();
            logger.info("request servlet path : {}, method : {}", servletPath, method);
		}
		for (ConfigAttribute attribute : attributes) {
			if (this.supports(attribute)) {
				result = ACCESS_DENIED;
				// 匹配资源
				for (GrantedAuthority authority : authorities) {
					String roleName = authority.getAuthority();
					// TODO 通过 roleName 查询  resource(url)，以下仅供测试
					Set<String> resources = new HashSet<>();
					resources.add("/hello");
					
					if (resources.contains(servletPath) && "post".equalsIgnoreCase(method)) {
					    logger.info("resource {} authorized", servletPath);
						return ACCESS_GRANTED;
					}
				}
			}
		}
		return result;
	}
}

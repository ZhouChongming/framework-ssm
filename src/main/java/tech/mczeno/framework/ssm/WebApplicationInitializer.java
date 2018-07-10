package tech.mczeno.framework.ssm;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import tech.mczeno.framework.ssm.configuration.WebApplicationRootConfig;
import tech.mczeno.framework.ssm.configuration.WebMvcConfig;

import javax.servlet.Filter;

/**
 * 项目初始化类
 *
 * @author Chongming Zhou
 * @date 2018-06-29
 */
public class WebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebApplicationRootConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter("UTF-8", true);
		return new Filter[] { encodingFilter };
	}
}

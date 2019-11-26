package org.finn.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;

/**
 * <p>
 * org.springframework.boot.web.servlet.ServletContextInitializerBeans#addAdaptableBeans(ListableBeanFactory)<br>
 * 该类方法内注册了一些通用的 filter 过滤器
 * </p>
 * <p>
 * ResourceUrlProviderExposingInterceptor  该 Interceptor 拦截器在如下配置里注册：<br>
 * WebMvcConfigurationSupport#getInterceptors()
 * </p>
 * <p>
 * ResourceUrlEncodingFilter 该 filter 过滤器在如下配置类里注册：<br>
 * <b>org.springframework.boot.autoconfigure.freemarker.FreeMarkerServletWebConfiguration</b> class<br>
 * #resourceUrlEncodingFilter() method
 * </p>
 *
 * @author Finn Zhao
 * @version 2019-11-24
 */
public class FilterRegistrationConfiguration {

    public FilterRegistrationBean<ResourceUrlEncodingFilter> registrationBean() {
        FilterRegistrationBean<ResourceUrlEncodingFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new ResourceUrlEncodingFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}

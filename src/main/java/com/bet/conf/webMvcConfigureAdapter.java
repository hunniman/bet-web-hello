package com.bet.conf;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.Locale;


@Configuration
@EnableWebMvc
public class webMvcConfigureAdapter extends WebMvcConfigurerAdapter {
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

  /*  @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.jsp");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }
*/
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/page/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * 静态资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }



   /* @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
        return factory;
    }*/

    @Bean
    public FilterRegistrationBean someFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new GetContextFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getmessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasename("messages/messages");
        source.setUseCodeAsDefaultMessage(true);//不加会报错,很纠结 还没搞明白
        return source;
    }

    @Bean
    public CookieLocaleResolver getCookieLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieMaxAge(604800);
        resolver.setDefaultLocale(Locale.forLanguageTag("zh_CN"));
        resolver.setCookieName("Language");
        return resolver;
    }

    @Bean(name = "localeResolver")
    public SessionLocaleResolver getSessionLocaleResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        sessionLocaleResolver.setDefaultLocale(Locale.CHINA);
        //sessionLocaleResolver.l/**/
        return sessionLocaleResolver;
    }

    // @Bean
    private LocaleChangeInterceptor getInterceptor() {
        LocaleChangeInterceptor interceptor = new LocaleChangeInterceptor();
        interceptor.setParamName("language");
        return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getInterceptor()).addPathPatterns("/**");
    }

 /*   @Bean
    public DBaasLocaleResolver getLocaleResolver(){
        DBaasLocaleResolver dBaasLocaleResolver=new DBaasLocaleResolver();
        return  dBaasLocaleResolver;
    }*/

    /**
     * 主要设置没有授权用户的 页面跳转
     * @return
     */
/*    @Bean
    public SimpleMappingExceptionResolver getSimpleMappingExceptionResolver(){
        SimpleMappingExceptionResolver simpleMappingExceptionResolver=new SimpleMappingExceptionResolver();
        Properties properties=new Properties();
        properties.setProperty("org.apache.shiro.authz.AuthorizationException","/exception/unAuthorization");
        properties.setProperty("org.apache.shiro.authz.UnauthorizedException","/exception/unAuthorization");
        simpleMappingExceptionResolver.setExceptionMappings(properties);
        return simpleMappingExceptionResolver;
    }*/

}

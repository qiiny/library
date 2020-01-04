package top.qiin.library.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: demo6
 * @description:
 * @author: qin
 * @create: 2019-12-31 18:40
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Autowired
    private LoginInterceptor loginInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/","/admin_login","/logout","/login","/toUser","/userLogin","/templates/**","/static/**","/css/**","/images/**","/js/**","/scripts/**");
    }


}

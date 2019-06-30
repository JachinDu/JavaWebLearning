package com.jachin.springbootday03restfulcrud.config;

import com.jachin.springbootday03restfulcrud.component.LoginHandlerInterceptor;
import com.jachin.springbootday03restfulcrud.component.MyLocalResolver;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;


//扩展springmvc的功能
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {




    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //浏览器发送/atguigu请求，跳转到success页面
        registry.addViewController("/atguigu").setViewName("success");
    }


    //所有WebMvcConfigurer组件会一起起作用
    //要将组件注册进容器
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            //注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //静态资源不用处理
                //这里是再未登录时除登录页面相关的页面外都要进入拦截器，去判断是否登录
//                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return configurer;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }
}

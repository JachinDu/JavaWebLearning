package com.jachin.springbootsday05security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@EnableWebSecurity  //该注解内含@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);

        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("VIP1")
                .antMatchers("/level2/**").hasRole("VIP2")
                .antMatchers("/level3/**").hasRole("VIP3");

        //开启登录功能,效果：没有权限，就会跳到登录页面
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userlogin");
        //1、默认/login来到登录页，使用loginPage自定义登录请求
        //2、重定向到/login?error表示登录失败
        //3、更多规则
        //默认自定义的login页面要以post形式请求到默认/login，springsecurity才会当作登录请求处理，
            //且登录表单的name分别为username password，或这自定义如上
        //但是一旦定制了登录页，post提交到定制登录也即为处理登录请求

        //开启自动配置的注销功能
        http.logout().logoutSuccessUrl("/");  //指定注销后的地址，这里为首页
        //1、访问 /logout 表示用户注销，清空session
        //2、注销成功会返回 /login?logout页面

        //开启记住登录功能
        //通过cookie实现
        http.rememberMe().rememberMeParameter("remeber");

    }


    //定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        super.configure(auth);
        //登录信息可以存到数据库最好，这里就以存到内存中为演示
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder()).withUser("zhangsan").password(new BCryptPasswordEncoder().encode("123")).roles("VIP1", "VIP2")
                .and()
                .withUser("lisi").password(new BCryptPasswordEncoder().encode("12")).roles("VIP2", "VIP3")
                .and()
                .withUser("wangwu").password(new BCryptPasswordEncoder().encode("1")).roles("VIP1", "VIP3");
    }
}

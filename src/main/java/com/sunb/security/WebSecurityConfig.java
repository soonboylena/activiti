package com.sunb.security;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sunb on 2017/4/22.
 */
@Configuration
@EnableAutoConfiguration(exclude = {
        org.activiti.spring.boot.RestApiAutoConfiguration.class,
        org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class})
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
public class WebSecurityConfig {

    //@Override
    //protected void configure(HttpSecurity http) throws Exception {
    //    http
    //            .authorizeRequests()
    //            .anyRequest().permitAll();
    //    //.antMatchers("/", "/home").permitAll()
    //    //.anyRequest().authenticated()
    //    //.and()
    //    //.formLogin()
    //    //.loginPage("/login")
    //    //.permitAll()
    //    //.and()
    //    //.logout()
    //    //.permitAll();
    //}
    //
    //@Autowired
    //public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    //    auth
    //            .inMemoryAuthentication()
    //            .withUser("sunbo").password("sunbo").roles("USER", "ACTUATOR");
    //}


}

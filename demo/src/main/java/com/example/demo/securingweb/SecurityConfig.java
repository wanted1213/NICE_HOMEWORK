//package com.example.demo.securingweb;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .cors().and()
//                .csrf().disable()
//                .sessionManagement()
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                    .and()
//                .authorizeRequests()
//                    //.antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                	//.antMatchers("/api/v1/test/permit-all").permitAll()
//                	//.antMatchers("/api/v1/test/auth").authenticated()
//            		.antMatchers("/**").permitAll()
//            		//.antMatchers("/home/*").permitAll()
//                	.antMatchers("/swagger-ui.html").authenticated()
//                	//.antMatchers("/**").permitAll()
//                	.anyRequest().permitAll()
//                    .and()
//                .formLogin().disable()
//        ;
//    }
//}
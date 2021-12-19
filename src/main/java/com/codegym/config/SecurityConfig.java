package com.codegym.config;

import com.codegym.service.account.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private IAccountService accountService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public AccountAccessDeniedHandler customAccessDeniedHandler() {
        return new AccountAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(accountService).passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());
        http.authorizeRequests()
                //Set cho tat ca deu vao duoc

                .antMatchers("/", "/api/login", "/mails", "/mails/send", "/api/bills", "/api/accounts*","/api/genders","/api/staffs*","/api/staffs/**","/api/avatar*","/api/checkers/**", "/api/bills/view/**", "/api/bills/editStatus/**", "/api/bills/showByStaff/**", "/api/bills/showByChecker/**", "/api/bills/cancelStatus/**", "/api/bills/setStatusCompleted/**", "/api/bills/setStatusRequestMoney/**", "/api/accounts/unBlockAccount/**", "/api/accounts/blockAccount/**", "/api/accounts/verify/**","/api/options**", "/api/staffoption**","/api/staffoption/**","/api/avatar/**","/api/billOptions**", "/api/billOptions/**", "/api/options/**", "/api/options**", "/api/bills/hour/**","/api/bills/amount/**/**").permitAll()


                //Set tung quyen cho tung thang
                .antMatchers("/api/helloAdmin").access("hasRole('ROLE_ADMIN')")
                .antMatchers("/api/helloStaff").access("hasRole('ROLE_STAFF')")
                .antMatchers("/api/helloChecker").access("hasRole('ROLE_CHECKER')")
                .anyRequest().authenticated()
                .and().csrf().disable();
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }
}
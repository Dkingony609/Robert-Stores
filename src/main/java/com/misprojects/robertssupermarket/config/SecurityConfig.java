package com.misprojects.robertssupermarket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final PasswordEncoder passwordEncoder;
    private final CustomUserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin().and()
                .authorizeRequests()
                .antMatchers("api/v1/**").permitAll()
                .anyRequest().authenticated();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
    }

    @Lazy
    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(org.springframework.security.config.annotation.web.builders.WebSecurity web)  {
        web.ignoring().antMatchers("/v2/api-docs/**");
        web.ignoring().antMatchers("/swagger.json");
        web.ignoring().antMatchers("/api/v1/users/**");
        web.ignoring().antMatchers("/api/v1/store/**");

        web.ignoring().antMatchers("/swagger-ui.html");
        web.ignoring().antMatchers("/swagger-resources/**");
        web.ignoring().antMatchers("/webjars/**");

    }


}

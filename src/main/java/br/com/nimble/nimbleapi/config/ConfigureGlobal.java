package br.com.nimble.nimbleapi.config;

import br.com.nimble.nimbleapi.service.Person.NimbleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ConfigureGlobal extends WebSecurityConfigurerAdapter {
    @Autowired
    NimbleUserService service;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.authorizeRequests()
               .anyRequest().authenticated()
               .and()
               .httpBasic()
               .and()
               .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(this.service);
        auth.userDetailsService(this.service).passwordEncoder(new BCryptPasswordEncoder());
    }

    //    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("tiago").password("{noop}123").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}123").roles("USER", "ADMIN");
//
//    }
}

package ch.sekthor.springsecurity.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * This class is the configuration class for spring security
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * We are going to override the default configure method inherited by the super class
     * This Method is configured for http Basic Authentication.
     * i.e. the client will have to send his username and password with every request
     * as a base64 encrypted string
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*") // these URLS ...
                .permitAll() // ... can be accessed without authentication
                .anyRequest() // every request has to be authenticated
                .authenticated()
                .and()
                .httpBasic(); // specify http basic method
    }

}

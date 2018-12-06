package eu.spb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecuriteConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors().and().csrf().disable();
        http.authorizeRequests()
                .antMatchers(HttpMethod.POST ,"/inscrire").permitAll()
                .antMatchers(HttpMethod.POST ,"/login").permitAll() 
                .antMatchers(HttpMethod.POST ,"/all/**").permitAll()
                .antMatchers("/admin/**").permitAll();
        /*http.authorizeRequests()
        .antMatchers("/admin/**").hasRole("ADMIN")                                      
        .antMatchers("/user/**").hasRole("USER")           
        .anyRequest().authenticated() ;     */     
    }
    @Autowired
    public void globalConfig(AuthenticationManagerBuilder auth ,DataSource dataSource) throws Exception{
    	auth.jdbcAuthentication()
    		.dataSource(dataSource)
    		.usersByUsernameQuery("select email as principal,password as credentials,nom , prenom from user where email=?")
    		.authoritiesByUsernameQuery("select email as principal, role as role from user where email=?")
    		.rolePrefix("ROLE_");
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}


package com.iset.security;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;
import com.iset.services.UserService;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		 prePostEnabled = true,
		 securedEnabled = true,
		 jsr250Enabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
public static final String AUTHORITIES_CLAIM_NAME = "roles";
@Autowired
 UserService userDetailsService;
@Bean
public BCryptPasswordEncoder bCryptPasswordEncoder() {
    return new BCryptPasswordEncoder();
}
@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
 auth.userDetailsService(userDetailsService);
 }
@Override
protected void configure(HttpSecurity http) throws Exception {

http.csrf().disable()
.authenticationProvider(getProvider())
.formLogin()
.loginProcessingUrl("/login")
.loginPage("/login")
.defaultSuccessUrl("/", true).permitAll()
.successHandler(new AuthentificationLoginSuccessHandler())
.failureHandler(new SimpleUrlAuthenticationFailureHandler())
.and()
.logout()
.logoutUrl("/logout")
.logoutSuccessHandler(new AuthentificationLogoutSuccessHandler())
.invalidateHttpSession(true)
.and()
.authorizeRequests()
.antMatchers("/login").permitAll()
.antMatchers("/logout").permitAll()
.antMatchers("/signup").permitAll()
.antMatchers("/addUser").permitAll()
.antMatchers("/ListeProduits").permitAll()
.antMatchers("/").permitAll()
.antMatchers("/webjars/**").permitAll()
.anyRequest().authenticated();
http.exceptionHandling().accessDeniedPage("/accessDenied"); 
}
private class AuthentificationLoginSuccessHandler extends
SimpleUrlAuthenticationSuccessHandler {
@Override
public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
Authentication authentication) throws IOException, ServletException {
	response.setStatus(HttpServletResponse.SC_OK);
	response.sendRedirect("/produits/");
     super.onAuthenticationSuccess(request, response, authentication);
}
}
private class AuthentificationLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
            response.setStatus(HttpServletResponse.SC_OK);
            response.sendRedirect("produits/login");
    }
}
@Bean
public AuthenticationProvider getProvider() {
AppAuthProvider provider = new AppAuthProvider();
provider.setUserDetailsService(userDetailsService);
return provider;
}
@Bean
public AccessDeniedHandler accessDeniedHandler(){
return new AccessDeniedHandlerImpl();
}

}
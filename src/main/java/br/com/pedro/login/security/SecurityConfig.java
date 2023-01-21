package br.com.pedro.login.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public AuthenticationSuccessHandlerImpl authenticationSuccessHandler() {
		return new AuthenticationSuccessHandlerImpl();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable()
		     .authorizeRequests()
		     .antMatchers("/CSS/**").permitAll()
		     .antMatchers("/usuario").hasRole(Role.USUARIO.toString())
		     .anyRequest().authenticated()
		     .and()
		     .formLogin()
		         .loginPage("/login")
		         .failureUrl("/login-error")
		         .successHandler(authenticationSuccessHandler())
		         .permitAll()
			.and()
			    .logout()
			    .logoutUrl("/logout")
			    .permitAll();
		

	}
}

package com.salesianos.triana.dam.animanga.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioRepo usuarios;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http

				.authorizeRequests().antMatchers("/private/**").hasAnyRole("USER", "ADMIN").antMatchers("/admin/**")
				.hasRole("ADMIN").antMatchers("/mangaka/editar/**").hasRole("ADMIN").antMatchers("/categoria/editar/**")
				.hasRole("ADMIN").antMatchers("/editar/**").hasRole("ADMIN").antMatchers("/eliminar/**")
				.hasRole("ADMIN").antMatchers("/categoria/gestionCategoria**").hasRole("ADMIN").antMatchers("/eliminar/**")
				.hasRole("ADMIN").antMatchers("/mangaka/eliminar/**").hasRole("ADMIN")	
				.antMatchers("/lista/**").hasRole("ADMIN")
				
				.antMatchers("/mangaka/lista/**").hasRole("ADMIN")
				
				.antMatchers("/categoria/eliminar/**").hasRole("ADMIN").anyRequest().permitAll().and()
				.exceptionHandling().accessDeniedPage("/error").and().formLogin().and().logout().logoutSuccessUrl("/");

		http.csrf().disable();
		http.headers().frameOptions().disable();

	}

	@Bean
	@Override
	public UserDetailsService userDetailsService() {

		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		usuarios.getUsuarios().stream().map(u -> {
			return User.withUsername(u.getUsername()).password("{noop}" + u.getPassword()).roles(u.getRole()).build();

		}).forEach(userDetailsManager::createUser);

		return userDetailsManager;

	}
}

package com.salesianostriana.dam.bd_seguridadmemoria.seguridad;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	//CREACIÓN DEL MÉTODO QUE CONFIGURA LA AUTENTICACIÓN
	//Almacén estático de usuarios
	@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.builder()
        		.username("Pepe")
        		.password("{noop}admin")	//El cifrado de la contraseña va entre {}, seguido se escribe la contraseña.
        		.roles("ADMIN")
            .build();
        return new InMemoryUserDetailsManager(user);
    }
	
	//Creación del proveedor de autenticación
	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService());
		provider.setPasswordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
		return provider;
	}
	
	//Creación del mecanismo de autenticación
	@Bean
	public AuthenticationManager 
			authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
	}
	
	//CONFIGURACIÓN DE LA AUTORIZACIÓN O CONTROL DE ACCESO
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests(
				(authz) -> authz
				.requestMatchers("/css/**", "/js/**").permitAll()
				.anyRequest().authenticated())
			.formLogin((loginz) -> loginz
					.loginPage("/login").permitAll());

		return http.build();
	}

}

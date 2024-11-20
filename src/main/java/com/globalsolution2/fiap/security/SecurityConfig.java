package com.globalsolution2.fiap.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	SecurityFilter securityFilter;
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity
				.csrf(csrf -> csrf.disable()) // Desabilita CSRF, já que você está usando tokens JWT
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define que a aplicação não mantém sessão
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Permite acesso ao login sem autenticação
						.requestMatchers(HttpMethod.POST, "/auth/register").permitAll() // Permite acesso ao registro sem autenticação
						.requestMatchers(HttpMethod.GET, "/").permitAll()
						.requestMatchers(HttpMethod.GET, "/usuarios", "/usuarios/**", "/perguntas", "/respostas").permitAll() // Acesso público a essas rotas // Apenas usuários autenticados podem acessar
						.requestMatchers(HttpMethod.POST, "/perguntas", "/respostas").hasRole("ADMIN") // Apenas ADMIN pode postar perguntas e respostas
						.requestMatchers(HttpMethod.PUT, "/perguntas", "/respostas").hasRole("ADMIN") // Apenas ADMIN pode atualizar perguntas e respostas
						.anyRequest().authenticated() // Todas as outras requisições precisam de autenticação
				)
				.addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class) // Adiciona o filtro de segurança antes do padrão
				.build();
	}
	

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception{
		return authenticationConfiguration.getAuthenticationManager();
	}

    @Bean
    PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

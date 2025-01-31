package uisrael.legalPro;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import uisrael.legalPro.service.IClienteService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final IClienteService userDetailsService;
	
	public SecurityConfig(IClienteService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests(auth -> auth
					.requestMatchers("/login", "/css/**", "/js/**", "assets/**", "/error").permitAll()
					.requestMatchers("/","/index","/listartarea/**").authenticated() //requiere autenticación
					.requestMatchers("/cliente/**","/listartarea/**").hasRole("CLIENTE")
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/login")
					.loginProcessingUrl("/login")
					.defaultSuccessUrl("/index", true)
					.failureUrl("/login?error=true")
					.permitAll()
			)
			.logout(logout -> logout
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout=true")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
			)
			.userDetailsService(userDetailsService)
			.csrf(csrf -> csrf.disable());		
		
		return http.build();
	}	
		@Bean
		public PasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
	}
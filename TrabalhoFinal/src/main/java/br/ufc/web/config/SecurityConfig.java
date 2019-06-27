package br.ufc.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.ufc.web.security.UserDetailsServiceImplementacao;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailsServiceImplementacao userDetailsImplementacao;	

	// Definir regras da apicação
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
			
			.antMatchers("/").permitAll()
			//	Somente uma pessoa com papel USER pode acessar essa URL
//			.antMatchers("/pessoa/administrador").hasRole("ADMIN") //.hasAnyRole("ADMIN", "USER")
//			.antMatchers("/pessoa/formulario").permitAll()
//			.antMatchers("/pessoa/salvar").permitAll()
			.antMatchers("/login").anonymous()
			.antMatchers("/cadastro").anonymous()
			.antMatchers("/pratos").permitAll()
			.antMatchers("/sobre").permitAll()
			.antMatchers("/user/cadastrar").permitAll()
			

			.antMatchers("/tropical/cadastrarPrato").hasRole("ADMIN")
			.antMatchers("/tropical/salvar").hasRole("ADMIN")
			
			.anyRequest().authenticated()
			
			.and()
			.formLogin()
			
			.loginPage("/login").permitAll().defaultSuccessUrl("/")
			.permitAll()
			
			.and()
			.logout()
			.logoutSuccessUrl("/login?logout")
			.permitAll()
			;
	}

	// Método da autenticação
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsImplementacao)
			.passwordEncoder(new BCryptPasswordEncoder())
		;
	}

	// Ignorar esses arquivos para que eles apareçam
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/images/**");
	}
}

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService(BCryptPasswordEncoder bCryptPasswordEncoder) {
		InMemoryUserDetailsManager manager=new InMemoryUserDetailsManager();
		manager.createUser(				
				User.withUsername("admin")
				.password(bCryptPasswordEncoder.encode("1234"))
				.roles("ADMIN")
				.build()				
				);
		manager.createUser(				
				User.withUsername("cliente")
				.password(bCryptPasswordEncoder.encode("1234"))
				.roles("CLIENTE")
				.build()				
				);
		
		return manager;
	}
	
	@Bean
	public AuthenticationManager authManager(HttpSecurity http,BCryptPasswordEncoder encoder, UserDetailsService uds) throws Exception{
		return http.getSharedObject(AuthenticationManagerBuilder.class)
				.userDetailsService(uds)
				.passwordEncoder(encoder)
				.and()
				.build();
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http)throws Exception {
		
		http.csrf().disable()
			.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/pedido").hasRole("CLIENTE")
	        .antMatchers("/crear-producto").hasRole("ADMIN")
	        .anyRequest().authenticated();		

		return http.build();
		
	}
	
	 @Bean
	    protected void configure(HttpSecurity security) throws Exception
	    {
	     security.httpBasic().disable();
	    }
	
	
}

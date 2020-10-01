package sv.gob.mitur.application.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class Security extends WebSecurityConfigurerAdapter
{
	@Autowired private UserDetailsService userDetailsService; // Dependency injection

	@Override
	protected void configure ( AuthenticationManagerBuilder auth ) throws Exception
	{
		auth.userDetailsService( userDetailsService );
	}

	@Override
	protected void configure ( HttpSecurity http ) throws Exception
	{
		http.authorizeRequests()
			.antMatchers( "/users/**" ).hasAuthority( "ADMINISTRADOR" )
			.antMatchers(
				"/types/**",
				"/travels/**",
				"/events/**",
				"/routes/**",
				"/locations/**",
				"/places/**",
				"/dashboard"
			).authenticated()
			.antMatchers( "/" ).permitAll()
			.and().formLogin().loginPage( "/login" ).defaultSuccessUrl( "/dashboard" )
			.and().csrf().disable();
	}

	/**
	 * Creates a bean with an encoder
	 * @return {@link BCryptPasswordEncoder}
	 */
	@Bean
	public BCryptPasswordEncoder passwordEncoder ()
	{
		return new BCryptPasswordEncoder();
	}
}
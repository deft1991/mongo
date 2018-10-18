package ru.deft.mongo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Sergey Golitsyn (deft) on 18.10.2018
 */
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  MongoUserDetailsService userDetailsService;

  @Autowired
  public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	auth.userDetailsService(userDetailsService);
  }

  @Override
  public void configure(WebSecurity web) throws Exception {
	web.ignoring().antMatchers("/");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
	http.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests().antMatchers("/welcome").permitAll()
			.and()
			.authorizeRequests().antMatchers("/editAuthor"
			, "/editBook"
			, "/editGenre").authenticated()
			.and()
			.formLogin();
//			.and().logout().permitAll();
  }

//  @Override
//  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//	auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password("admin")
//			.roles("ADMIN");
//  }

  @Bean
  public PasswordEncoder passwordEncoder() {
	return new PasswordEncoder() {
	  @Override
	  public String encode(CharSequence charSequence) {
		return charSequence.toString();
	  }

	  @Override
	  public boolean matches(CharSequence charSequence, String s) {
		return charSequence.toString().equals(s);
	  }
	};
  }


}

package springbootemployeemanagement.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfigurationWithJDBC extends WebSecurityConfigurerAdapter{

	@Autowired
	DataSource datasource;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.jdbcAuthentication().dataSource(datasource).withDefaultSchema()
	 .withUser(User.withUsername("venu").password(getPasswordEncoder().encode("venu")).roles("ADMIN"))
	 .withUser(User.withUsername("ravi").password(getPasswordEncoder().encode("ravi")).roles("STAFF"));
	}

	@Bean
	PasswordEncoder getPasswordEncoder() { 
		return new BCryptPasswordEncoder(); 
		}
	
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/h2-console/**");
		}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/Employee-Management/add-employee").hasRole("ADMIN")
		.antMatchers("/","/Employee-Management/info","/Employee-Management/employee-list",
				"/Employee-Management/customInfo","/Employee-Management/asc-employee-list","/Employee-Management/desc-employee-list"
				,"/Employee-Management/employee-by-name/{firstname}","/Employee-Management/delete-employee/{id}",
				"/Employee-Management/employee-by-id/{id}").hasAnyRole("ADMIN","STAFF")
		.anyRequest().authenticated()
		.and().formLogin().loginProcessingUrl("/login").successForwardUrl("/swagger-ui.html").permitAll()
		.and() .logout().logoutSuccessUrl("/login").permitAll()
		.and().cors().disable();
		
		
	} 
	
	
	
}

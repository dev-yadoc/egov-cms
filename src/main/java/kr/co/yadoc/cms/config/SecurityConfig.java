package kr.co.yadoc.cms.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth.requestMatchers("/css/**","/login").permitAll().anyRequest().authenticated())
            .formLogin(form -> form.loginPage("/login").defaultSuccessUrl("/admin",true).permitAll())
            .logout(logout -> logout.logoutSuccessUrl("/login?logout"));
        return http.build();
    }
    @Bean UserDetailsService userDetailsService(){
        return new InMemoryUserDetailsManager(
            User.withUsername("admin").password("{noop}admin1234").roles("ADMIN").build(),
            User.withUsername("operator").password("{noop}operator1234").roles("OPERATOR").build());
    }
}

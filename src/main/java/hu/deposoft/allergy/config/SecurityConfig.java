package hu.deposoft.allergy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http.authorizeHttpRequests(
            (requests) ->
                requests
                    .requestMatchers(
                        "/",
                        "/index.html",
                        "/logout",
                        "/error",
                        "/webjars/**",
                        "/swagger-ui/**",
                        "/static/**",
                        "/v3/api-docs",
                        "/v3/api-docs/**")
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .exceptionHandling(
            e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
        .csrf(AbstractHttpConfigurer::disable)
        .logout(l -> l.logoutSuccessUrl("/").logoutUrl("/logout").permitAll())
        .oauth2Client(Customizer.withDefaults())
        .oauth2Login(Customizer.withDefaults());
    return http.build();
  }
}

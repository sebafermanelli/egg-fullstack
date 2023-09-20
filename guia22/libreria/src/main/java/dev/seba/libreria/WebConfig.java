package dev.seba.libreria;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfig {

  @Bean
  public FilterRegistrationBean<HiddenHttpMethodFilter> hiddenHttpMethodFilter() {
    FilterRegistrationBean<HiddenHttpMethodFilter> registrationBean = new FilterRegistrationBean<>();
    registrationBean.setFilter(new HiddenHttpMethodFilter());
    registrationBean.setOrder(0);
    return registrationBean;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(
            authRequest -> authRequest.requestMatchers("/", "/libro").permitAll().anyRequest().authenticated())
        .formLogin(withDefaults()).build();
  }
}

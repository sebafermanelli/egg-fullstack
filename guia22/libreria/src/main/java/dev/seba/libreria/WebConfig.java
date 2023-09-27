package dev.seba.libreria;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import dev.seba.libreria.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebConfig {

  @Autowired
  public UsuarioService usuarioService;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
  }

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
        .authorizeHttpRequests((authRequest) -> authRequest
            .requestMatchers("/css/*", "/js/*", "/img/*", "/login", "/register").permitAll()
            .requestMatchers("/libro", "/prestamo/activos", "/autor", "/editorial").hasAnyRole("USER", "ADMIN")
            .requestMatchers("/**").hasRole("ADMIN"))
        .formLogin((formLogin) -> formLogin
            .usernameParameter("email")
            .passwordParameter("password")
            .loginPage("/login")
            .loginProcessingUrl("/logincheck")
            .defaultSuccessUrl("/prestamo/activos")
            .permitAll())
        .logout((formLogout) -> formLogout
            .logoutUrl("/logout")
            .logoutSuccessUrl("/")
            .permitAll())
        .build();
  }
}

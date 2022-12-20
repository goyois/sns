package com.sns.security.config;

import com.sns.security.auth.CustomAuthorityUtils;
import com.sns.security.auth.MemberAuthenticationEntryPoint;
import com.sns.security.filter.JwtAuthenticationFilter;
import com.sns.security.filter.JwtVerificationFilter;
import com.sns.security.handler.MemberAccessDeniedHandler;
import com.sns.security.handler.MemberAuthenticationFailureHandler;
import com.sns.security.handler.MemberAuthenticationSuccessHandler;
import com.sns.security.jwt.JwtTokenizer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtTokenizer jwtTokenizer;
    private final CustomAuthorityUtils authorityUtils;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers().frameOptions().sameOrigin()
                .and()
                .csrf().disable()
                .cors(Customizer.withDefaults())
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)   //세션생성x
                .and()
                .formLogin().disable()
                .httpBasic().disable()
                .exceptionHandling()
                .authenticationEntryPoint(new MemberAuthenticationEntryPoint())
                .accessDeniedHandler(new MemberAccessDeniedHandler())
                .and()
                .apply(new CustomFilterConfigurer())
                .and()
                .authorizeHttpRequests(authorize -> authorize
                        .antMatchers(HttpMethod.POST, "/*/members").permitAll()
                        .antMatchers(HttpMethod.PATCH, "/*/members/**").hasRole("USER") //** = member 하위 전부 허용
                        .antMatchers(HttpMethod.GET, "/*/members").hasRole("ADMIN")
                        .antMatchers(HttpMethod.GET, "/*/members/**").hasAnyRole("USER","ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/*/members/**").hasRole("USER")
                        // post 추가
                        .antMatchers(HttpMethod.POST, "/*/posts/**").hasRole("USER")
                        .antMatchers(HttpMethod.PATCH, "/*/posts/**").hasRole("USER")
                        .antMatchers(HttpMethod.GET, "/*/posts").hasRole("USER")
                        .antMatchers(HttpMethod.GET, "/*/posts/**").hasAnyRole("USER","ADMIN")
                        .antMatchers(HttpMethod.DELETE, "/*/posts/**").hasRole("USER")
                        .anyRequest().permitAll());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("*"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST","PATCH","DELETE"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    public class CustomFilterConfigurer extends AbstractHttpConfigurer<CustomFilterConfigurer, HttpSecurity> {
        @Override
        public void configure(HttpSecurity builder) throws Exception {
            AuthenticationManager authenticationManager = builder.getSharedObject(AuthenticationManager.class);
            JwtAuthenticationFilter jwtAuthenticationFilter = new JwtAuthenticationFilter(authenticationManager,jwtTokenizer);
            jwtAuthenticationFilter.setFilterProcessesUrl("/v11/auth/login");
            jwtAuthenticationFilter.setAuthenticationSuccessHandler(new MemberAuthenticationSuccessHandler());  //성공 핸들러메시지
            jwtAuthenticationFilter.setAuthenticationFailureHandler(new MemberAuthenticationFailureHandler());  //실패 핸들러메시지

            JwtVerificationFilter jwtVerificationFilter = new JwtVerificationFilter(jwtTokenizer,authorityUtils);  //인스탄스 생성 후 사용되는 객체를 생성자로 DI

            builder
                    .addFilter(jwtAuthenticationFilter)
                    .addFilterAfter(jwtVerificationFilter, JwtAuthenticationFilter.class);

        }
    }
}

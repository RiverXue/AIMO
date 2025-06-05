package com.aimo.auth.config;

import com.aimo.auth.filter.JwtAuthenticationFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;

@Configuration
public class SecurityConfig {

    // 配置过滤器链
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 关闭 CSRF
                .csrf(csrf -> csrf.disable())
                // 不使用 Session，改为使用 JWT
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                // 配置哪些请求需要认证
                .authorizeHttpRequests(auth -> auth
                        // 放行登录接口和静态资源
                        .requestMatchers("/user/login", "/favicon.ico", "/css/**", "/js/**").permitAll()
                        // 允许所有OPTIONS请求
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        // 其他请求需要认证
                        .anyRequest().authenticated()
                )
                // 添加我们自定义的 JWT 认证过滤器，放在 Spring Security 默认过滤器前
                .addFilterBefore(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                // 出错时的统一返回
                .exceptionHandling(eh -> eh.authenticationEntryPoint(
                        (request, response, authException) -> {
                            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                            response.setContentType("application/json;charset=UTF-8");
                            response.getWriter().write("{\"message\":\"未登录或登录已过期\"}");
                        }
                ));

        return http.build();
    }

    // 获取 AuthenticationManager（登录验证时需要）
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }
}

//Bearer  eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJBSU1PLVVTRVJTIiwidXNlcklkIjoiNCIsInVzZXJuYW1lIjoiand0dGVzdHVzZXIiLCJpYXQiOjE3NDg3NjY0NjIsImV4cCI6MTc0ODg1Mjg2Mn0.EeRZcek4ot60rtRa4xR1Cd8PwbRjsi6LHlXS5DTAsGE
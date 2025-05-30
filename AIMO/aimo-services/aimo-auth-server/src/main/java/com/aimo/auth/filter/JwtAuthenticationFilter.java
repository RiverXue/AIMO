package com.aimo.auth.filter;

import com.aimo.auth.util.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * JWT 认证过滤器
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Override
    // doFilterInternal方法是OncePerRequestFilter类中的一个方法，用于过滤请求,形参的意思是：
    // request：请求对象， response：响应对象， filterChain：过滤器链，用于执行下一个过滤器
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // 1. 从请求头的 Authorization 里取 token，格式通常是 "Bearer eyJxxxxxx..."
        String token = getTokenFromRequest(request);

        // 2. 如果 token 不为空，且 token 没有过期
        if (token != null && !JwtUtils.isExpired(token)) {
            // 3. 解析 token，拿到里面的内容（比如用户名）
            Claims claims = JwtUtils.parseToken(token);
            String username = claims.get("username", String.class);

            // 4. 如果拿到了用户名，就告诉 Spring Security 当前是谁在访问
            if (username != null) {
                // 构造一个认证对象（username + 无密码 + 空权限）
                var authentication = new UsernamePasswordAuthenticationToken(username, null, null);
                // 把这个认证对象放进 SecurityContext 中，后面程序就能知道用户身份了
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        // 5. 继续执行下一个过滤器（相当于让请求继续往下走）
        filterChain.doFilter(request, response);
    }

    // getTokenFromRequest方法是一个工具方法，用于从请求头中获取token，token是用户登录成功后返回的token，用于验证用户的身份
    private String getTokenFromRequest(HttpServletRequest request) {
        // 从请求头拿 Authorization
        String header = request.getHeader("Authorization");

        // 如果请求头存在且以 "Bearer " 开头，就把前缀去掉，拿到纯 token 字符串
        if (header != null && header.startsWith("Bearer ")) {
            return header.substring(7);
        }

        // 这里本来想从请求参数拿 token，但代码写错了，应该是 return token，而不是 return null
        String token = request.getParameter("token");
        return token; // 注意：这里需要改成 return token，不然一直返回 null，拿不到参数里的 token
    }
}

package ssyoni.jwt.example.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.builders.WebSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer
import org.springframework.security.web.SecurityFilterChain

@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun webSecurityCustomizer():WebSecurityCustomizer{
        return WebSecurityCustomizer { web:WebSecurity -> web.ignoring().antMatchers("/h2-console/**", "/favicon.ico") }
    }

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain{
        http
            .authorizeRequests()    // httpServletRequest를 사용하는 요청에 대해 접근 제한을 설정
            .antMatchers("/api/hello").permitAll() // 해당 api에 대해선 인증 없이 접근 허용
            .anyRequest().authenticated()   //  나머지 접근들에 대해서는 인증을 받아야함

        return http.build()
    }
}
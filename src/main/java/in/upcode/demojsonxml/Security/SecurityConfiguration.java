package in.upcode.demojsonxml.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    UserDetailsService getUserDetailsService() {
//        return new TempUserDetailsService();
//    }
//    @Bean
//    PasswordEncoder getPasswordEncoder(){
//        return new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence rawPassword) {
//                System.out.println(String.valueOf(rawPassword)+"----------------------");
//                return String.valueOf(rawPassword);
//            }
//
//            @Override
//            public boolean matches(CharSequence rawPassword, String encodedPassword) {
//                return rawPassword.equals(encodedPassword);
//            }
//        };
//    }
@Bean
public WebSecurityCustomizer webSecurityCustomizer() {
    return (web) -> web.ignoring()
            .requestMatchers(new AntPathRequestMatcher("/**"));
}

}

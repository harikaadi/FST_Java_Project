package com.amaze;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    @Bean
     SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/token").permitAll()
                        .requestMatchers("/auth/signup").permitAll()
                        .requestMatchers("/admin/hello").hasRole("ADMIN")
                        .requestMatchers("/user/hello").hasAnyRole("USER", "ADMIN")
                        .requestMatchers("/employee/add").hasRole("ADMIN")
                        .requestMatchers("/asset/add").hasRole("ADMIN")
                        .requestMatchers("/patient/add").hasAnyRole("PATIENT","ADMIN")
                        .requestMatchers("/doctor/add").hasAnyRole("DOCTOR","ADMIN")
                        .requestMatchers("/doctor/specialization/Cardiology").hasAnyRole("PATIENT","ADMIN")
                        .requestMatchers("/doctor/available").hasAnyRole("PATIENT","ADMIN")
                        .requestMatchers("/room/a").hasAnyRole("PATIENT","ADMIN")
                        .requestMatchers("/room/add").hasRole("ADMIN")
                        .requestMatchers("/healthissue/add").permitAll()
                        .requestMatchers("addadmission/{patientid}/{healthissue}/{roomtype}").permitAll()
                        .requestMatchers("/diagnosis/add/{AdmissionId}").permitAll()
                        .requestMatchers("/test/add/{diagnosid}").permitAll()
                        .requestMatchers("/testinp/add").permitAll()
                        .requestMatchers("/inpatient-test/add/{patientid}/{doctorid}/{testid}").permitAll()
                        .requestMatchers("/testresult/add").permitAll()
                        .requestMatchers("/testresult/add/{inpatienttestid}").permitAll()
                        
                        .anyRequest().authenticated()
                )
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
     AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
     PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
     DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
}

package ci.ada.fitness.config;

import jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)  // Désactiver la protection CSRF pour cette configuration
                .authorizeHttpRequests((authorize) -> authorize
                        .dispatcherTypeMatchers(DispatcherType.FORWARD, DispatcherType.ERROR).permitAll()  // Autoriser les types de requêtes FORWARD et ERROR
                        .requestMatchers("/swagger-ui/**").permitAll()  // Permettre l'accès a swagger
                        .requestMatchers("/v3/api-docs/**").permitAll()  // Permettre l'accès aux ressources icon
                        .requestMatchers("/public/").permitAll()
                        .requestMatchers("/api/**").permitAll()
                        .requestMatchers("/api/authenticate").permitAll()
                        .anyRequest().authenticated()  // Toutes les autres demandes nécessitent une authentification
                )
                .formLogin((login) -> login
                        .loginPage("/login").permitAll()  // Autoriser l'accès à la page de connexion pour tout le monde
                        .defaultSuccessUrl("/api", true)  // Rediriger vers /home après une connexion réussie
                        .failureUrl("/login?error=true")  // Rediriger vers la page de connexion avec une erreur en cas d'échec
                )
                .logout((logout) -> logout
                        .logoutUrl("/logout")  // URL de déconnexion
                        .logoutSuccessUrl("/login?logout=true")  // Rediriger vers la page de connexion après déconnexion
                        .invalidateHttpSession(true)  // Invalider la session après déconnexion
                        .deleteCookies("JSESSIONID")  // Supprimer le cookie de session après déconnexion
                        .permitAll()  // Permettre à chacun de se déconnecter
                )

//                Crée une session d'état pour les utilisateurs se connectant via le formulaire
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED))
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt); //Utiliser OAuth2 pour les API sécurisées via JWT

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

package fh.aalen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Konfigurationsklasse für CORS (Cross-Origin Resource Sharing).
 */
@Configuration
public class CorsConfig {

    /**
     * Definiert die CORS-Konfiguration für die Anwendung.
     * 
     * @return WebMvcConfigurer mit den erlaubten CORS-Einstellungen
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // alle Pfade
                        .allowedOrigins("*") // erlaubt alle Ursprünge (z.B. auch "http://localhost:3000")
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}

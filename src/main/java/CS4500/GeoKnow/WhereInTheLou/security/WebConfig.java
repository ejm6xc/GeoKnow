package CS4500.GeoKnow.WhereInTheLou.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://whereinthelou.azurewebsites.net,96.35.254.161")
                .allowedMethods("GET") //maybe allow adding new locations to the database from the screen?
                .allowCredentials(false).maxAge(3600);
    }
}
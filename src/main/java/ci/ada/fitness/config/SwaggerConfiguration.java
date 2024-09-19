package ci.ada.fitness.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI getOpenAPI() {
        final Info info = new Info()
                .title("Fitness")
                .version("2.0.2")
                .description("These APIs expose mon fitness endpoints");

        return new OpenAPI().info(info);
    }
}

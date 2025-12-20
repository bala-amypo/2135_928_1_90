@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Complaint Duplicate Detector")
                .version("1.0"));
    }
}
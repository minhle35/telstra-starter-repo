package au.com.telstra.simcardactivator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
// This class is used to define beans and configuration settings for the application
// It is annotated with @Configuration to indicate that it provides Spring configuration
// and is a candidate for component scanning
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        // This method creates and returns a RestTemplate bean
        // RestTemplate is used to make HTTP requests in a Spring application
        return new RestTemplate();
    }
}

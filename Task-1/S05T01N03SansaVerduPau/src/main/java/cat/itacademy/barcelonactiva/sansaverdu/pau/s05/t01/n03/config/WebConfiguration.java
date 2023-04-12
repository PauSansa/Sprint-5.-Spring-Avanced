package cat.itacademy.barcelonactiva.sansaverdu.pau.s05.t01.n03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfiguration {
    @Bean
    public WebClient.Builder getWebClientBuilder(){
        return WebClient.builder().baseUrl("http://localhost:9001/flor");
    }
}

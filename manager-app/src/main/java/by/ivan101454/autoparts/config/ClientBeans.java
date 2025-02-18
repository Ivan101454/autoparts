package by.ivan101454.autoparts.config;

import by.ivan101454.autoparts.client.RestClientPartsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientPartsRestClient partsRestClient(
            @Value("${ivan101454.services.catalogue.uri:http://localhost:8081}") String catalogueBaseUri) {
        return new RestClientPartsRestClient(RestClient.builder()
                .baseUrl("http://localhost:8081")
                .build());
    }
}

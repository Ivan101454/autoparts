package by.ivan101454.autoparts.config;

import by.ivan101454.autoparts.client.RestClientPartsRestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestClient;

@Configuration
public class ClientBeans {

    @Bean
    public RestClientPartsRestClient partsRestClient(
            @Value("${ivan101454.services.catalogue.uri:http://localhost:8081}") String catalogueBaseUri,
            @Value("${ivan101454.services.catalogue.username}") String catalogueUsername,
            @Value("${ivan101454.services.catalogue.password}") String cataloguePassword) {
        return new RestClientPartsRestClient(RestClient.builder()
                .baseUrl("http://localhost:8081")
                .requestInterceptor(
                        new BasicAuthenticationInterceptor(catalogueUsername, cataloguePassword))
                .build());
    }
}

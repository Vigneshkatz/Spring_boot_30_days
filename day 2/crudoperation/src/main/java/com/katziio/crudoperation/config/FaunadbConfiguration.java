package com.katziio.crudoperation.config;

import com.faunadb.client.FaunaClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;

@Configuration
public class FaunadbConfiguration {
    @Value("https://db.${fauna.region}.fauna.com/")
    private String faunaUrl;

    @Value("${fauna.secret}")
    private String faunaSecret;

    @Bean
    FaunaClient getFaunaClient()  {
        try {
            return FaunaClient.builder()
                    .withEndpoint(faunaUrl)
                    .withSecret(faunaSecret)
                    .build();
        } catch (MalformedURLException e) {
            return null;
        }
    }
}

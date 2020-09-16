package com.rocketsoftware.product.config;

import com.rocketsoftware.product.service.AccessService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.channels.AcceptPendingException;

@Configuration
public class OAuthConfiguration {


    @Value( "${product.oauth.clientID}" )
    private String clientID;

    @Value( "${product.oauth.clientSecret}" )
    private String clientSecret;

    @Value( "${product.oauth.audience}" )
    private String audience;


    @Value("${product.oauth.domain}")
    private String domain;

    @Bean
    AccessService accessService() {
        final AccessService service = new AccessService();
        service.retrieveAccessToken(clientID,clientSecret,audience,domain);
        return service;
    }


}

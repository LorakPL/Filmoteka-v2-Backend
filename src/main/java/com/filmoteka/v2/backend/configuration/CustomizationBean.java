package com.filmoteka.v2.backend.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.stereotype.Component;

@Component
public class CustomizationBean
        implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    @Value("${application.context}")
    private String contextName;
    @Override
    public void customize(ConfigurableServletWebServerFactory container) {
        container.setContextPath("/" + contextName);
    }
}
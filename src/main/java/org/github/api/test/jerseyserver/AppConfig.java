package org.github.api.test.jerseyserver;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Feature;

@Configuration
@ApplicationPath("/api")
@Primary
public class AppConfig extends ResourceConfig {

//    @Inject
//    @Named("jersey-operational-feature")
//    private Feature jerseyOperationalFeature;

//    @Inject
//    @Qualifier("core-auth-filter")
//    private ContainerRequestFilter coreAuthFilter;

//    @Inject
//    @Qualifier("ets-feature")
//    private Feature etsFeature;

    @PostConstruct
    public void init() {

        //register(jerseyOperationalFeature);
        //register(coreAuthFilter);

        register(MultiPartFeature.class);
        packages("org.github.api.test.jerseyserver");
        this.register(ImageController.class);
    }
}

package be.doji.playground.micro.MicroServiceTest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.inject.Named;

/**
 * Created by Doji on 28/06/2017.
 */
@Configuration public class ApplicationConfiguration {

    /*
     * Dummy class representing the configuration of the Jersey module
     * In a real application this would be used to set up the datasources
     * Jersey is a spring boot ready framework for handling REST calls.
     */
    @Named static class JerseyConfig extends ResourceConfig {

        public JerseyConfig() {
            this.packages("be.doji.playground.micro.MicroServiceTest");
        }
    }
}

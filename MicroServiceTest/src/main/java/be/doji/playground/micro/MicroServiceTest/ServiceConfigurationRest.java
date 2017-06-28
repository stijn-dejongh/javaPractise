package be.doji.playground.micro.MicroServiceTest;

import be.doji.playground.micro.MicroServiceTest.exception.DataNotFoundException;
import be.doji.playground.micro.MicroServiceTest.model.ServiceConfiguration;
import be.doji.playground.micro.MicroServiceTest.model.ServiceIdentifier;
import be.doji.playground.micro.MicroServiceTest.persistence.ConfigurationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * Created by Doji on 28/06/2017.
 */
@Named @Path("/") public class ServiceConfigurationRest {
    @Autowired private ConfigurationService configService;

    @GET @Path("service") @Produces(MediaType.APPLICATION_JSON) public ServiceConfiguration getServiceConfiguration(
            @QueryParam("name") String name, @QueryParam("domain") String domain, @QueryParam("version") String version)
            throws DataNotFoundException {
        ServiceIdentifier id = new ServiceIdentifier(name, version, domain);
        ServiceConfiguration foundConfig = configService.getConfiguration(id);
        return foundConfig;
    }
}

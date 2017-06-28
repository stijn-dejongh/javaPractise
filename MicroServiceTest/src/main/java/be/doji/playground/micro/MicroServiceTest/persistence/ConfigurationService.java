package be.doji.playground.micro.MicroServiceTest.persistence;

import be.doji.playground.micro.MicroServiceTest.exception.DataNotFoundException;
import be.doji.playground.micro.MicroServiceTest.model.ServiceConfiguration;
import be.doji.playground.micro.MicroServiceTest.model.ServiceIdentifier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Doji on 28/06/2017.
 * <p>
 * Class mocking a database access service.
 * In a real application, this class would be coupled to a database access repository.
 */
@Service("configurationService") public class ConfigurationService {

    private static List<ServiceConfiguration> configurations = new ArrayList<>();

    static {
        ServiceConfiguration dummyData = new ServiceConfiguration();
        dummyData.setApplicationDomain("DojiDomain");
        dummyData.setApplicationName("VeryFancyApplication");
        dummyData.setApplicationVersion("02.00.0000");
        Map<String, String> dummyParams = new HashMap<>();
        dummyParams.put("myState", "awesome");
        dummyParams.put("yourState", "impressed");
        dummyData.setConfiguredParameters(dummyParams);

        configurations.add(dummyData);
    }

    public ServiceConfiguration getConfiguration(ServiceIdentifier identifier) throws DataNotFoundException {
        for (ServiceConfiguration config : configurations) {
            if (isCorrectConfig(config, identifier)) {
                return config;
            }
        }
        throw new DataNotFoundException("No data found matching the ssearch terms.");

    }

    private boolean isCorrectConfig(ServiceConfiguration config, ServiceIdentifier identifier) {
        return StringUtils.equalsIgnoreCase(config.getApplicationDomain(), identifier.getDomain()) && StringUtils
                .equalsIgnoreCase(config.getApplicationName(), identifier.getApplicationName()) && StringUtils
                .equalsIgnoreCase(config.getApplicationVersion(), identifier.getApplicationVersion());
    }
}

package be.doji.playground.micro.MicroServiceTest.model;

import java.util.Map;

/**
 * Created by Doji on 28/06/2017.
 */
public class ServiceConfiguration {

    private long id;

    private String applicationVersion;
    private String applicationName;
    private String applicationDomain;
    private Map<String, String> configuredParameters;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationDomain() {
        return applicationDomain;
    }

    public void setApplicationDomain(String applicationDomain) {
        this.applicationDomain = applicationDomain;
    }

    public Map<String, String> getConfiguredParameters() {
        return configuredParameters;
    }

    public void setConfiguredParameters(Map<String, String> configuredParameters) {
        this.configuredParameters = configuredParameters;
    }
}

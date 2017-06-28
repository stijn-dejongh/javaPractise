package be.doji.playground.micro.MicroServiceTest.model;

/**
 * Created by Doji on 28/06/2017.
 */
public class ServiceIdentifier {
    private String applicationName;
    private String applicationVersion;
    private String domain;

    public ServiceIdentifier(String applicationName, String applicationVersion, String domain) {
        this.applicationName = applicationName;
        this.applicationVersion = applicationVersion;
        this.domain = domain;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationVersion() {
        return applicationVersion;
    }

    public void setApplicationVersion(String applicationVersion) {
        this.applicationVersion = applicationVersion;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}

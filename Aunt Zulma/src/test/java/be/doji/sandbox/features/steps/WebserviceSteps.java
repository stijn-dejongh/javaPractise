package be.doji.sandbox.features.steps;


import be.doji.sandbox.soap.SimpleUnsecuredSoapCaller;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import javax.xml.soap.SOAPException;
import org.apache.xmlbeans.XmlException;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.junit.Assert;

public class WebserviceSteps {

  private String endpoint;
  private String response;

  @Given("a webservice on endpoint $location")
  public void webservice(
      @Named("location") String endpoint) {
    this.endpoint = endpoint;
  }

  @Given("request contract requestXsd.xsd")
  public void request() {
    // PENDING
  }

  @Given("response contract responseXsd.xsd")
  public void responseContract() {
    // PENDING
  }

  @When("sending request $requestFileLocation")
  public void sending(String requestFileLocation)
      throws IOException, XmlException, SOAPException {
    Path requestPath = Paths.get(requestFileLocation);
    List<String> strings = Files.readAllLines(requestPath, Charset.defaultCharset());
    StringBuilder request = new StringBuilder();
    for (String string : strings) {
      request.append(string).append(System.lineSeparator());
    }

    this.response = SimpleUnsecuredSoapCaller
        .getResponseFromSource(request.toString(), this.endpoint);
  }

  @Then("the response is xsd valid")
  public void response() {
    Assert.assertFalse("The response was empty", response.isEmpty());
  }
}

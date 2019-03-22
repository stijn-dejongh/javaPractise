package be.doji.sandbox.soap;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject.Factory;
import org.w3c.dom.Document;

public final class SimpleUnsecuredSoapCaller {

  /**
   * Utility classes should not have a public or default constructor
   */
  private SimpleUnsecuredSoapCaller() {
  }

  public static String getResponseFromSource(String request, String endpoint)
      throws SOAPException, XmlException {
    SOAPConnection connection = null;
    String responseText;
    try {
      SOAPConnectionFactory cf = SOAPConnectionFactory.newInstance();
      connection = cf.createConnection();

      SOAPMessage response = connection.call(buildSoapMessage(request), endpoint);
      // Use XmlBeans to change the SOAP message to a simple String
      SOAPHeader soapHeader = response.getSOAPHeader();
      String header = "";
      if(soapHeader != null) {
        header = Factory.parse(soapHeader.getFirstChild()).xmlText();
      }

      SOAPBody soapBody = response.getSOAPBody();
      String body = "";
      if(soapBody != null) {
        body = Factory.parse(soapBody.getFirstChild()).xmlText();
      }

      responseText = header + System.lineSeparator() + body;
    } finally {
      if (connection != null) {
        connection.close();
      }
    }

    return responseText;
  }

  private static SOAPMessage buildSoapMessage(String request) throws SOAPException, XmlException {
    MessageFactory mf = MessageFactory.newInstance();
    SOAPMessage message = mf.createMessage();
    Document requestDocument = (Document) Factory.parse(request).newDomNode();
    message.getSOAPPart().getEnvelope().getBody().addDocument(requestDocument);
    message.saveChanges();
    return message;
  }

}

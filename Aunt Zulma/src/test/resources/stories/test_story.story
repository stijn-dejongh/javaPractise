Meta:

Narrative:
As an EndUser
I want to send a SOAP request to the WebService
So that I can retrieve a response conforming to the disclosed contract

Scenario: Test Story calling DataAccess NumberConversion
Given a webservice on endpoint http://www.dataaccess.com/webservicesserver/numberconversion.wso
Given request contract requestXsd.xsd
Given response contract responseXsd.xsd
When sending request D:\Documents\_development\sandbox\automated_testing\Aunt Zulma\src\test\resources\mockservice\xml\defaultRequest.xml
Then the response is xsd valid

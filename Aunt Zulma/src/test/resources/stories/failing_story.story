Meta:

Narrative:
As an EndUser
I want to send a SOAP request to the WebService
So that I can retrieve a response conforming to the disclosed contract

Scenario: Test Story calling an unexisting webservice
Given a webservice on endpoint http://www.tralalalala.be
Given request contract requestXsd.xsd
Given response contract responseXsd.xsd
When sending request D:\Documents\_development\sandbox\automated_testing\HttpCallWebserviceAutomatedTester\src\test\resources\mockservice\xml\defaultRequest.xml
Then the response is xsd valid

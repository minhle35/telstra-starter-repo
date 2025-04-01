package stepDefinitions;

import au.com.telstra.simcardactivator.SimCardActivator;
import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import au.com.telstra.simcardactivator.model.SimCardActivationResponse;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import static org.junit.jupiter.api.Assertions.*;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = SimCardActivator.class, loader = SpringBootContextLoader.class)
public class SimCardActivatorStepDefinitions {

    @Autowired
    private TestRestTemplate restTemplate;

    private SimCardActivationRequest request;
    private ResponseEntity<SimCardActivationResponse> response;

    @Given("a SIM card activation request with ICCID {string} and email {string}")
    public void givenSimCardActivationRequest(String iccid, String customerEmail) {
        request = new SimCardActivationRequest();
        request.setIccid(iccid);
        request.setCustomerEmail(customerEmail);
    }

    @When("the activation request is sent")
    public void whenActivationRequestIsSent() {
        HttpEntity<SimCardActivationRequest> entity = new HttpEntity<>(request);
        response = restTemplate.postForEntity("/api/simcard/activate", entity, SimCardActivationResponse.class);
    }

    @Then("the response should have status {int}")
    public void thenVerifyResponseStatus(int expectedStatus) {
        assertEquals(expectedStatus, response.getStatusCodeValue());
    }

    @Then("the response should contain ICCID {string}")
    public void thenVerifyResponseIccid(String expectedIccid) {
        assertNotNull(response.getBody());
        assertEquals(expectedIccid, response.getBody().getIccid());
    }

    @Then("the activation should be {string}")
    public void thenVerifyActivationStatus(String expectedStatus) {
        assertNotNull(response.getBody());
        boolean expectedSuccess = expectedStatus.equalsIgnoreCase("successful");
        assertEquals(expectedSuccess, response.getBody().getSuccess());
    }
}

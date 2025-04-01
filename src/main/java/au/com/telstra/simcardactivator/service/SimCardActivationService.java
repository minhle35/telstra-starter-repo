package au.com.telstra.simcardactivator.service;

import au.com.telstra.simcardactivator.model.ActuatorRequest;
import au.com.telstra.simcardactivator.model.ActuatorResponse;
import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import au.com.telstra.simcardactivator.model.SimCardActivationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class SimCardActivationService {

    private static final Logger logger = LoggerFactory.getLogger(SimCardActivationService.class);

    private final RestTemplate restTemplate;
    @Value("${actuator.url}")
    private String actuatorUrl;

    // Constructor injection of RestTemplate
    public SimCardActivationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    /*
     * Activates a SIM card using the provided activation request.
     * @param request The activation request containing the ICCID and customer email.
     * @return A response indicating the success or failure of the activation.
     * @throws IllegalArgumentException if the ICCID is invalid.
     * @throws RuntimeException if an error occurs during activation.
     * @throws Exception if an unexpected error occurs.
     * @throws NullPointerException if the request is null.
     */
    public SimCardActivationResponse activateSimCard(SimCardActivationRequest request) {
        // Simulate activation logic
        logger.info("Activating SIM card with ICCID: {}", request.getIccid());

        try{
            ActuatorRequest actuatorRequest = new ActuatorRequest(request.getIccid());

            // Call the external service to activate the SIM card
            ResponseEntity<ActuatorResponse> responseEntity = restTemplate.postForEntity(actuatorUrl, actuatorRequest, ActuatorResponse.class);
            ActuatorResponse actuatorResponse = responseEntity.getBody();

            if (actuatorResponse == null || !actuatorResponse.isSuccess()) {
                logger.error("Failed to activate SIM card with ICCID: {}", request.getIccid());
                return new SimCardActivationResponse(request.getIccid(), false, "Failed to activate SIM card: Null response or unsuccessful");
            }
        } catch (IllegalArgumentException e) {
            logger.error("Invalid ICCID provided: {}", request.getIccid(), e);
            return new SimCardActivationResponse(request.getIccid(), false, "Invalid ICCID provided");
        } catch (RuntimeException e) {
            logger.error("Error occurred during SIM card activation: {}", e.getMessage(), e);
            return new SimCardActivationResponse(request.getIccid(), false, "Error occurred during activation");
        } catch (Exception e) {
            logger.error("Unexpected error occurred: {}", e.getMessage(), e);
            return new SimCardActivationResponse(request.getIccid(), false, "Unexpected error occurred");
        }
        // If activation is successful, return a success response
        logger.info("SIM card with ICCID: {} activated successfully", request.getIccid());

        return new SimCardActivationResponse(
                request.getIccid(),
                true,
                "SIM card activated successfully"
        );
    }

    public ActuatorResponse checkSimCardStatus(ActuatorRequest request) {
        // Simulate status check logic
        logger.info("Checking status for SIM card with ICCID: {}", request.getIccid());
        return new ActuatorResponse(true);
    }
}



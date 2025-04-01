package au.com.telstra.simcardactivator.controller;

import au.com.telstra.simcardactivator.model.SimCardActivationRequest;
import au.com.telstra.simcardactivator.model.SimCardActivationResponse;
import au.com.telstra.simcardactivator.service.SimCardActivationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/simcard")
/*
 * This class is a Spring REST controller that handles HTTP requests related to SIM card activation.
 * It uses the SimCardActivationService to process activation requests.
 * The class is annotated with @RestController to indicate that it is a RESTful controller,
 * and @RequestMapping to specify the base URL for the controller.
 * The class contains a method to handle POST requests for activating SIM cards.
 */
public class SimCardActivationController {

    private static final Logger logger = LoggerFactory.getLogger(SimCardActivationController.class);

    private final SimCardActivationService simCardActivationService;

    // Constructor injection of SimCardActivationService
    public SimCardActivationController(SimCardActivationService simCardActivationService) {
        this.simCardActivationService = simCardActivationService;
    }

    /*
     * This method handles POST requests to activate a SIM card.
     * It takes a SimCardActivationRequest object as input and returns a ResponseEntity containing the activation response.
     */
    @PostMapping("/activate")
    public ResponseEntity<SimCardActivationResponse> activateSimCard(@RequestBody SimCardActivationRequest request) {
        logger.info("Received request to activate SIM card with ICCID: {}", request.getIccid());
        SimCardActivationResponse response = simCardActivationService.activateSimCard(request);
        return ResponseEntity.ok(response);
    }
}

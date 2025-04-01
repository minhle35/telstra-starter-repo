Feature: Sim Card Activation

  Scenario: Successful activation
    Given a SIM card activation request with ICCID "8944123456789012345" and email "customer@example.com"
    When the activation request is sent
    Then the response should have status 200
    And the response should contain ICCID "8944123456789012345"
    And the activation should be "successful"

  Scenario: Failed activation due to invalid ICCID
    Given a SIM card activation request with ICCID "000000000000000" and email "customer@example.com"
    When the activation request is sent
    Then the response should have status 400
    And the activation should be "failed"

package au.com.telstra.simcardactivator.model;

public class SimCardActivationRequest {
    private String iccid;
    private String customerEmail;

    // Default constructor
    public SimCardActivationRequest() {
    }

    // Parameterized constructor
    public SimCardActivationRequest(String iccid, String customerEmail) {
        this.iccid = iccid;
        this.customerEmail = customerEmail;
    }

    // Getters and Setters
    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    public String getCustomerEmail() {
        return customerEmail;
    }
    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }
}

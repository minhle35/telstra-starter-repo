package au.com.telstra.simcardactivator.model;

public class ActuatorRequest {
    private String iccid;

    // Default constructor
    public ActuatorRequest() {
    }
    // Parameterized constructor
    public ActuatorRequest(String iccid) {
        this.iccid = iccid;
    }
    // Getters and Setters
    public String getIccid() {
        return iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
}

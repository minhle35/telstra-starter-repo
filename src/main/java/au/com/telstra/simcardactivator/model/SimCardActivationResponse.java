package au.com.telstra.simcardactivator.model;

public class SimCardActivationResponse {
    private String iccid;
    private boolean success;
    private String message;

    // Default constructor
    public SimCardActivationResponse() {
    }
    // Parameterized constructor
    public SimCardActivationResponse(String iccid, boolean success, String message) {
        this.iccid = iccid;
        this.success = success;
        this.message = message;
    }
    // Getters and Setters
    public String getIccid() {
        return iccid;
    }
    public void setIccid(String iccid) {
        this.iccid = iccid;
    }
    public Boolean getSuccess() {
        return success;
    }
    public void setSuccess(Boolean success) {
        this.success = success;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

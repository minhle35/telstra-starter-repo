package au.com.telstra.simcardactivator.model;

public class ActuatorResponse {
    private boolean success;

    // Default constructor
    public ActuatorResponse() {
    }

    // Parameterized constructor
    public ActuatorResponse(boolean success) {
        this.success = success;
    }
    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
}

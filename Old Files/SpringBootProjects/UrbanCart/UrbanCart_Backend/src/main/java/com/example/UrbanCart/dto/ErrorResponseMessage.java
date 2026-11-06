package com.example.UrbanCart.dto;

public class ErrorResponseMessage {
    public String  error;
    public long status;

    public ErrorResponseMessage(String error, long status) {
        this.error = error;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public long getStatus() {
        return status;
    }

    public void setStatus(long status) {
        this.status = status;
    }
}

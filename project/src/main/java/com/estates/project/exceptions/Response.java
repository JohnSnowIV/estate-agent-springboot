package com.estates.project.exceptions;

public class Response {
    private long timestamp;
    private String error;
    private int status;
    private String exception;
    private String message;

    public long getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getException() {
        return exception;
    }
    public void setException(String exception) {
        this.exception = exception;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(String format) {
    }
}

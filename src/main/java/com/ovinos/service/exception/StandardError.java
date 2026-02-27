package com.ovinos.service.exception;
import java.time.Instant;

public class StandardError {

    private Instant timestamp;
    private Integer status;
    private String error;

    public StandardError(Instant timestamp, Integer status, String error) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
    }

    public Instant getTimestamp() { return timestamp; }
    public Integer getStatus() { return status; }
    public String getError() { return error; }
}

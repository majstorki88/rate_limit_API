package com.nemanja.greet.model;

import java.time.LocalDateTime;

/**
 * Created by nemanja on 9/17/17.
 */
public class Greet {

    private String ipAddress;
    private LocalDateTime firstAccessDate;
    private int callCounter = 1;

    public Greet(String ipAddress, LocalDateTime firstAccessDate) {
        this.ipAddress = ipAddress;
        this.firstAccessDate = firstAccessDate;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getFirstAccessDate() {
        return firstAccessDate;
    }

    public void setFirstAccessDate(LocalDateTime firstAccessDate) {
        this.firstAccessDate = firstAccessDate;
    }

    public int getCallCounter() {
        return callCounter;
    }

    public void setCallCounter(int callCounter) {
        this.callCounter = callCounter;
    }
}

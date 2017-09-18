package com.nemanja.greet.service;

/**
 * Created by nemanja on 9/17/17.
 */
public interface GreetService {

    int callsLeft(String ipAddress);

    int getCallLimit();
}

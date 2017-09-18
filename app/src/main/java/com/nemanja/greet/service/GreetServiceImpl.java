package com.nemanja.greet.service;

import com.nemanja.greet.model.Greet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Created by nemanja on 9/17/17.
 */
@Service
public class GreetServiceImpl implements GreetService {

    private int callLimit = 10;
    private int timeLimit = 100;
    private Object lock = new Object();
    ConcurrentMap<String, Greet> clientsMap = new ConcurrentHashMap<String, Greet>();

    @Override
    public int callsLeft(String ipAddress) {

        Greet greet = clientsMap.get(ipAddress);

        if (greet != null) {

            LocalDateTime date = LocalDateTime.now();

            if (greet.getCallCounter() < callLimit) {

                greet.setCallCounter(greet.getCallCounter() + 1);

                return callLimit - greet.getCallCounter();
            } else if (Duration.between(greet.getFirstAccessDate(), date).getSeconds() < timeLimit) {

                return 0;
            } else {

                greet.setFirstAccessDate(LocalDateTime.now());
                greet.setCallCounter(1);

                return callLimit - 1;
            }
        }

        greet = new Greet(ipAddress, LocalDateTime.now());

        synchronized (lock) {
            clientsMap.put(ipAddress, greet);
        }

        return callLimit - 1;
    }

    @Override
    public int getCallLimit() {
        return callLimit;
    }
}
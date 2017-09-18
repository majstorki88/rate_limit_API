package com.nemanja.greet.controller;

import com.nemanja.greet.service.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by nemanja on 9/17/17.
 */
@RestController
@RequestMapping(value = "/greeting", produces = MediaType.TEXT_PLAIN_VALUE)
public class GreetController {

    private static final String template = "Hi, %s!";
    private static final String errMessage = "Rate limit exceeded.";

    @Autowired
    private GreetService greetService;

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> greeting(HttpServletRequest request, @PathVariable(value="name") String name) {

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("X-RateLimit-Limit", Integer.toString(greetService.getCallLimit()));

        String ipAddress = request.getRemoteAddr();
        int callsLeft = greetService.callsLeft(ipAddress);
        responseHeaders.set("X-RateLimit-Remaining", Integer.toString(callsLeft));

        if (callsLeft > 0) {

            return new ResponseEntity<String>(String.format(template, name), responseHeaders, HttpStatus.OK);
        }

        return new ResponseEntity<String>(errMessage, responseHeaders, HttpStatus.TOO_MANY_REQUESTS);
    }
}

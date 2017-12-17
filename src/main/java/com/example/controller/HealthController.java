package com.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by erdem on 17.12.2017.
 */
@RestController
@RequestMapping("/health")
public class HealthController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> getStatus() {
        return new ResponseEntity<String>(HttpStatus.OK);
    }

}

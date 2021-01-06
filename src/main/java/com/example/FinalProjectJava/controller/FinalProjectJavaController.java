package com.example.FinalProjectJava.controller;

import com.example.FinalProjectJava.model.PersonCalculator;
import com.example.FinalProjectJava.model.ListValues;
import com.example.FinalProjectJava.service.FinalProjectJavaService;
import com.example.FinalProjectJava.utils.FeatureSwitchConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
public class FinalProjectJavaController {
        private final FinalProjectJavaService finalProjectJavaService;
        private final FeatureSwitchConfig featureSwitchConfig;

        @PostMapping("/start")
        public Object isBelowBarMitzvah(@RequestBody PersonCalculator personCalculator)
        {
            try {
                return finalProjectJavaService.isBelowBarMitzvah(personCalculator);
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
            }
        }

        @GetMapping("/time")
        public Timestamp getTime()
        {
            return finalProjectJavaService.getTime();
        }

        @PostMapping("/{operation}")
        public Object MathOperation(@RequestBody ListValues listvalues, @PathVariable (value = "operation") String operation, @RequestParam double v1)
        {
            try {
                if (featureSwitchConfig.isMathOperationOn()) {
                    return finalProjectJavaService.MathOperation(listvalues, operation, v1);
                } else {
                    return new ResponseEntity<>("No math allowed here.", HttpStatus.SERVICE_UNAVAILABLE);
                }
            } catch (HttpClientErrorException e) {
                return new ResponseEntity<>(e.getMessage(), e.getStatusCode());
            }
        }
    }



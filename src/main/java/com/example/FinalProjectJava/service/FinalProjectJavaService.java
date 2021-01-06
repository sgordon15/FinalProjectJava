package com.example.FinalProjectJava.service;
import com.example.FinalProjectJava.model.PersonCalculator;
import com.example.FinalProjectJava.model.ServerResponse;
import com.example.FinalProjectJava.model.ListValues;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FinalProjectJavaService {


    public ServerResponse isBelowBarMitzvah(PersonCalculator personCalculator) throws HttpClientErrorException {
        ServerResponse serverResponse;

        if (personCalculator.getName() == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED, "A name was not entered.");
        } else if (personCalculator.getAge() < 0 || personCalculator.getAge() > 120) {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "You have entered an invalid age.");
        } else if (personCalculator.getAge() >= 13) {
            serverResponse= ServerResponse.builder().message(String.format(" %s is over the age of Bar Mitzvah", personCalculator.getName())).build();
        } else {
            serverResponse = ServerResponse.builder().message(String.format("%s is not over the age of Bar Mitzvah.", personCalculator.getName())).build();
        }
        return serverResponse;
    }

    public Timestamp getTime()
    {
        return new Timestamp(System.currentTimeMillis());
    }

    public ListValues MathOperation(ListValues listvalues, String operation, double x) throws HttpClientErrorException
    {
        List<Double> newValues;
        switch (operation) {
            case ("add"):
                newValues = listvalues.getValues().stream().map(i -> i += x).collect(Collectors.toList());
                break;
            case ("subtract"):
                newValues = listvalues.getValues().stream().map(i -> i -= x).collect(Collectors.toList());
                break;
            case ("multiply"):
                newValues = listvalues.getValues().stream().map(i -> i *= x).collect(Collectors.toList());
                break;
            case ("divide"):
                newValues = listvalues.getValues().stream().map(i -> i /= x).collect(Collectors.toList());
                break;
            default:
                throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "The operation you entered is not correct.");
        }
        return ListValues.builder().values(newValues).build();
    }
}
package com.thoughtworks.tb.client;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lanzhao on 7/15/14.
 */
public class CalculatorClient {
    @Autowired
    ICalculator calculator = null;


    public String add(String num1,String num2){

        return calculator.add(num1, num2);
    }

}

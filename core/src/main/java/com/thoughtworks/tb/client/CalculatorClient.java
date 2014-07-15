package com.thoughtworks.tb.client;

/**
 * Created by lanzhao on 7/15/14.
 */
public class CalculatorClient {

    ICalculator calculator ;

    public void setCalculator(ICalculator aCalculator){

        calculator = aCalculator;
    }
    public String add(String num1,String num2){

        return calculator.add(num1, num2);
    }

}

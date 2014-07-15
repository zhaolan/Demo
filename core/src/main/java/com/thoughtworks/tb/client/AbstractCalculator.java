package com.thoughtworks.tb.client;

/**
 * Created by lanzhao on 7/14/14.
 */
public abstract class AbstractCalculator implements ICalculator{

    public String check(String num1,String num2){
        Validator validator = new Validator();
        String result = validator.check(num1,num2);
        return result;

    }

}

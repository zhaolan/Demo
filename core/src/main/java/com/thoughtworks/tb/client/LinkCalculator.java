package com.thoughtworks.tb.client;

/**
 * Created by lanzhao on 7/14/14.
 */
public class LinkCalculator extends AbstractCalculator{

    @Override
    public String add(String num1, String num2) {

        if(check(num1,num2)=="OK"){
            return num1 + num2;
        }
        return check(num1,num2);
    }
}

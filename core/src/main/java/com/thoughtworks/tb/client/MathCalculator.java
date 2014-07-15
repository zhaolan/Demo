package com.thoughtworks.tb.client;

/**
 * Created by lanzhao on 7/14/14.
 */
public class MathCalculator extends AbstractCalculator {
    @Override
    public String add(String num1, String num2) {

        if(check(num1,num2)=="OK"){
            int addNum  = Integer.parseInt(num1);
            int toAddNum = Integer.parseInt(num2);
            String addResult = String.valueOf(addNum + toAddNum);
            return addResult;
        }
        return check(num1,num2);
    }

}

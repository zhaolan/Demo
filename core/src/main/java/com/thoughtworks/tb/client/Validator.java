package com.thoughtworks.tb.client;

/**
 * Created by lanzhao on 7/14/14.
 */
public class Validator {
    public String check(String addStr, String toAddStr) {
        int addNum = Integer.parseInt(addStr);
        int toAddNum = Integer.parseInt(toAddStr);
        if(addNum>0&&addNum<100&&toAddNum>0&&toAddNum<100){
            return "OK";
        }
        return "ERROR";
    }
}

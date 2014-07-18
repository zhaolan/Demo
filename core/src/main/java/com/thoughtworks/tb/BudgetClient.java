package com.thoughtworks.tb;


import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lanzhao on 7/16/14.
 */
public class BudgetClient {
    @Autowired
    SQLHandle sqlHandle = null;

    public EmployeeInfo getInfo(String id){
        return sqlHandle.getInfo(id);
    }

    public String getMsg() {
        return sqlHandle.getMsg();
    }
}

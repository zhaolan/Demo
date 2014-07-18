package com.thoughtworks.tb;


import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

/**
 * Created by lanzhao on 7/16/14.
 */
public class BudgetClient {
    @Autowired
    EmbeddedDBHandle sqlHandle = null;

    public EmployeeInfo getInfo(String id,DataSource dataSource){

        return sqlHandle.getInfo(id, dataSource);
    }

    public String getMsg() {
        return sqlHandle.getMsg();
    }
}

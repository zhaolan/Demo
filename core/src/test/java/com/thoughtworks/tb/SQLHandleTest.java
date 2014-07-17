package com.thoughtworks.tb;

import org.junit.Test;
import static org.junit.Assert.assertEquals;



public class SQLHandleTest {
    @Test
    public void sql(){

        SQLHandle sql = new SQLHandle();
        EmployeeInfo msg = sql.getInfo("00002");
        System.out.print(msg.getBuddget());
        assertEquals("lihongjing", msg.getName());
    }





}
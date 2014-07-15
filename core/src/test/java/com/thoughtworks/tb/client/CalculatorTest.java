package com.thoughtworks.tb.client;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by lanzhao on 7/14/14.
 */
public class CalculatorTest {
    @Test
    public void addNum(){
        AbstractCalculator calculator = new MathCalculator();
        String result = calculator.add("12", "23");
        assertEquals("35",result);
    }

    @Test
    public void addString(){
        AbstractCalculator calculator = new LinkCalculator();
        String result = calculator.add("12", "23");
        assertEquals("1223",result);
    }

    @Test
    public void validator(){
        Validator validator = new Validator();
        String result = validator.check("12","23");
        assertEquals("OK",result);

        result = validator.check("1111","12");
        assertEquals("ERROR",result);
    }
}

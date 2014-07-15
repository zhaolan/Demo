package com.thoughtworks.tb.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by lanzhao on 7/15/14.
 */
public class CaculatorApplication {
    public static void main(String[] args){

/*      CalculatorClient calculatorClient = new CalculatorClient();
       calculatorClient.setCalculator(new MathCalculator());
       String result =  calculatorClient.add("12","23");
       System.out.println(result);

       CalculatorClient calculatorClient1 = new CalculatorClient();
       calculatorClient1.setCalculator(new LinkCalculator());
       result = calculatorClient1.add("12","23");
       System.out.println(result);*/

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        CalculatorClient client = (CalculatorClient) context.getBean("clientBean");
        System.out.println(client.add("1","2"));

      //  obj.printHello();

    }
}

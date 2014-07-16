package com.thoughtworks.tb.service;

import com.thoughtworks.tb.client.CalculatorClient;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class HelloSeverlet extends HttpServlet {
 
    private static final long serialVersionUID = 1L;
 
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {



 /*       req.setAttribute("","not exist,please try again");
        req.getRequestDispatcher("index.jsp").forward(req, resp);*/

  /*      ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        CalculatorClient client = (CalculatorClient) context.getBean("clientBean");
*/

        this.getServletContext().getAttribute("hello");
        PrintWriter pw  = resp.getWriter();//得到一个输出流
        ApplicationContext springIoC = (ApplicationContext)this.getServletContext().getAttribute("SpringIoC");
        CalculatorClient client = (CalculatorClient)springIoC.getBean("clientBean");
        pw.println(client.add("60","20"));
        pw.flush();
        pw.close();
    }
 

 
}


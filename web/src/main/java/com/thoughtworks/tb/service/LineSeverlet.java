package com.thoughtworks.tb.service;

import com.thoughtworks.tb.client.CalculatorClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lanzhao on 7/15/14.
 */
public class LineSeverlet extends HttpServlet{
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {



 /*       req.setAttribute("","not exist,please try again");
        req.getRequestDispatcher("index.jsp").forward(req, resp);*/

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");

        CalculatorClient client = (CalculatorClient) context.getBean("clientBean");
        //this.getServletContext().setAttribute();

        PrintWriter pw  = resp.getWriter();//得到一个输出流
        pw.println(client.add("1","2")+this.getServletContext());
        pw.flush();
        pw.close();

    }
}

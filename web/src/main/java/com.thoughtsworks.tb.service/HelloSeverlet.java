package com.thoughtworks.tb.service;

import com.thoughtworks.tb.client.HelloWorld;

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
        HelloWorld hello = new HelloWorld();
        String result = hello.sayHello();

 /*       req.setAttribute("","not exist,please try again");
        req.getRequestDispatcher("index.jsp").forward(req, resp);*/

    PrintWriter pw  = resp.getWriter();//得到一个输出流
    pw.println(result);
    pw.flush();
    pw.close();
    }
 

 
}


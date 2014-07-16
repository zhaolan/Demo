package com.thoughtworks.tb.service;

import com.thoughtworks.tb.client.CalculatorClient;
import org.springframework.context.ApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lanzhao on 7/15/14.
 */
public class CaculatorSeverlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.getServletContext().getAttribute("hello");
        String add = req.getParameter("add");
        String toAdd = req.getParameter("toAdd");

       // PrintWriter pw  = resp.getWriter();//得到一个输出流
        ApplicationContext springIoC = (ApplicationContext)this.getServletContext().getAttribute("SpringIoC");
        CalculatorClient client = (CalculatorClient)springIoC.getBean("clientBean");
        req.setAttribute("caculator",client.add(add,toAdd));
        //req.getRequestDispatcher("hello.jsp").forward(req, resp);
        req.getRequestDispatcher("hello.jsp").forward(req, resp);
      /*  pw.println(client.add(add,toAdd));
        pw.flush();
        pw.close();*/
       // super.doGet(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        this.getServletContext().getAttribute("hello");
        String add = req.getParameter("add");
        String toAdd = req.getParameter("toAdd");
        ApplicationContext springIoC = (ApplicationContext)this.getServletContext().getAttribute("SpringIoC");
        CalculatorClient client = (CalculatorClient)springIoC.getBean("clientBean");
        req.setAttribute("caculator",client.add(add,toAdd));
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}

package com.thoughtworks.tb.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lanzhao on 7/16/14.
 */
public class CaculatorListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext ctx = sce.getServletContext();

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");
        ctx.setAttribute("hello", "hello word");
        ctx.setAttribute("SpringIoC",context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

package com.thoughtworks.tb.service;

import com.thoughtworks.tb.client.CalculatorClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lanzhao on 7/16/14.
 */

@Controller
@RequestMapping("/caculator")
public class CaculatorController {
    @Autowired
    private CalculatorClient client;

    @RequestMapping(method = RequestMethod.POST)

    public String printWelcome(ModelMap model,HttpServletRequest request) {
        String add = request.getParameter("add");
        String toAdd = request.getParameter("toAdd");
        request.setAttribute("caculator",client.add(add,toAdd));
      //  request.getRequestDispatcher("index.jsp");

        return "index";

    }
}

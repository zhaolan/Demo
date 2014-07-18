package com.thoughtworks.tb.service;

import com.thoughtworks.tb.BudgetClient;
import com.thoughtworks.tb.EmployeeInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Created by lanzhao on 7/17/14.
 */
@Controller
@RequestMapping("/budget")
public class BudgetController {
    @Autowired
    private BudgetClient client;

    @Autowired
    DataSource dataSource;

    @RequestMapping(method = RequestMethod.POST)

    public String printWelcome(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String id = request.getParameter("id");
        EmployeeInfo employeeInfo = client.getInfo(id,dataSource);

       if(client.getMsg()==null){
           // System.out.println(client.getMsg());
            request.setAttribute("id", employeeInfo.getId());
            request.setAttribute("name", employeeInfo.getName());
            request.setAttribute("budget", employeeInfo.getBuddget());
            request.setAttribute("cost", employeeInfo.getCost());
            request.setAttribute("remaind",employeeInfo.getRemaind());
            return "showBalance";
        } else{
            request.setAttribute("msg",client.getMsg());
            return "index";
        }



    }


}

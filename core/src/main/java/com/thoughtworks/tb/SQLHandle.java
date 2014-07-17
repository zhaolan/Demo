package com.thoughtworks.tb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by lanzhao on 7/16/14.
 */
public class SQLHandle {


    public EmployeeInfo getInfo(String id) {
        Connection con = SQLMethod.getConnection();
        Statement statement = SQLMethod.getStatement(con);
        String sqlCheck = "select * from employees where EmployeeID = '" + id + "';";
        ResultSet resultCheck = SQLMethod.getRs(statement, sqlCheck);
        Statement statement1 = SQLMethod.getStatement(con);
        String sql = "select * from budget where EmployeeID = '" + id + "';";
        ResultSet result = SQLMethod.getRs(statement1, sql);
        String msg;
        EmployeeInfo employee = new EmployeeInfo();
        try {
            if(!resultCheck.next()){
                msg = "can not find this person,please try again";
            } else{
                employee.setId(id);
                employee.setName(resultCheck.getString("Name"));
                employee.setBuddget(caculatorBudget(resultCheck.getDouble("TWEXP")));
/*                if(result.next()){

                }*/
            }


            }
         catch (SQLException e) {
            e.printStackTrace();
        }


        return employee;
    }

    private int caculatorBudget(double twexp) {
        int budget = 2000;
        if(twexp < 1){
            Calendar ca = Calendar.getInstance();
            int month=ca.get(Calendar.MONTH);
            System.out.println(month);
            //DecimalFormat decimalFormat  = new DecimalFormat("##.0");
            double left = (double)(12-month+1)/12;
            if(left+twexp<1){
                DecimalFormat decimalFormat  = new DecimalFormat("##.0");
                left = Double.parseDouble(decimalFormat.format(left));
                budget = (int)((left+twexp)*2000);
                return budget;
            }
            //left = decimalFormat.format(left);
        }
        System.out.println(budget);
        return budget;

    }
}

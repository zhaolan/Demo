package com.thoughtworks.tb;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by lanzhao on 7/18/14.
 */


public class EmbeddedDBHandle {


    private String msg = null;
    public String getMsg() {
        return msg;
    }


    public EmployeeInfo getInfo(String id,DataSource dataSource){
        msg = null;
        String EXPId = "EXP"+id;
        EmployeeInfo employee = new EmployeeInfo();
        try {
            Connection con = dataSource.getConnection();
            Statement statement = SQLMethod.getStatement(con); String sqlCheck = "select * from employee where EmployeeID = '" + id + "';" ;
            ResultSet resultCheck = SQLMethod.getRs(statement, sqlCheck);
            Statement statement1 = SQLMethod.getStatement(con);
            String sql = "select * from budget where (ExpenseType='Training/Education' or ExpenseType='Books') and EmployeeID = '" + EXPId + "';";
            ResultSet result = SQLMethod.getRs(statement1, sql);

            if(!resultCheck.next()){
                msg = "could not find this person,please try again";
            } else{
                employee.setId(id);
                employee.setName(resultCheck.getString("Name"));
                employee.setBuddget(caculatorBudget(resultCheck.getDouble("TWEXP")));
                double cost = 0;
                while(result.next()){
                    cost +=result.getDouble("CostInHomeCurrency");
                }
                double remaind = (employee.getBuddget()*10-cost*10)/10;
                employee.setCost(cost);
                employee.setRemiand(remaind);
            }
        }catch (SQLException e) {
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
            double left = (double)(12-month+1)/12;
            if(left+twexp<1){
                DecimalFormat decimalFormat  = new DecimalFormat("##.0");
                left = Double.parseDouble(decimalFormat.format(left));
                budget = (int)((left+twexp)*2000);
                return budget;
            }
        }
        return budget;
    }


}

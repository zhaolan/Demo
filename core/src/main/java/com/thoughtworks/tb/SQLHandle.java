package com.thoughtworks.tb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by lanzhao on 7/16/14.
 */
public class SQLHandle {


    private String msg = null;
    public String getMsg() {
        return msg;
    }

    public EmployeeInfo getInfo(String id) {
        msg = null;
        String EXPId = "EXP"+id;
        Connection con = SQLMethod.getConnection();
        Statement statement = SQLMethod.getStatement(con);
        String sqlCheck = "select * from employees where EmployeeID = '" + id + "';";
        ResultSet resultCheck = SQLMethod.getRs(statement, sqlCheck);
        Statement statement1 = SQLMethod.getStatement(con);
        String sql = "select * from budget where (ExpenseType='Training/Education' or ExpenseType='Books') and EmployeeID = '" + EXPId + "';";
        ResultSet result = SQLMethod.getRs(statement1, sql);
        EmployeeInfo employee = new EmployeeInfo();
        try {
            if(!resultCheck.next()){
                msg = "could not find this person,please try again";
            } else{
                employee.setId(id);
                employee.setName(resultCheck.getString("Name"));
                employee.setBuddget(caculatorBudget(resultCheck.getDouble("TWEXP")));
                ArrayList<Borrow> borrows = new ArrayList<Borrow>();
                double cost = 0;
                while(result.next()){
                    cost +=result.getDouble("CostInHomeCurrency");
        /*            String exactInfo = result.getString("ExactInfo");

                    if(!exactInfo.equals("null")&&!exactInfo.equals("")){
                        String[] info = exactInfo.split(",");
                        for(String person : info){
                            //System.out.println("aa");
                            Borrow BInfo = new Borrow();
                            String[] personInfo = person.split(":");
                            BInfo.setName(personInfo[1]);
                            BInfo.setMoney(Double.parseDouble(personInfo[2]));
                           // System.out.println(BInfo.getName()+"--"+BInfo.getMoney());
                            borrows.add(BInfo);

                        }
                    }*/
                }
                double remaind = (employee.getBuddget()*10-cost*10)/10;
                employee.setCost(cost);
                employee.setRemiand(remaind);
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

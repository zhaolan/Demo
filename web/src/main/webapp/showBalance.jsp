<%@ page language="java" pageEncoding="UTF-8" %>
<html>
    <body>
        <h1 style = "color:blue;text-align:center;font-size = 19px">Query Result</h1>
        <div style="background-color:#EEEEEE;width:'100%';color:blue;font-size:16px;">
            <div style="float:left;width:20%; margin:20px 30px" >Name</div>
            <div style="float:left;width:20%; margin:20px 0px">BUDGET</div>
            <div style="float:left;width:20%; margin:20px 0px">COST</div>
            <div style="float:left;width:20%; margin:20px 0px">REMAIND</div>
        </div>

        <%
            String name = request.getAttribute("name").toString();
            String id = request.getAttribute("id").toString();
            String budget = request.getAttribute("budget").toString();
            String cost = request.getAttribute("cost").toString();
            String remaind = request.getAttribute("remaind").toString();


        %>

           <div style="background-color:#EEEEEE;width:'100%';font-size:14px;">
                 <div style="float:left;width:20%; margin:10px 30px" ><%=name%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=budget%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=cost%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=remaind%></div>

           </div>

    </body>
</html>
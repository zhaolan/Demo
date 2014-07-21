<%@ page language="java" pageEncoding="UTF-8" %>
<html>
    `<head>
        <style>
             html,body{
                         background-color:#e6e4db;
                         width:100%;
                         height:100%;
                         margin: 0 auto;
             }
             #head{
             font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                      text-align:center;
                      margin-top:5%;
                      line-height: 20px;
                      color:gray;
             }
             .showDIV{
                 margin: 0 auto;
                 font-family: "Helvetica Neue", Helvetica, Arial, sans-serif;
                          text-align:center;
                          margin-top:5%;
                          line-height: 20px;
                          color:gray;
             }
        </style>

    </head>
    <body>
        <h1 id="head">Query Result</h1>
        <div  class="showDIV">
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

           <div class="showDIV">
                 <div style="float:left;width:20%; margin:10px 30px" ><%=name%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=budget%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=cost%></div>
                 <div style="float:left;width:20%; margin:10px 0px"><%=remaind%></div>

           </div>
           <div style="clear: both;text-align:center;margin-top:10px">
            <input type="button" value="goBack" name="goBack" onclick=" location.href = 'index.jsp';">
           </div>

    </body>
</html>
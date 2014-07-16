<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>CACULATOR</title>
</head>
<body>
<div style="text-align:center;font-size = 20px">

    <form action="caculator" method="post" name="addMethod" id="addMethod"">
        <div style="margin:10px">

            <input type="text" name="add" id="add">
            <span style="margin:5px">+<span>
            <input type="text" name="toAdd" id="toAdd" >

        </div>
        <input type="submit" name="submit" value="submit" style="margin:0px 20px">

    </form>
</div>

<%
    Object msg = request.getAttribute("caculator");
    if(msg!=null){
        msg.toString();
%>
    <div style="color:blue;text-align:center;font-size = 16px">the result is  <%=msg%></div>
<%
     }
%>
</body>
</html>
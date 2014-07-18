<%@ page language="java" pageEncoding="UTF-8"%>
<html>
<head>
    <title>TrainingBudget</title>
    <script type="text/javascript">
             function checkId(){
             var myId = document.getElementById("id").value;
             var re = /^\d{5}$/;
                 if(!re.test(myId)){
                     alert("the id is wrong, please input again");
                     return false;}
                 return true;}
     </script>

     <style  type="text/css">
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
         #searchDiv{
             width:35%;
             height:35%;
             background: #f7f6f3;
             border: 1px solid #e1dfd4;
             margin:6%  auto 2% auto;
             text-align:center;
             font-size : 16px;
             border-radius:8px;
         }
         #idInput{

            border-radius:4px;
            height:25px;
            border-color:#e1dfd4;
            margin-bottom:10px;
         }
         </style>
</head>
<body>
<h1 id="head">Thoughtworks</h1>
<div id="searchDiv">
    <h3 style="color:grey">Budget Query</h3>

    <form action="budget" method="post" name="information" id="information" onsubmit="return checkId()">
        <div style="margin:10px">
            <div style="margin-left:-36%;margin-bottom:10px">id</div>
            <input id="idInput" type="text" name="id" id="id">
        </div>
        <input class="button" type="button" name="cancel" value="cancel" onclick="close();document.write('<n>')" style="margin:0px 30px">
        <input  class="button" type="submit" name="submit" value="submit" style="margin:0px 20px">
    </form>
</div>
<%
    Object msg = request.getAttribute("msg");
    if(msg!=null){
        msg.toString();
%>
        <div style="color:grey;text-align:center;font-size = 16px"><%=msg%></div>
<%
     }

%>

</body>
</html>
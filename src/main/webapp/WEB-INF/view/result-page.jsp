<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 17/05/22
  Time: 4:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Result</title>
</head>
    <body>
        <h1 align="center">Love Calculator</h1>
        <hr/>
        <h2 align="left">The Love Calculator predicts :</h2>
        ${userInfo.userName} and ${userInfo.crushName} are "Friend"
        <br/>
        <br/>
        <br/>
        <a href="/spring_love_calculator_war_exploded/loadEmail">Send result to you email</a>
    </body>
</html>

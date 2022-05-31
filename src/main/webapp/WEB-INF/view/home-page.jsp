<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 17/05/22
  Time: 3:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style type="text/css">
    .error{
        color: red;
        position: fixed;
        text-align: left;
        margin: 2px;
    }
</style>
<html>
<head>
    <title>Love Calculator Home</title>
</head>
<body>
    <h1 align="center">Love Calculator</h1>
    <hr/>
    <form:form action="process-homepage" modelAttribute="userInfo" method="get">
        <div align="center">
            <p>
                <label for="yourName">Your Name : </label>
                <form:input type="text" id="yourName" path="userName"/>
                <form:errors path="userName" cssClass="error"/>
            </p>
            <p>
                <label for="crushName">Crush Name: </label>
                <form:input type="text" id="crushName" path="crushName"/>
                <form:errors path="crushName" cssClass="error"/>
            </p>
            <p>
                <form:checkbox path="acceptTermAndCondition"/>
                <label>Please accept this is only for learning.</label>
                <form:errors path="acceptTermAndCondition" cssClass="error"/>
            </p>
            <input type="submit" value="Calculate">
        </div>
    </form:form>
</body>
</html>

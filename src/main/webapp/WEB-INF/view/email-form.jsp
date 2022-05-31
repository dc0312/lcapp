<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 27/05/22
  Time: 3:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Email Form</title>
</head>
<body>
    <h1>Hi ${username}</h1>
    <h2>Send Result to your email</h2>
    <br/>
    <br/>
    <form:form action="processEmail" method="get" modelAttribute="emailInfo">
        <label>Your Email id : </label>
        <form:input path="email"/>
        <input type="submit" value="send">
    </form:form>
</body>
</html>

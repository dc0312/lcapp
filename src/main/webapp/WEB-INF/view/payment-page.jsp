<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 19/05/22
  Time: 7:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Payment Page</title>
</head>
<body>
    <h1 align="center">Payment Page</h1>
    <form:form action="paymentDetails" method="get" modelAttribute="paymentInfo">
        <div align="center">
            <p>
                <label>Card Number : </label>
                <form:input path="cardInfo"/>
            </p>
            <p>
                <label>Amount : </label>
                <form:input path="amount"/>
            </p>

            <input type="submit" value="Pay Now">
        </div>
    </form:form>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 17/05/22
  Time: 7:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Details</title>
</head>
<body>

    <h1>Please find below the registration details :</h1>
    User : ${usrReg.user}
    <br/>
    User Name : ${usrReg.userName}
    <br/>
    Password : ${usrReg.password}
    <br/>
    Country : ${usrReg.country}
    <br/>
    Hobbies :
    <c:forEach var="temp" items="${usrReg.hobbies}">
        ${temp}
    </c:forEach>
    <br/>
    Gender : ${usrReg.gender}
    <br/>
    Email : ${usrReg.communicationDTO.email}
    <br/>
    Phone : ${usrReg.communicationDTO.phone}
</body>
</html>

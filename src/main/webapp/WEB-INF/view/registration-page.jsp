<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: deepak
  Date: 17/05/22
  Time: 6:45 PM
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
    <title>Registration</title>
</head>
<body>
    <h1 align="center">Please register here</h1>
    <hr/>
    <form:form action="process-registration" method="get" modelAttribute="usrReg">
        <div align="center">
            <label for="user">User : </label>
            <form:input path="user" id="user"/>
            <br/>
            <br/>
            <label for="userName">UserName : </label>
            <form:input path="userName" id="userName"/>
            <form:errors path="userName" cssClass="error"/>
            <br/>
            <br/>
            <label for="passWord">Password : </label>
            <form:input path="password" id="passWord"/>
            <br/>
            <br/>
            <label>Country : </label>
            <form:select path="country">
                <form:option value="Ind" label="India"/>
                <form:option value="Eng" label="England"/>
                <form:option value="Usa" label="USA"/>
                <form:option value="Aus" label="Australia"/>
            </form:select>
            <br/>
            <br/>
            <label>Hobbies : </label>
            Cricket : <form:checkbox path="hobbies" value="cricket"/>
            Reading : <form:checkbox path="hobbies" value="reading"/>
            Travel : <form:checkbox path="hobbies" value="tarvel"/>
            Programming : <form:checkbox path="hobbies" value="programming"/>
            <br/>
            <br/>
            <label>Gender : </label>
            Male : <form:radiobutton path="gender" value="male"/>
            Female : <form:radiobutton path="gender" value="female"/>
            <br/>
            <br/>
            <label>Age : </label>
            <form:input path="age"/>
            <form:errors path="age" cssClass="error"/>
            <br/>
            <br/>
            <div>
                <h1 align="center">Communication Details</h1>
                <br/>
                <label>Email : </label>
                <form:input path="communicationDTO.email"/>
                <form:errors path="communicationDTO.email" cssClass="error"/>
                <br/>
                <br/>
                <label>Phone No : </label>
                <form:input path="communicationDTO.phone"/>
            </div>
            <br/>
            <br/>
            <input type="submit" value="register"/>
        </div>

    </form:form>
</body>
</html>

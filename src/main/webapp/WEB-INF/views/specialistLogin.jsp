<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>specialist login</title>
</head>
<body>
<form:form id="loginForm" modelAttribute="specialistDto" action="register" method="post">
    <table align="center">
        <tr>
            <td>
                <form:label path="username">Username: </form:label>
            </td>
            <td>
                <form:input path="username" name="username" id="username"/>
            </td>
        </tr>
        <tr>
            <td>
                <form:label path="password">Password:</form:label>
            </td>
            <td>
                <form:password path="password" name="password" id="password"/>
            </td>
        </tr>
        <tr>
            <td></td>
            <td align="left">
                <form:button id="login" name="login">Login</form:button>
            </td>
        </tr>

        <tr></tr>
        <tr>
            <td></td>
            <td><a href="index.jsp">Home</a>
            </td>
        </tr>
    </table>
</form:form>
<%--<table align="center">--%>
<%--    <tr>--%>
<%--        <td style="font-style: italic; color: red;">${message}</td>--%>
<%--    </tr>--%>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<%--定制错误页面--%>
<%--<%@ page errorPage="error/500.jsp" %>--%>

<%--显式地声明这是一个错误页面--%>
<%--<%@page isErrorPage="true" %>--%>
<%--<%@page pageEncoding="utf-8" %>--%>

<head>
    <title>Title</title>
</head>
<body>
<%
    int x = 1/0;
%>
</body>
</html>

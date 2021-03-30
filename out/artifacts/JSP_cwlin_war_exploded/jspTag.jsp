<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>1111111</h1>
<%--jsp:include--%>
<%--http://localhost:8080/jspTag.jsp?name=cwlin&age=3--%>
<jsp:forward page="/jspTag2.jsp">
    <jsp:param name="name" value="cwlin"/>
    <jsp:param name="age" value="3"/>
</jsp:forward>
</body>
</html>

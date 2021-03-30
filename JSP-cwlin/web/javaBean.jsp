<%@ page import="com.cwlin.pojo.People" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //People people = new People();
    //people.set();
    //people.get();
%>
<jsp:useBean id="people" class="com.cwlin.pojo.People" scope="page"/>

<jsp:setProperty name="people" property="id" value="1"/>
<jsp:setProperty name="people" property="name" value="cwlin-1"/>
<jsp:setProperty name="people" property="age" value="3"/>
<jsp:setProperty name="people" property="address" value="南京"/>

id: <jsp:getProperty name="people" property="id"/>
姓名: <jsp:getProperty name="people" property="name"/>
年龄: <jsp:getProperty name="people" property="age"/>
地址: <jsp:getProperty name="people" property="address"/>
</body>
</html>

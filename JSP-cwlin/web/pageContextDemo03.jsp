<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    try {
        pageContext.forward("/pageContextDemo01.jsp"); //页面前端转发
    } catch (ServletException e) {
        e.printStackTrace();
    }
    // request.getRequestDispatcher("/pageContextDemo01.jsp").forward(request,response); //后台转发
%>
</body>
</html>

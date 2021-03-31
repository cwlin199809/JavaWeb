<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%
    //不建议在jsp页面写过滤代码
    Object user_session = request.getSession().getAttribute("USER_SESSION");
    if(user_session == null){
        //pageContext.forward("../login.jsp");
        response.sendRedirect("/login.jsp");
    }
%>--%>

<h1>主页</h1>

<p>
    <a href="/servlet/logout">注销</a>
</p>
</body>
</html>

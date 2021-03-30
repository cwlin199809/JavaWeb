<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%--是否禁用EL语句--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--内置对象
<%
    pageContext.setAttribute("name1","cwlin-1号"); //保存的数据只在一个页面中有效
    request.setAttribute("name2","cwlin-2号"); //保存的数据只在一次请求中有效，请求转发会携带这个数据
    session.setAttribute("name3","cwlin-3号"); //保存的数据只在一次会话中有效，从打开浏览器到关闭浏览器
    application.setAttribute("name4","cwlin-4号");  //保存的数据只在服务器中有效，从打开服务器到关闭服务器
%>--%>
<%
    /*pageContext.setAttribute("test","test",PageContext.APPLICATION_SCOPE);
      pageContext.setAttribute("test","test",PageContext.REQUEST_SCOPE);
      pageContext.setAttribute("test","test",PageContext.SESSION_SCOPE);
      pageContext.setAttribute("test","test",PageContext.PAGE_SCOPE);
      PageContext.PAGE_SCOPE控制作用域
    */
    pageContext.setAttribute("name1","pageContext_name01");
    session.setAttribute("name2","session_name02");
    request.setAttribute("name3","request_name03");
    application.setAttribute("name4","application_name04");
%>
<%--脚本片段中的代码，会被原封不动生成到.jsp.java--%>
<%
    //从pageContext取出，通过寻找的方式进行
    //从底层到高层（作用域）: page -> request -> session ->
    String name1 = (String) pageContext.findAttribute("name1");
    String name2 = (String) pageContext.findAttribute("name2");
    String name3 = (String) pageContext.findAttribute("name3");
    String name4 = (String) pageContext.findAttribute("name4");
    String name5 = (String) pageContext.findAttribute("name5"); //不存在
%>

<%--使用EL表达式输出--%>
<h1>取出的值为：</h1>
<h3>${name1}</h3>
<h3>${name2}</h3>
<h3>${name3}</h3>
<h3>${name4}</h3>
<h3>${name5}</h3>
</body>
</html>

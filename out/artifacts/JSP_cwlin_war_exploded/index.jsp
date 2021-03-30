<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%--JSP表达式
    作用：用来将程序的结果输出到客户端
    <%= 变量或者表达式%>
  --%>
  <%= new java.util.Date()%>
  <%= new Date()%>
  <hr>

  <%--JSP脚本片段--%>
  <%
    int sum = 0;
    for (int i = 1; i <=100 ; i++) {
      sum+=i;
    }
    out.println("<h1>Sum="+sum+"</h1>");
  %>
  <hr>

  <%--脚本片段的再实现--%>
  <%
    int x = 10;
    out.println(x);
  %>
  <p>这是一个JSP文档</p>
  <%
    int y = 2;
    out.println(y);
  %>
  <hr>

  <%--在代码嵌入HTML元素--%>
  <% for (int i = 0; i < 5; i++) { %>
      <h1>Hello,World  <%=i%> </h1>
  <% } %>
  <hr>

  <%--JSP声明--%>
  <%!
    static {
      System.out.println("Loading Servlet!");
    }

    private int globalVar = 0;

    public void cwlin(){
      System.out.println("进入了方法cwlin！");
    }
  %>

  <!--HTML注释-->
  <%--JSP注释--%>
  </body>
</html>

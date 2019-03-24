<%@ page import="java.util.List" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 6bart
  Date: 16.03.2019
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h>Proponowane marki piw</h>
<%
    response.setContentType("text/html");
    response.setCharacterEncoding("windows-1250");
    List<String> list = (List<String>) request.getAttribute("brandList");
    if(!list.isEmpty()) {
        for (String brand : list) {
            out.println("<p>" + brand + "</p>");
        }
    }
%>

</body>
</html>

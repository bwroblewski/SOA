<%@ page import="java.util.Date" %>
<%@ page import="javax.xml.crypto.Data" %>
<%--
  Created by IntelliJ IDEA.
  User: 6bart
  Date: 11.03.2019
  Time: 09:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h1> Pierwsza plikacja web w JavaEE</h1>
  <p>witamy na stronie JSP</p>
  <%
  Date tmp = new Date();
  out.print("<h2>" + tmp.toString() + "</h2>");

  %>
  </body>
</html>

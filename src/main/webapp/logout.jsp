<%@ page import="Utils.Car" %>
<%@ page import="Utils.Util" %>
<%@ page import="Utils.Users" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: VShershnev
  Date: 26.02.14
  Time: 12:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
 <%
        Util.setCurrentUser(new Users("", ""));
     Util.orderedCars = new ArrayList<Car>();
%>
Log out complete!
 <br/>
<a href="order.jsp">Back</a>
</body>
</html>

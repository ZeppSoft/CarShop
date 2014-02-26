<%--
  Created by IntelliJ IDEA.
  User: VShershnev
  Date: 24.02.14
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
 Register here:
 <form action="/reg" method="post">
     Login:
     <input type="text" name="login"/> <br/>
     Password:
     <input type="password" name="password"/>
     <br/>
     <input type="submit" value="Submit"/>
 </form>
 <a href="index.jsp">Log In</a>
</body>
</html>

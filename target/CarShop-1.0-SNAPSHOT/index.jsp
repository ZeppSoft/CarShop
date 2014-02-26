<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
  Please login:
  <form action="/login" method="post">
      Login:
      <input type="text" name="login"/> <br/>
      Password:
      <input type="password" name="password"/>
      <br/>
      <input type="submit" value="Submit"/>
  </form>
  <a href="register.jsp">Registration</a>
  </body>
</html>
<%@ page import="AUXL.DB" %>
<%--
  Created by IntelliJ IDEA.
  User: VShershnev
  Date: 24.02.14
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
Car order:
<form action="/order" method="post">
     Model:
    <select name="model">
        <option value="Mercedes-Benz">Mercedes-Benz </option>
        <option value="BMW">BMW</option>
        <option value="Lada">Lada</option>
    </select>
    <br/>
     Hull:
        <select name="hull">
            <option value="Coupe">Coupe </option>
            <option value="Sedan">Sedan</option>
            <option value="Hatchback">Hatchback</option>
        </select>
        <br/>
        Color:
        <select name="color">
            <option value="White">White </option>
            <option value="Black">Black</option>
            <option value="Blue">Blue</option>
            <option value="Red">Red</option>
        </select>
        <br/>
        Hutch:
        <select name="hutch">
            <option value="Hutch">Hutch </option>
            <option value="NoHutch">No Hutch</option>
        </select>
        <br/>



    <input type="submit" value="Submit"/>

</form>

<b>User: </b>
<% out.println(DB.getCurrentUser().getLogin()); %> <br/>
<a href="index.jsp">Log In</a> <br/>
<a href="logout.jsp">Log Out</a> <br/>
<b>Orders:</b>
<% DB.loadOrderXML(DB.getUserFile(DB.currentUser.getLogin())); %>
</body>
</html>

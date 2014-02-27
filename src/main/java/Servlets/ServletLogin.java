package Servlets;

import Utils.Util;
import Utils.Users;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletLogin extends HttpServlet {
    File fileDB = new File("db.dat");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        File readDB = fileDB;
        readDB= Util.userRead(request.getParameter("login"), request.getParameter("password"), fileDB);
        if (readDB==null){
            out.print("User "+request.getParameter("login")+" is not existed. Please register.");

        }
        else {
            out.print("User "+request.getParameter("login")+ " login!");
            Util.setCurrentUser(new Users(request.getParameter("login"), request.getParameter("password")));
            response.sendRedirect("/order");
        }
    }
}

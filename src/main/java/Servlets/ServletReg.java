package Servlets;

import AUXL.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by VShershnev on 24.02.14.
 */
public class ServletReg extends HttpServlet {
    File fileDB = new File("db.dat");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        File writeDB = fileDB;
        writeDB= DB.userWrite(request.getParameter("login"), request.getParameter("password"), fileDB);
        if (writeDB==null){
            out.print("User "+request.getParameter("login")+" is not regestered!. Try else.");
        }
        else {
            out.print("User "+request.getParameter("login")+ " successufully register! Please login now.");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

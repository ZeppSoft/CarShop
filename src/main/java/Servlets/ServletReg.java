package Servlets;

import Utils.Util;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletReg extends HttpServlet {
    File fileDB = new File("db.dat");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String button =null;
        File writeDB = fileDB;
        writeDB= Util.userWrite(request.getParameter("login"), request.getParameter("password"), fileDB);
        if (writeDB==null){
            out.print("User "+request.getParameter("login")+" is not regestered!. Try else.");
        }
        else {
             button = "<html>\n" +
                    "  <head>\n" +
                    "    <title></title>\n" +
                    "  </head>\n" +
                    "  <body>\n" +
                    "  User " +request.getParameter("login")+" successufully register! Please login now."+
                    "  <form action=\"/index.jsp\" method=\"post\">" +
                    "      <input type=\"submit\" value=\"Back\"/>\n" +
                    "  </form>\n" +
                    "  </body>\n" +
                    "</html>";
            out.print(button);
        }
    }
}

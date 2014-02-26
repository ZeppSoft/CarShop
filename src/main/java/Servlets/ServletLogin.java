package Servlets;

import AUXL.DB;
import AUXL.Users;

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
public class ServletLogin extends HttpServlet {
    File fileDB = new File("db.dat");
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // out.print("Test servlet");
       // fileDB= DB.userWrite(request.getParameter("login"), request.getParameter("password"), fileDB);
        File readDB = fileDB;
        readDB= DB.userRead(request.getParameter("login"), request.getParameter("password"), fileDB);
        if (readDB==null){
            out.print("User "+request.getParameter("login")+" is not existed. Please register.");

        }
        else {
            out.print("User "+request.getParameter("login")+ " login!");
            DB.setCurrentUser(new Users(request.getParameter("login"), request.getParameter("password")));
            //response.sendRedirect("/order.jsp");
            response.sendRedirect("/order");
        }
//        int count =0;
//        if (request.getSession(false).getAttribute("count")==null){
//            count=0;
//        }
//        else {
//            count=(Integer)request.getSession().getAttribute("count");
//        }
//        request.getSession().setAttribute("count",++count);
//        out.print("Accessed: "+request.getSession().getAttribute("count"));


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {


    }
}

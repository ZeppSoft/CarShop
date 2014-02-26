package Servlets;

import AUXL.Car;
import AUXL.DB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;


public class ServletOrder extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       PrintWriter out = response.getWriter();



        if (DB.getCurrentUser().getLogin().equals("") && DB.getCurrentUser().getPassword().equals("")){
  //          out.print("You must enter into system!");
            return;
        }
      //  out.println("Car purchased!");
      //  out.println(request.getParameter("model"));
        Car car = new Car();
        car.setModelName(request.getParameter("model"));
        car.setHullType(request.getParameter("hull"));
        car.setColor(request.getParameter("color"));
        car.setIsHatch(request.getParameter("hutch"));

        DB.addOrder(car);

        String button = "<html>\n" +
                "  <head>\n" +
                "    <title></title>\n" +
                "  </head>\n" +
                "  <body>\n" +
                "  Please login:\n" +
                "  <form action=\"\" >\n" +
                "      <input type=\"submit\" value=\"Submit\"/>\n" +
                "  </form>\n" +
                "  <a href=\"register.jsp\">Registration</a>\n" +
                "  </body>\n" +
                "</html>";








        out.print(button);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        //doPost(request,response);

//        String html = "<html>\n" +
//                "  <head>\n" +
//                "    <title></title>\n" +
//                "  </head>\n" +
//                "  <body>";

        String html = "<html>\n" +
                "<head>\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                "Car order:\n" +
                "<form action=\"/order\" method=\"post\">\n" +
                "     Model:\n" +
                "    <select name=\"model\">\n" +
                "        <option value=\"Mercedes-Benz\">Mercedes-Benz </option>\n" +
                "        <option value=\"BMW\">BMW</option>\n" +
                "        <option value=\"Lada\">Lada</option>\n" +
                "    </select>\n" +
                "    <br/>\n" +
                "     Hull:\n" +
                "        <select name=\"hull\">\n" +
                "            <option value=\"Coupe\">Coupe </option>\n" +
                "            <option value=\"Sedan\">Sedan</option>\n" +
                "            <option value=\"Hatchback\">Hatchback</option>\n" +
                "        </select>\n" +
                "        <br/>\n" +
                "        Color:\n" +
                "        <select name=\"color\">\n" +
                "            <option value=\"White\">White </option>\n" +
                "            <option value=\"Black\">Black</option>\n" +
                "            <option value=\"Blue\">Blue</option>\n" +
                "            <option value=\"Red\">Red</option>\n" +
                "        </select>\n" +
                "        <br/>\n" +
                "        Hutch:\n" +
                "        <select name=\"hutch\">\n" +
                "            <option value=\"Hutch\">Hutch </option>\n" +
                "            <option value=\"NoHutch\">No Hutch</option>\n" +
                "        </select>\n" +
                "        <br/>\n" +
                "\n" +
                "\n" +
                "\n" +
                "    <input type=\"submit\" value=\"Submit\"/>\n" +
                "\n" +
                "</form>";

        html+="<b>User: "+(DB.getCurrentUser().getLogin())+"</b><br/>";
        html+="<a href=\"index.jsp\">Log In</a> <br/>\n" +
                "<a href=\"logout.jsp\">Log Out</a> <br/>\n" +
                "<b>Orders:</b><br/>";
        html+= DB.makeHTMLOrder();
        html+="</body>\n" +
                "</html>";
        out.print(html);
    }

    @Override
    public void init() throws ServletException {
        //super.init();
      //  DB.orderedCars = new ArrayList<Car>();
        DB.loadOrderXML(DB.getUserFile(DB.currentUser.getLogin()));
    }

    @Override
    public void destroy() {
       // super.destroy();
        DB.saveOrderXML(DB.getUserFile(DB.currentUser.getLogin()));
        File f = new File("Order.xml");
        if (f.exists())
            f.delete();
    }
}

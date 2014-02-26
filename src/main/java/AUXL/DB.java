package AUXL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by VShershnev on 24.02.14.
 */
public  class DB {
    public static List<Car> orderedCars =new ArrayList<Car>();
    public static Users currentUser =new Users("","");
    public static File userWrite(String login, String password, File source){
        File file = source;
        FileOutputStream fos = null;
        ObjectOutputStream os = null;

        if (file==null || !file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        List<Users> us = loadUsers(source);
          us.add(new Users(login,password));
          boolean res = saveUsers(us,source);
        if (res){
            return file;
        }
        else {
            return null;
        }


    }

    public static File userRead(String login, String password, File source){
        List<Users> us = loadUsers(source);
        if (us.isEmpty()){
            return null;
        }
        else {
            for (Users u: us){
                if (u.getLogin().equals(login) && u.getPassword().equals(password))
                    return source;
            }
        }
        return null;
    }
    public static List<Users> loadUsers(File source){
        List<Users> users = new ArrayList<Users>();
        ObjectInputStream is = null;
        FileInputStream fs = null;

        try {
            fs = new FileInputStream(source);
            is = new ObjectInputStream(fs);
            while (fs.available()>0){
                users.add((Users)is.readObject());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        return users;
    }

    public static boolean saveUsers(List<Users> usersList, File source){

        if (usersList.isEmpty())
            return false;
        else {
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(source));
                for (Users u:usersList){
                    os.writeObject(u);
                }
            } catch (IOException e) {
                e.printStackTrace();
                return  false;
            }

        }

        return  true;
    }
  //  public static boolean saveOrderXML(List<Car> cars, File source){
  public static boolean saveOrderXML(File source){

        JAXBContext jc = null;
        Order order = new Order();
        Marshaller m = null;
        if (!source.exists()){
            try {
                source.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
             jc = JAXBContext.newInstance(Order.class);
            m=jc.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
            m.setProperty(Marshaller.JAXB_FRAGMENT, true);
            order.setCarList(orderedCars);
            m.marshal(order,source);
//            for (Car c:cars){
//               // m.marshal(c,System.out);
//                m.marshal(c,source);
//            }



        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean loadOrderXML(File source){
        if (!source.exists()){
            return false;
        }
        JAXBContext jc1 = null;
        Unmarshaller unmarshaller =null;
        InputStream stream =null;
        Order order =null;
        Object tst = null;
        try {
             jc1 = JAXBContext.newInstance(Order.class);
             unmarshaller =jc1.createUnmarshaller();
            stream = new FileInputStream(source);
             order =(Order)unmarshaller.unmarshal(stream);
           // tst =unmarshaller.unmarshal(stream);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        if (order==null){
            return false;
        }
        else {
            for (Car c:order.getCarList()){
                orderedCars.add(c);
            }
        }

        return true;
    }
    public static boolean addOrder(Car car){
        orderedCars.add(car);
        return true;
    }

    public static Users getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(Users currentUser) {
        DB.currentUser = currentUser;
    }

    public static File getUserFile(String login){
        return new File(login+"Order.xml");
    }
    public static String makeHTMLOrder(){
        String res = "<table border=\"1\" >";
        for (Car c: orderedCars){
            res+="<tr> <td>"+c.getModelName()+" "+c.getColor()+" "+c.getHullType()+ " "+c.getIsHatch()+ "</td></tr>";
        }
        res+="</table>";

        return res;
    }
}

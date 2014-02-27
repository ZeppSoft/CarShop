import Utils.Car;
import Utils.Util;
import Utils.Users;
import org.junit.Assert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Test {
    File tst = new File("tst.dat");
    File order = new File("order.dat");
    List<Users> usr = new ArrayList<Users>();
    @org.junit.Test
    public void userWriteTest() throws  Exception{
        tst = Util.userWrite("user", "user", tst);
        Assert.assertNotNull(tst);
    }
    @org.junit.Test
    public void userReadTest() throws Exception{
        tst = Util.userRead("user", "user", tst);
        Assert.assertNotNull(tst);
    }

    @org.junit.Test
    public void saveUsersTest() throws Exception{
        usr.add(new Users("user","user"));
        boolean res = Util.saveUsers(usr, tst);
        Assert.assertTrue(res);
    }
    @org.junit.Test
    public void saveOrderXMLTest() throws Exception{
        boolean res = Util.saveOrderXML(order);
        Assert.assertTrue(res);
    }

    @org.junit.Test
    public void addOrderTest() throws Exception{
        Car car = new Car();
        car.setHullType("Sedan");
        car.setIsHatch("NoHutch");
        car.setColor("Grey");
        car.setModelName("Toyota");
        boolean res = Util.addOrder(car);
        Assert.assertTrue(res);
    }
    @org.junit.Test
    public void getCurrentUserTest() throws Exception{
        Users users = Util.getCurrentUser();
        Assert.assertNotNull(users);
    }
    @org.junit.Test
    public void getUserFileTest() throws Exception{
        File newFile = Util.getUserFile("admin");
        Assert.assertNotNull(newFile);
    }
    @org.junit.Test
    public void makeHTMLOrderTest() throws Exception{
        String str = Util.makeHTMLOrder();
        Assert.assertNotNull(str);
    }
    @org.junit.Test
    public void loadOrderXMLTest() throws Exception{
        boolean res = Util.loadOrderXML(order);
        Assert.assertTrue(res);
    }
    @org.junit.Test
    public void loadUsersTest() throws Exception{
        usr = Util.loadUsers(tst);
        Assert.assertNotNull(usr);
    }
}

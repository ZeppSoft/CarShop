package AUXL;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;
@XmlType
@XmlRootElement
public class Order {
private     List<Car> carList;

    public Order() {
        carList=new ArrayList<Car>();
    }
    @XmlElementWrapper(name = "cars")
    @XmlElement(name="car")
    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }
}

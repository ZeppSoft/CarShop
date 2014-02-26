package AUXL;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlRootElement(name = "tst")
@XmlSeeAlso({Order.class})
public class Car {
    private String modelName;
    private String hullType;
    private String color;
    private String isHatch;



    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getHullType() {
        return hullType;
    }

    public void setHullType(String hullType) {
        this.hullType = hullType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getIsHatch() {
        return isHatch;
    }

    public void setIsHatch(String isHatch) {
        this.isHatch = isHatch;
    }
}

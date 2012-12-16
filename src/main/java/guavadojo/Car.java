package guavadojo;
import java.io.Serializable;

public class Car implements Serializable {


    private String brand;

    private String color;

    private boolean sportCar;



    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }


    public Car(String brand, String color, boolean sportCar) {
        this.brand = brand;
        this.color = color;
        this.sportCar = sportCar;
    }

    public boolean isSportCar() {

        return sportCar;
    }

    public void setSportCar(boolean sportCar) {
        this.sportCar = sportCar;
    }
}

package carServiceSystem.car;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;




@Entity(name = "car_details")
public class Car {
    protected Car(){

    }
    @Id
    @GeneratedValue
    private Long id;

    @Size(min=2, message = "Brand should have atleast 2 characters")
    private String brand;
    @Size(min=2, message = "Type should have atleast 2 characters")
    private String type;
    @Size(min=2, message = "Model should have atleast 2 characters")
    private String model;
    private String gasType;

    private Long millage;

    public Car(Long id, String brand, String type, String model, String gasType, Long millage) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.model = model;
        this.gasType = gasType;
        this.millage = millage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGasType() {
        return gasType;
    }

    public void setGasType(String gasType) {
        this.gasType = gasType;
    }

    public Long getMillage() {
        return millage;
    }

    public void setMillage(Long millage) {
        this.millage = millage;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", model='" + model + '\'' +
                ", gasType='" + gasType + '\'' +
                ", millage=" + millage +
                '}';
    }
}

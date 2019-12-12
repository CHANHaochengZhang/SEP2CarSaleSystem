package model.carModel;

import java.io.Serializable;
/**
 *  Class which contains all match information regarding a car.
 *
 *
 * @author Haocheng
 * @version 4
 */
public class Car implements Serializable {

    private static final long serialVersionUID = 4569773286601042523L;
    private String name;
    private String brand;
    private Model model;
    private int price;
    private int yearOfProduction;
    private int maximumCapacityOfCar;
    private int averageFuelConsumption;
    private int weight;
    private int maximumLoadCapacity;
    private int topSpeed;
    private String typeOfTransmission;
    private int sellerNo;
    private int mileAge;
    private String description;

    public Car() {
    }

    public Car(String name, String brand, Model model, int price, int yearOfProduction, int maximumCapacityOfCar, int averageFuelConsumption, int weight, int maximumLoadCapacity, int topSpeed, String typeOfTransmission, int mileAge, String description, int sellerNo) {
        this.name = name;
        this.brand = brand;
        this.model = model;
        this.price = price;
        this.yearOfProduction = yearOfProduction;
        this.maximumCapacityOfCar = maximumCapacityOfCar;
        this.averageFuelConsumption = averageFuelConsumption;
        this.weight = weight;
        this.maximumLoadCapacity = maximumLoadCapacity;
        this.topSpeed = topSpeed;
        this.typeOfTransmission = typeOfTransmission;
        this.mileAge = mileAge;
        this.description = description;
        this.sellerNo = sellerNo;
    }

    public Car(Car car) {
        this.name = car.name;
        this.brand = car.brand;
        this.model = car.model;
        this.price = car.price;
        this.yearOfProduction = car.yearOfProduction;
        this.maximumCapacityOfCar = car.maximumCapacityOfCar;
        this.averageFuelConsumption = car.averageFuelConsumption;
        this.weight = car.weight;
        this.maximumCapacityOfCar = car.maximumCapacityOfCar;
        this.topSpeed = car.topSpeed;
        this.typeOfTransmission = car.typeOfTransmission;
        this.mileAge = car.mileAge;
        this.description = car.description;
        this.sellerNo = car.sellerNo;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public void setMaximumCapacityOfCar(int maximumCapacityOfCar) {
        this.maximumCapacityOfCar = maximumCapacityOfCar;
    }

    public void setAverageFuelConsumption(int averageFuelConsumption) {
        this.averageFuelConsumption = averageFuelConsumption;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMaximumLoadCapacity(int maximumLoadCapacity) {
        this.maximumLoadCapacity = maximumLoadCapacity;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    public void setTypeOfTransmission(String typeOfTransmission) {
        this.typeOfTransmission = typeOfTransmission;
    }

    public void setSellerNo(int sellerNo) {
        this.sellerNo = sellerNo;
    }

    public void setMileAge(int mileAge) {
        this.mileAge = mileAge;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Model getModel() {
        return model;
    }

    public int getPrice() {
        return price;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getMaximumCapacityOfCar() {
        return maximumCapacityOfCar;
    }

    public int getAverageFuelConsumption() {
        return averageFuelConsumption;
    }

    public int getWeight() {
        return weight;
    }

    public int getMaximumLoadCapacity() {
        return maximumLoadCapacity;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public String getTypeOfTransmission() {
        return typeOfTransmission;
    }

    public int getSellerNo() {
        return sellerNo;
    }

    public int getMileAge() {
        return mileAge;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", model=" + model +
                ", price=" + price +
                ", yearOfProduction=" + yearOfProduction +
                ", maximumCapacityOfCar=" + maximumCapacityOfCar +
                ", averageFuelConsumption=" + averageFuelConsumption +
                ", weight=" + weight +
                ", maximumLoadCapacity=" + maximumLoadCapacity +
                ", topSpeed=" + topSpeed +
                ", typeOfTransmission='" + typeOfTransmission + '\'' +
                ", sellerNo=" + sellerNo +
                ", mileAge=" + mileAge +
                ", description='" + description + '\'' +
                '}';
    }
}

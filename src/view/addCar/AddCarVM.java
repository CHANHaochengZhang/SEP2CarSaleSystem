package view.addCar;

import javafx.beans.property.*;
import javafx.scene.control.TextField;
import model.ClientModel;
import model.carModel.Car;
import model.carModel.Model;

public class AddCarVM {

    private Model model;
    private StringProperty price, carName, yearOfProduction, mileage, brand, transmission, maxCapacity, fuelConsumption, weight, maxLoadCapacity, topSpeed, description;
    private ClientModel clientModel;

    public AddCarVM(ClientModel clientModel) {
        this.clientModel = clientModel;

        carName = new SimpleStringProperty();
        yearOfProduction = new SimpleStringProperty();
        mileage = new SimpleStringProperty();
        brand = new SimpleStringProperty();
        transmission = new SimpleStringProperty();
        maxCapacity = new SimpleStringProperty();
        fuelConsumption = new SimpleStringProperty();
        weight = new SimpleStringProperty();
        maxLoadCapacity = new SimpleStringProperty();
        topSpeed = new SimpleStringProperty();
        description = new SimpleStringProperty();
        price = new SimpleStringProperty();


    }


    public void addNewCar() {

        String name = carName.getValue();
        String bran = brand.getValue();
        int pr = Integer.valueOf(price.getValue());
        int year = Integer.valueOf(yearOfProduction.getValue());
        int mcc = Integer.valueOf(maxCapacity.getValue());
        int fuel = Integer.valueOf(fuelConsumption.getValue());
        int we = Integer.valueOf(weight.getValue());
        int mlc = Integer.valueOf(maxLoadCapacity.getValue());
        int spe = Integer.valueOf(topSpeed.getValue());
        String tot = transmissionProperty().getValue();
        String des = description.getValue();
        int ma = Integer.valueOf(mileage.getValue());
        int sellerNo = clientModel.getCurrentUser();
        Model mo = model;


        Car car = new Car(name, bran, mo, pr, year, mcc, fuel, we, mlc, spe, tot, ma, des, sellerNo);
        clientModel.addCar(car);

    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public StringProperty carNameProperty() {
        return carName;
    }

    // force the field to be numeric only
      void numeric(TextField textField) {


        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }

        });
    }

    public StringProperty priceProperty() {
        return price;
    }

    public StringProperty yearOfProductionProperty() {
        return yearOfProduction;
    }

    public StringProperty mileageProperty() {
        return mileage;
    }

    public StringProperty brandProperty() {
        return brand;
    }

    public StringProperty transmissionProperty() {
        return transmission;
    }


    public StringProperty maxCapacityProperty() {
        return maxCapacity;
    }

    public StringProperty fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public StringProperty weightProperty() {
        return weight;
    }

    public StringProperty maxLoadCapacityProperty() {
        return maxLoadCapacity;
    }

    public StringProperty topSpeedProperty() {
        return topSpeed;
    }

    public StringProperty descriptionProperty() {
        return description;
    }
}

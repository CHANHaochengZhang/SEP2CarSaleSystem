package view.viewCar;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.ClientModel;
import model.carModel.Car;

import java.beans.PropertyChangeEvent;

public class ViewCarVM {
    private ClientModel clientModel;
    private StringProperty keyword;

    private int lowerPrice, upperPrice, lowerMile, upperMile;

    private ObservableList<Car> cars = FXCollections.observableArrayList();

    public ViewCarVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        keyword = new SimpleStringProperty();

    }

    public void updateTableContent() {
        if (clientModel.getAllCars() != null) {
            cars.clear();
            cars.addAll(clientModel.getAllCars());
        }
    }


    public void setFilteredData() {
        cars.clear();
        cars.addAll(clientModel.filterByWord(keyword.getValue()));
    }


    public ObservableList<Car> getCars() {
        return cars;
    }


    public StringProperty keywordProperty() {
        return keyword;
    }

    public void setCar(Car car) {
        clientModel.setClickedCar(car);
    }

    public void setPriceRange(int lowerPrice, int upperPrice) {
        this.lowerPrice = lowerPrice;
        this.upperPrice = upperPrice;
    }

    public void setMileAgeRange(int lowerMile, int upperMile) {
        this.lowerMile = lowerMile;
        this.upperMile = upperMile;
    }

    public void rangeFilter() {
        cars.clear();
        cars.addAll(clientModel.filter(lowerPrice, upperPrice, lowerMile, upperMile));
    }
}

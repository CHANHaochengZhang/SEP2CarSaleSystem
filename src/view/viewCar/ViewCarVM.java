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

    private ObservableList<Car> cars = FXCollections.observableArrayList();
    private ObservableList<Car> keywordCars = FXCollections.observableArrayList();


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

    public ObservableList<Car> getKeywordCars() {
        return keywordCars;
    }

    public String getKeyword() {
        return keyword.get();
    }

    public StringProperty keywordProperty() {
        return keyword;
    }
}

package view.addCar;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.carModel.Model;

public class AddCarController {

    private ViewHandler viewHandler;
    private AddCarVM viewModel;


    @FXML
    private TextField carName;
    @FXML
    private Label mileage;
    @FXML
    private TextField yearOfProduction;
    @FXML
    private TextField brand;
    @FXML
    private TextField typeOfTransmission;
    @FXML
    private TextField maxCapacity;
    @FXML
    private TextField fuelConsumption;
    @FXML
    private TextField weight;
    @FXML
    private TextField maxLoadCapacity;
    @FXML
    private TextField topSpeed;
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<Model> modelType;


    public void init(AddCarVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
    }

    public void SaveButton(ActionEvent actionEvent) {
    }

    public void CancelButton(ActionEvent actionEvent) {
    }
}

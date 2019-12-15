package view.addCar;


import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.carModel.Model;

public class AddCarController {




    private ViewHandler viewHandler;
    private AddCarVM viewModel;

    @FXML
    private TextField price;
    @FXML
    private TextField carName;
    @FXML
    private TextField mileage;
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
        modelType.getItems().addAll(Model.Convertible, Model.Coupe, Model.Crossover, Model.Hatchback, Model.Mini, Model.Mpv, Model.Pickup, Model.Sedan, Model.SUV, Model.Wagon, Model.other);

        viewHandler = vh;
        viewModel = vm;
        price.textProperty().bindBidirectional(viewModel.priceProperty());
        carName.textProperty().bindBidirectional(viewModel.carNameProperty());
        mileage.textProperty().bindBidirectional(viewModel.mileageProperty());
        yearOfProduction.textProperty().bindBidirectional(viewModel.yearOfProductionProperty());
        brand.textProperty().bindBidirectional(viewModel.brandProperty());
        typeOfTransmission.textProperty().bindBidirectional(viewModel.transmissionProperty());
        maxCapacity.textProperty().bindBidirectional(viewModel.maxCapacityProperty());
        fuelConsumption.textProperty().bindBidirectional(viewModel.fuelConsumptionProperty());
        weight.textProperty().bindBidirectional(viewModel.weightProperty());
        maxLoadCapacity.textProperty().bindBidirectional(viewModel.maxLoadCapacityProperty());
        topSpeed.textProperty().bindBidirectional(viewModel.topSpeedProperty());
        description.textProperty().bindBidirectional(viewModel.descriptionProperty());

        viewModel.numeric(price);
        viewModel.numeric(mileage);
        viewModel.numeric(yearOfProduction);
        viewModel.numeric(maxCapacity);
        viewModel.numeric(fuelConsumption);
        viewModel.numeric(weight);
        viewModel.numeric(maxLoadCapacity);
        viewModel.numeric(topSpeed);

    }

    public void SaveButton(ActionEvent actionEvent) {
        Alert addAlert = new Alert(Alert.AlertType.CONFIRMATION,
                "You have already add the information of your car\n" +
                        "Do you want to add the car to the system?",
                ButtonType.YES, ButtonType.NO);
        addAlert.setTitle("AddCar confirmation");
        addAlert.setHeaderText(null);

        addAlert.showAndWait();


        if (addAlert.getResult() == ButtonType.YES) {
            if (price.getText() == null || carName.getText() == null || mileage.getText() == null || yearOfProduction.getText() == null || brand.getText() == null || typeOfTransmission.getText() == null || maxCapacity.getText() == null || fuelConsumption.getText() == null || weight.getText() == null || maxLoadCapacity.getText() == null || topSpeed.getText() == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error of adding car");
                alert.setHeaderText("Something wrong with car information");
                alert.setContentText("Please check");
                alert.showAndWait();
            } else if (description.getText() == null) {
                description.setText("");
            } else {
                getCarModel();
                viewModel.addNewCar();
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Create new car Successfully");
                alert.setHeaderText("Create new car Successfully");
                alert.setContentText("You can find your car in the car list");
                alert.showAndWait();
            }
        }
    }

    public void CancelButton(ActionEvent actionEvent) {
        viewHandler.closeCar();
    }

    public void getCarModel() {
        if (modelType.getValue().equals(Model.Convertible)) {
            viewModel.setModel(Model.Convertible);
        } else if (modelType.getValue().equals(Model.Coupe)) {
            viewModel.setModel(Model.Coupe);
        } else if (modelType.getValue().equals(Model.Crossover)) {
            viewModel.setModel(Model.Crossover);
        } else if (modelType.getValue().equals(Model.Hatchback)) {
            viewModel.setModel(Model.Hatchback);
        } else if (modelType.getValue().equals(Model.Mini)) {
            viewModel.setModel(Model.Mini);
        } else if (modelType.getValue().equals(Model.Mpv)) {
            viewModel.setModel(Model.Mpv);
        } else if (modelType.getValue().equals(Model.Pickup)) {
            viewModel.setModel(Model.Pickup);
        } else if (modelType.getValue().equals(Model.Sedan)) {
            viewModel.setModel(Model.Sedan);
        } else if (modelType.getValue().equals(Model.SUV)) {
            viewModel.setModel(Model.SUV);
        } else if (modelType.getValue().equals(Model.VAN)) {
            viewModel.setModel(Model.VAN);
        } else if (modelType.getValue().equals(Model.Wagon)) {
            viewModel.setModel(Model.Wagon);
        } else viewModel.setModel(Model.other);
    }


}

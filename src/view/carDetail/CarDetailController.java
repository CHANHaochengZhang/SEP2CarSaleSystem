package view.carDetail;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class CarDetailController {

    private ViewHandler viewHandler;
    private CarDetailVM viewModel;

    @FXML
    private Text sellerName;
    @FXML
    private Text sellerPhone;
    @FXML
    private Text sellerAddress;
    @FXML
    private Text priceOfCar;
    @FXML
    private Text carName;
    @FXML
    private Text yearOfProduction;
    @FXML
    private Text mileage;
    @FXML
    private Text typeOfTransmission;
    @FXML
    private Text carModels;
    @FXML
    private Text maxCapacity;
    @FXML
    private Text fuelConsumption;
    @FXML
    private Text maxLoadCapacity;
    @FXML
    private Text topSpeed;
    @FXML
    private Text description;
    @FXML
    private Text weight;
    @FXML
    private Text brand;

    public void init(CarDetailVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;
    }

    public void openTalkingView(ActionEvent actionEvent) {
    }

    public void backToCarList(ActionEvent actionEvent) {
    }
}

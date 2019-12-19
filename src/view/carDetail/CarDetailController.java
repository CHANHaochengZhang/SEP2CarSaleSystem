package view.carDetail;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import model.carModel.Car;
import model.sellerModel.Seller;

public class CarDetailController {

    private ViewHandler viewHandler;
    private CarDetailVM viewModel;

    private Car car;
    private Seller seller;
    private int accountNo;

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

        sellerName.setText("");

        car = viewModel.getCar();
        seller = viewModel.getCarOwner();
        accountNo = seller.getAccountNumber();

        setText();
    }


    private void setText() {
        String ph = String.valueOf(seller.getPhoneNo());
        String pr = String.valueOf(car.getPrice());
        String yop = String.valueOf(car.getYearOfProduction());
        String mile = String.valueOf(car.getMileAge());
        String mo = String.valueOf(car.getModel());
        String mcp = String.valueOf(car.getMaximumCapacityOfCar());
        String fuel = String.valueOf(car.getAverageFuelConsumption());
        String mlcp = String.valueOf(car.getMaximumLoadCapacity());
        String speed = String.valueOf(car.getTopSpeed());
        String wei = String.valueOf(car.getWeight());

        sellerName.setText(seller.getUsername());
        sellerPhone.setText(ph);
        sellerAddress.setText(seller.getStreetName() + " " + seller.getCity());
        priceOfCar.setText(pr);
        carName.setText(car.getName());
        yearOfProduction.setText(yop);
        mileage.setText(mile);
        typeOfTransmission.setText(car.getTypeOfTransmission());
        carModels.setText(mo);
        maxCapacity.setText(mcp);
        fuelConsumption.setText(fuel);
        maxLoadCapacity.setText(mlcp);
        topSpeed.setText(speed);
        weight.setText(wei);
        brand.setText(car.getBrand());
        description.setText(car.getDescription());


    }

    public void openTalkingView(ActionEvent actionEvent) {
        viewHandler.openTalking(accountNo);

    }

    public void backToCarList(ActionEvent actionEvent) {
        viewHandler.closeCar();
    }
}

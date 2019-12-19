package view.viewCar;

import core.ViewHandler;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.carModel.Car;
import model.carModel.Model;

public class ViewCarController {

    private ViewHandler viewHandler;
    private ViewCarVM viewModel;

    @FXML
    private TableView<Car> carTable;
    @FXML
    private TableColumn<Car, String> carName;
    @FXML
    private TableColumn<Car, Integer> mileAge;
    @FXML
    private TableColumn<Car, String> brand;
    @FXML
    private TableColumn<Car, Model> model;
    @FXML
    private TableColumn<Car, Integer> price;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> priceRange;
    @FXML
    private ComboBox<String> mileageRange;


    public void init(ViewCarVM vm, ViewHandler vh) {
        priceRange.getItems().addAll("below 10,000", "10,000-100,000", "100,000-500,000", "500,000-1,000,000", "over 1,000,000");
        mileageRange.getItems().addAll("below 1,000 km", "1,000-10,000 km", "10,000-50,000 km", "50,000-100,000 km", "over 100,000 km");

        viewHandler = vh;
        viewModel = vm;
        searchField.textProperty().bindBidirectional(viewModel.keywordProperty());
        viewModel.updateTableContent();

        // double click to get car's detail
        carTable.setOnMousePressed(e -> {
            // if mouse hover and double clicked
            if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
                if (carTable.getSelectionModel().getSelectedItem() != null) {
                    Car car = carTable.getSelectionModel().getSelectedItem();
                    System.out.println("Client wants to see : " + car);
                    viewModel.setCar(car);
                    viewHandler.openCarDetail();
                }
            }
        });

        initTableView();
    }

    private void initTableView() {
        carName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));
        mileAge.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getMileAge()));
        brand.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getBrand()));
        model.setCellValueFactory(cellData -> new SimpleObjectProperty<Model>(cellData.getValue().getModel()));
        price.setCellValueFactory(cellData -> new SimpleObjectProperty<Integer>(cellData.getValue().getPrice()));

        carTable.setItems(viewModel.getCars());

    }


    public void searchKeyWordButton(ActionEvent actionEvent) {
        viewModel.setFilteredData();
        carTable.setItems(viewModel.getCars());

    }

    public void backToLogin(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }


    public void getPriceRange(ActionEvent actionEvent) {
        if (priceRange.getValue().equals("below 10,000")) {
            viewModel.setPriceRange(0, 10000);
        } else if (priceRange.getValue().equals("10,000-100,000")) {
            viewModel.setPriceRange(10001, 100000);
        } else if (priceRange.getValue().equals("100,000-500,000")) {
            viewModel.setPriceRange(100001, 500000);
        } else if (priceRange.getValue().equals("500,000-1,000,000")) {
            viewModel.setPriceRange(500001, 1000000);
        } else if (priceRange.getValue().equals("over 1,000,000")) {
            viewModel.setPriceRange(1000001, 2147483646);
        } else
            viewModel.setPriceRange(0, 0);

        viewModel.rangeFilter();
        carTable.setItems(viewModel.getCars());

    }

    public void getMileRange(ActionEvent actionEvent) {
        if (mileageRange.getValue().equals("below 1,000 km")) {
            viewModel.setMileAgeRange(0, 1000);
        } else if (mileageRange.getValue().equals("1,000-10,000 km")) {
            viewModel.setMileAgeRange(1000, 10000);
        } else if (mileageRange.getValue().equals("10,000-50,000 km")) {
            viewModel.setMileAgeRange(10000, 50000);
        } else if (mileageRange.getValue().equals("50,000-100,000 km")) {
            viewModel.setMileAgeRange(500000, 100000);
        } else if (mileageRange.getValue().equals("over 100,000 km")) {
            viewModel.setMileAgeRange(100000, 2147483646);
        } else
            viewModel.setMileAgeRange(0, 0);

        viewModel.rangeFilter();
        carTable.setItems(viewModel.getCars());

    }
}

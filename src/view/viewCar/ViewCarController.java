package view.viewCar;

import core.ViewHandler;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private ComboBox<Model> carModels;

    public void init(ViewCarVM vm, ViewHandler vh) {

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
        carTable.setItems(viewModel.getCars());
        viewModel.setFilteredData();
    }

    public void enterPressed(KeyEvent keyEvent) {
        carTable.setItems(viewModel.getCars());
        viewModel.setFilteredData();
    }

    public void backToLogin(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }
}

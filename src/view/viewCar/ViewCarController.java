package view.viewCar;

import core.ViewHandler;
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
    }

    public void searchKeyWordButton(ActionEvent actionEvent) {
    }

    public void enterPressed(KeyEvent keyEvent) {
    }

    public void backToLogin(ActionEvent actionEvent) {
        viewHandler.openLogin();
    }
}

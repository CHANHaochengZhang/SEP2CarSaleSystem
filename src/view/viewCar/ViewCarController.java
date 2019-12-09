package view.viewCar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import model.carModel.Model;

public class ViewCarController {
    @FXML
    private TableView carTable;
    @FXML
    private TableColumn carName;
    @FXML
    private TableColumn mileAge;
    @FXML
    private TableColumn brand;
    @FXML
    private TableColumn model;
    @FXML
    private TableColumn prince;
    @FXML
    private TextField searchField;
    @FXML
    private ComboBox<String> priceRange;
    @FXML
    private ComboBox<String> mileageRange;
    @FXML
    private ComboBox<Model> carModels;

    public void searchKeyWordButtom(ActionEvent actionEvent) {
    }

    public void enterPressed(KeyEvent keyEvent) {
    }
}

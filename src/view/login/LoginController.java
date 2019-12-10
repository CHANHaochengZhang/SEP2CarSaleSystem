package view.login;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    private ViewHandler viewHandler;
    @FXML
    private TextField accountNumber;

    @FXML
    private PasswordField password;

    public void openViewCars(ActionEvent actionEvent) {
    }

    public void logIn(ActionEvent actionEvent) {
        System.out.println("account : " + accountNumber.getCharacters());
        System.out.println("password : " + password.getCharacters());

    }

    public void openAddBuyer(ActionEvent actionEvent) {
        viewHandler.openAddBuyer();
    }

    public void openAddSeller(ActionEvent actionEvent) {
    }

    public void openAccountManagement(ActionEvent actionEvent) {
    }

    public void init() {
    }
}

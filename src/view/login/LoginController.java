package view.login;

import core.ViewHandler;
import javafx.beans.property.IntegerProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ClientModel;
import model.ClientModelManager;

public class LoginController {
    //default login is false
    private Boolean logInSucceed = false;

    private ViewHandler viewHandler;
    private LoginVM viewModel;
    @FXML
    private TextField accountNumber;

    @FXML
    private PasswordField password;

    public void init(LoginVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        accountNumber.textProperty().bindBidirectional(vm.accountProperty());
        password.textProperty().bindBidirectional(vm.passwordProperty());
    }

    public void openViewCars(ActionEvent actionEvent) {
    }

    public void logIn(ActionEvent actionEvent) {
        String a = accountNumber.getText();
        String p = password.getText();

        if ((a != null && p != null)) {
            System.out.println("account : " + accountNumber.getText());
            System.out.println("password : " + password.getText());

           logInSucceed =  viewModel.logInSuccessfully();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Sorry, Error of login");
            alert.setContentText("Please enter you account number or password!");

            alert.showAndWait();
        }


    }

    public void openAddBuyer(ActionEvent actionEvent) {
        viewHandler.openAddBuyer();
    }

    public void openAddSeller(ActionEvent actionEvent) {
       viewHandler.openAddSeller();
    }

    public void openAccountManagement(ActionEvent actionEvent) {
    }


}

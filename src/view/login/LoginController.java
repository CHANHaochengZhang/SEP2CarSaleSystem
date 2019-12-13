package view.login;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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


    public void logIn(ActionEvent actionEvent) {
        String a = accountNumber.getText();
        String p = password.getText();
        System.out.println("account : " + accountNumber.getText());
        System.out.println("password : " + password.getText());

        if ((a != null && p != null)) {

            logInSucceed = viewModel.logInSuccessfully();
            if (logInSucceed) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Log in successfully");
                alert.setHeaderText("Log in successfully");
                alert.setContentText("(>‿◠)✌");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Log in failed");
                alert.setHeaderText("Log in failed");
                alert.setContentText("check your account number or password");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning Dialog");
            alert.setHeaderText("Sorry, Error of login");
            alert.setContentText("Please enter you account number or password!");

            alert.showAndWait();
        }


    }

    public void openViewCars(ActionEvent actionEvent) {

        viewHandler.openCarList();

    }

    public void openAddBuyer(ActionEvent actionEvent) {
        if (!logInSucceed) {
            try {
                viewHandler.openAddBuyer();
            } catch (IllegalStateException e) {
                System.out.println("Can't open addBuyer and addSeller at same time");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adding Buyer");
            alert.setHeaderText("Sorry, Error of Adding buyer");
            alert.setContentText("You are already the user of VIA Car sales System");

            alert.showAndWait();
        }
    }

    public void openAddSeller(ActionEvent actionEvent) {
        if (!logInSucceed) {
            try {
                viewHandler.openAddSeller();
            } catch (IllegalStateException e) {
                System.out.println("Can't open addBuyer and addSeller at same time");
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Adding Seller");
            alert.setHeaderText("Sorry, Error of Adding seller");
            alert.setContentText("You are already the user of VIA Car sales System");

            alert.showAndWait();
        }
    }

    public void openAccountManagement(ActionEvent actionEvent) {
        if (logInSucceed) {
            viewHandler.openAccountManagement();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Account Management");
            alert.setHeaderText("Sorry, Error of log in");
            alert.setContentText("Please log in  ╯▂╰   ╯▂╰   ╯▂╰   ╯▂╰   ╯▂╰ ");

            alert.showAndWait();
        }
    }

    public Boolean getLogInSucceed() {
        return logInSucceed;
    }
}

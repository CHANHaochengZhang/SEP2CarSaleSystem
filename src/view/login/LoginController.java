package view.login;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.ClientModel;
import model.ClientModelManager;

public class LoginController {
    private ViewHandler viewHandler;
    private LoginVM vm;
    @FXML
    private TextField accountNumber;

    @FXML
    private PasswordField password;

    public void openViewCars(ActionEvent actionEvent) {
    }

    public void logIn(ActionEvent actionEvent) {
        System.out.println("account : " + accountNumber.getText());
        System.out.println("password : " + password.getText());
        try {
            String r = accountNumber.getText();
            int a = Integer.valueOf(r);
            String p = password.getText();
            ClientModel cm = new ClientModelManager();
            System.out.println(cm.logIn(a, p));
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

    }

    public void openAddBuyer(ActionEvent actionEvent) {
        viewHandler.openAddBuyer();
    }

    public void openAddSeller(ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Careful with the next step!");

        alert.showAndWait();
    }

    public void openAccountManagement(ActionEvent actionEvent) {
    }

    public void init(LoginVM vm, ViewHandler vh) {
        this.viewHandler = vh;
    }
}

package view.registerBuyer;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterBuyerController {

    private RegisterBuyerVM viewModel;
    private ViewHandler viewHandler;

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField passwordAgain;
    @FXML
    private Text accountNumber;
    @FXML
    private Text errorText;

    public void init(RegisterBuyerVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        accountNumber.setText(viewModel.getAccToString());
        userName.textProperty().bindBidirectional(viewModel.userNameProperty());
        password.textProperty().bindBidirectional(viewModel.passwordProperty());
    }

    public void save(ActionEvent actionEvent) {
        String p = password.getText();
        String pa = passwordAgain.getText();
        System.out.println(p+"|");
        System.out.println(pa+"|");

        if (p == null || pa == null) {
            errorText.setText("* please enter your password");
        } else if (p.equals(pa)) {
            viewModel.addNewBuyer();

            System.out.println("add buyer successfully");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Create new account Successfully");
            alert.setHeaderText("Create new account Successfully");
            alert.setContentText("Hello, your account Number is " + viewModel.getAccToString());
            alert.showAndWait();

            viewHandler.closeUser();

        } else {
            System.out.println("error");
            errorText.setText("* password is not the same!");
        }


    }

    public void cancel(ActionEvent actionEvent) {
        viewHandler.closeUser();
    }


}

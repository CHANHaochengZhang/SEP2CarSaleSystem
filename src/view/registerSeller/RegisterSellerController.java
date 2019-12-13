package view.registerSeller;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import view.registerBuyer.RegisterBuyerVM;

public class RegisterSellerController {


    private ViewHandler viewHandler;
    private RegisterSellerVM viewModel;

    @FXML
    private Text passwordErrorText;
    @FXML
    private Text textError;
    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Text accountNumber;
    @FXML
    private PasswordField passwordAgain;


    @FXML
    private TextField street;
    @FXML
    private TextField streetNumber;
    @FXML
    private TextField city;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField phone;

    public void init(RegisterSellerVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;
        accountNumber.setText(viewModel.getAccToString());
        userName.textProperty().bindBidirectional(viewModel.userNameProperty());
        password.textProperty().bindBidirectional(viewModel.passwordProperty());
        street.textProperty().bindBidirectional(viewModel.streetProperty());
        streetNumber.textProperty().bindBidirectional(viewModel.streetNoProperty());
        city.textProperty().bindBidirectional(viewModel.cityProperty());
        postalCode.textProperty().bindBidirectional(viewModel.postalCodeProperty());
        phone.textProperty().bindBidirectional(viewModel.phoneProperty());
    }

    public void Save(ActionEvent actionEvent) {
        // set error texts is empty when clicking
        passwordErrorText.setText("");
        textError.setText("");

        String p = password.getText();
        String pa = passwordAgain.getText();
        String s = street.getText();
        String sn = streetNumber.getText();
        String ci = city.getText();
        String pc = postalCode.getText();
        String ph = phone.getText();

        if (p == null || pa == null) {
            passwordErrorText.setText("* please enter your password");
        } else if (s == null || sn == null || ci == null || pc == null || ph == null) {
            textError.setText("* please insert these detail");
        } else if (p.equals(pa)) {
            viewModel.addNewSeller();
            System.out.println("add buyer successfully");

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Create new account Successfully");
            alert.setHeaderText("Create new account Successfully");
            alert.setContentText("Hello, your account Number is " + viewModel.getAccToString());
            alert.showAndWait();

            viewHandler.closeUser();
        } else {
            passwordErrorText.setText("* password is not the same!");
        }
    }

    public void cancel(ActionEvent actionEvent) {
        viewHandler.closeUser();
    }


}

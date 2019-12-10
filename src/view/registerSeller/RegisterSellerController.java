package view.registerSeller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class RegisterSellerController {
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
    private TextField city;
    @FXML
    private TextField postalCode;
    @FXML
    private TextField phone;

    public void Save(ActionEvent actionEvent) {
    }

    public void cancel(ActionEvent actionEvent) {
    }
}

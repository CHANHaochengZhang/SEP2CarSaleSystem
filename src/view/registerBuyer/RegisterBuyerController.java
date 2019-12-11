package view.registerBuyer;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    public void save(ActionEvent actionEvent) {
    }

    public void cancel(ActionEvent actionEvent) {
    }

    public void init(RegisterBuyerVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
    }
}

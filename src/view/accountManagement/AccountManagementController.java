package view.accountManagement;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class AccountManagementController {

    private ViewHandler viewHandler;
    private AccountManagementVM viewModel;


    @FXML
    private Text accountNumber;
    @FXML
    private Text userName;
    @FXML
    private Button addCarButton;


    public void init(AccountManagementVM vm, ViewHandler vh) {
        viewHandler = vh;
        viewModel = vm;
        accountNumber.setText(viewModel.getAccountNumber());
        userName.setText(viewModel.getUserName());
        if (viewModel.isBuyer()) {
            addCarButton.setDisable(true);
        }
    }

    public void openAddCarView(ActionEvent actionEvent) {

        if (viewModel.isBuyer()) {
            addCarButton.setDisable(true);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Can't add car");
            alert.setHeaderText("Sorry,Can't add your car");
            alert.setContentText("Your are not a seller, please register as seller");
            alert.showAndWait();
        } else {
            viewHandler.openAddCar();
        }
    }

    public void openMailBoxView(ActionEvent actionEvent) {
        viewModel.current();
        viewHandler.openMailBox();
    }
}

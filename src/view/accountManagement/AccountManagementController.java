package view.accountManagement;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;

public class AccountManagementController {
    private ViewHandler viewHandler;
    private AccountManagementVM viewModel;


    @FXML
    private Text accountNumber;
    @FXML
    private Text userName;

    public void init(AccountManagementVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;
        accountNumber.setText(viewModel.getAccountNumber());
        userName.setText(viewModel.getUserName());
    }

    public void openAddCarView(ActionEvent actionEvent) {

        if (viewModel.isBuyer()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Can't add car");
            alert.setHeaderText("Sorry,Can't add your car");
            alert.setContentText("Your are not a seller, please register as seller");
            alert.showAndWait();
        }
        viewHandler.openAddCar();

    }

    public void openMailBoxView(ActionEvent actionEvent) {
        viewHandler.openMailBox();
    }
}

package view.accountManagement;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    }
    public void openAddCarView(ActionEvent actionEvent) {
        viewHandler.openAddCar();

    }

    public void openMailBoxView(ActionEvent actionEvent) {
        viewHandler.openMailBox();
    }
}

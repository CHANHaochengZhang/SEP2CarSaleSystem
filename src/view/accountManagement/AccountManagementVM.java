package view.accountManagement;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ClientModel;
import view.login.LoginController;
import view.login.LoginVM;

public class AccountManagementVM {
    private ClientModel clientModel;
    private StringProperty accountNo, userName;

    public AccountManagementVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        accountNo = new SimpleStringProperty();
        userName = new SimpleStringProperty();

    }
}

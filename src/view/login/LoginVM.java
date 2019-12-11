package view.login;

import javafx.beans.property.*;
import model.ClientModel;

public class LoginVM {

    private ClientModel clientModel;
    private StringProperty accountNo;
    private StringProperty password;

    public LoginVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        accountNo = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public boolean logInSuccessfully() {
        int a = 0;
        try {
            String r = accountNo.getValue();
            a = Integer.valueOf(r);
        } catch (NumberFormatException e) {
            System.out.println("Not int");
        }
        return clientModel.logIn(a, password.getValue());
    }

    public StringProperty accountProperty() {
        return accountNo;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}

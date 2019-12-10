package view.login;

import model.ClientModel;

public class LoginVM {

    private ClientModel clientModel;

    public LoginVM(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public boolean logInSuccessfully(int accountNo, String password) {
        return clientModel.logIn(accountNo, password);
    }
}

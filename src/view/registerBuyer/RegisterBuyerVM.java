package view.registerBuyer;

import javafx.beans.property.*;
import model.ClientModel;
import model.buyerModel.Buyer;

public class RegisterBuyerVM {
    private int accInt;
    private StringProperty userName, password;
    private ClientModel clientModel;

    public RegisterBuyerVM(ClientModel clientModel) {


        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        this.clientModel = clientModel;

        accInt = clientModel.getNumberForNewUsr();

    }

    public void addNewBuyer() {

        Buyer buyer = new Buyer(userName.getValue(), password.getValue(), accInt);

        clientModel.addBuyer(buyer);
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public StringProperty passwordProperty() {
        return password;
    }


    public String getAccToString() {
        String accString;
        accString = String.valueOf(accInt);
        return accString;
    }
}

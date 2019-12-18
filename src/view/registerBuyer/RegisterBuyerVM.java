package view.registerBuyer;

import javafx.beans.property.*;
import model.ClientModel;
import model.buyerModel.Buyer;

public class RegisterBuyerVM {
    private int accInt;

    private ClientModel clientModel;

    public RegisterBuyerVM(ClientModel clientModel) {


        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        this.clientModel = clientModel;

        accInt = clientModel.getNumberForNewUsr();

    }

    // RegisterBuyerVM
    private StringProperty userName, password;
    // Initialized StringProperty in the constructor
    void addNewBuyer() {
        String name = userName.getValue();
        String pas = password.getValue();
        Buyer buyer = new Buyer(name, pas, accInt);
        // call method from ClientModel
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

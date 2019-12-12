package view.registerBuyer;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ClientModel;
import model.buyerModel.Buyer;

public class RegisterBuyerVM {
    private StringProperty userName, password;
    private ClientModel clientModel;

    public RegisterBuyerVM(ClientModel clientModel) {
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        this.clientModel = clientModel;
    }

    public void addNewBuyer() {
        Buyer buyer = new Buyer();
        clientModel.addBuyer(buyer);
    }

    public StringProperty userNameProperty() {
        return userName;
    }

    public StringProperty passwordProperty() {
        return password;
    }
}

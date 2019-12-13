package view.registerSeller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.ClientModel;

public class RegisterSellerVM {

    private int accInt;
    private StringProperty userName, password, street, city, postalCode, phone;
    private ClientModel clientModel;

    public RegisterSellerVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        street = new SimpleStringProperty();
        city = new SimpleStringProperty();
        postalCode = new SimpleStringProperty();
        phone = new SimpleStringProperty();

    }
    public void addNewSeller(){

    }
}

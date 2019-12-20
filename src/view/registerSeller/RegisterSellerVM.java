package view.registerSeller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import model.ClientModel;
import model.sellerModel.Seller;

public class RegisterSellerVM {

    private int accInt;
    private StringProperty userName, password, street, streetNo, city, postalCode, phone;


    private ClientModel clientModel;

    public RegisterSellerVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        userName = new SimpleStringProperty();
        password = new SimpleStringProperty();
        street = new SimpleStringProperty();
        city = new SimpleStringProperty();
        postalCode = new SimpleStringProperty();
        phone = new SimpleStringProperty();
        street = new SimpleStringProperty();
        streetNo = new SimpleStringProperty();
        accInt = clientModel.getNumberForNewUsr();

    }

    public void addNewSeller() {

        int sNo = Integer.valueOf(streetNo.getValue());
        int pc = Integer.valueOf(postalCode.getValue());
        int ph = Integer.valueOf(phone.getValue());


        String userN = userName.getValue();
        String pas = password.getValue();
        String sn = street.getValue();
        String cit = city.getValue();

        Seller seller = new Seller(userN, pas, accInt, sn, sNo, cit, pc, ph);
        clientModel.addSeller(seller);
    }


    public int getAccInt() {
        return accInt;
    }


    public StringProperty userNameProperty() {
        return userName;
    }


    public StringProperty passwordProperty() {
        return password;
    }


    public StringProperty streetProperty() {
        return street;
    }

    public String getStreetNo() {
        return streetNo.get();
    }

    public StringProperty streetNoProperty() {
        return streetNo;
    }

    public StringProperty cityProperty() {
        return city;
    }


    public StringProperty postalCodeProperty() {
        return postalCode;
    }


    public StringProperty phoneProperty() {
        return phone;
    }

    public String getAccToString() {
        String accString;
        accString = String.valueOf(accInt);
        return accString;
    }

    public void numeric(TextField textField) {


        textField.textProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue != null) {
                if (!newValue.matches("\\d*")) {
                    textField.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }

        });
    }
}

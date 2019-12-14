package view.addCar;

import javafx.beans.property.StringProperty;
import model.ClientModel;

public class AddCarVM {

    private StringProperty carName,yearOfProduction,mileage;

    private ClientModel clientModel;

    public AddCarVM(ClientModel clientModel) {
        this.clientModel = clientModel;

    }
}

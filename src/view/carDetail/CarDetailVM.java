package view.carDetail;

import model.ClientModel;
import model.carModel.Car;
import model.sellerModel.Seller;

public class CarDetailVM {

    private ClientModel clientModel;

    public CarDetailVM(ClientModel clientModel) {
        this.clientModel = clientModel;
    }

    public Car getCar() {
        return clientModel.getClickedCar();
    }

    public Seller getCarOwner() {
        return clientModel.getSellerInfoBycarNumber(getCar().getSellerNo());
    }


}

package persistence;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.mailModel.Message;
import model.sellerModel.Seller;

public interface DbAdder {

    public void addCar(Car car);

    public void addSeller(Seller seller);

    public void addBuyer(Buyer buyer);

    public void addMessage(Message message);
}

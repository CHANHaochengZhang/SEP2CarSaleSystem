package persistence;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.mailModel.Message;
import model.sellerModel.Seller;

import java.util.ArrayList;

public interface DbGetter {

    public ArrayList<Car> getCar();

    public ArrayList<Seller> getSeller();

    public ArrayList<Buyer> getBuyer();

    public ArrayList<Message> getMessage();
}

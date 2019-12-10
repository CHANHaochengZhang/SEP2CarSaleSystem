package model;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.carModel.Model;
import model.mailModel.Message;
import model.sellerModel.Seller;

import java.util.ArrayList;

public interface ClientModel extends PropertyChangeObserver {
    //test ok
    boolean logIn(int accountNo, String password);

    //test ok
    void addBuyer(Buyer buyer);

    //test ok
    void addSeller(Seller seller);

    //test ok
    void addCar(Car car);

    //test ok
    ArrayList<Car> filterByWord(String keyword);

    //TODO: filter is just get all cars
    ArrayList<Car> filter(String brand, int mileage, int price, Model model);

    //test ok
    ArrayList<Car> getAllCars();
    //test ok

    // insert sellerNo to get car/cars
    Seller getSellerInfoBycarNumber(int carAccountNo);

    void sendMessage(Message message);

    ArrayList<Message> getAllMessage();

    ArrayList<Message> getMessageByAddresser(int currentNo, int addresserNo);
}

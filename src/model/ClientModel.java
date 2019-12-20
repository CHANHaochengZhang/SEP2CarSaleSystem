package model;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.sellerModel.Seller;

import java.util.ArrayList;

/**
 * Class which is the one of the main model of MVVM(more models for the wishList function etc.)
 *
 * @author Haocheng
 * @version 4
 */
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

    //test ok
    ArrayList<Car> filter(int lowerPrice,int upperPrice,int lowerMile,int upperMile);

    //test ok
    ArrayList<Car> getAllCars();
    //test ok

    // insert sellerNo to get car/cars //test ok
    Seller getSellerInfoBycarNumber(int carAccountNo);


    //test ok
    void setCurrentUser(int currentUserNo);

    int getCurrentUser();

    //test ok
    int getNumberForNewUsr();
    //test ok
    boolean isBuyer(int accountNo);
    //test ok
    Buyer getBuyerByID(int accountNo);
    //test ok
    Seller getSellerByID(int accountNo);
    //test ok
    void setLogInSuccess(Boolean logIn);
    //test ok
    Boolean getLogInSuccess();
    //test ok
    void setClickedCar(Car car);
    //test ok
    Car getClickedCar();
}

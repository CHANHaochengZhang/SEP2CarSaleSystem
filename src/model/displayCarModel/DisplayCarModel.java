package model.displayCarModel;

import model.carModel.Car;
import model.carModel.Model;
import model.sellerModel.Seller;

import java.util.ArrayList;

public interface DisplayCarModel {

    ArrayList<Car> filter(int lowerPrice,int upperPrice,int lowerMile,int upperMile);

    ArrayList<Car> filterByWord(String keyword);

    ArrayList<Car> getAllCars();

    Car getCarByOwnerId(int sellerAccountNo);

    Seller getSellerByCarId(int carAccountNo);

}

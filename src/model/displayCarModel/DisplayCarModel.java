package model.displayCarModel;

import model.carModel.Car;
import model.carModel.Model;
import model.sellerModel.Seller;

import java.util.ArrayList;

public interface DisplayCarModel {

    ArrayList<Car> filter(String brand, int mileage, int price, Model model);

    ArrayList<Car> filterByWord(String keyword);

    ArrayList<Car> getAllCars();

    Car getCarByOwnerId(int sellerAccountNo);

    Seller getSellerByCarId(int carAccountNo);

}

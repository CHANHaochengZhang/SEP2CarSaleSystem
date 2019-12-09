package model.displayCarModel;

import Server.Server;
import model.carModel.Car;
import model.carModel.Model;
import model.sellerModel.Seller;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;

public class DisplayCarImp implements DisplayCarModel {

    private Server server;

    public DisplayCarImp() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");
    }

    @Override
    public ArrayList<Car> filter(String brand, int mileage, int price, Model model) {
        try {
            return getFilter(brand, mileage, price, model);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method to find cars that contains string keywords and
     * add them to a new car list which is presented for the user.
     *
     * @param keyword as a string the method should search for.
     */
    @Override
    public ArrayList<Car> filterByWord(String keyword) {
        try {
            // get all cars from database
            ArrayList<Car> cars = server.getCar();
            // new car list to add cars which fit the password
            ArrayList<Car> newCars = new ArrayList<>();
            if (keyword.isEmpty()) {
                return cars;
            }
            for (Car car : cars) {
                // use toString method to search for keywords. first change it to lower.
                if (car.toString().toLowerCase().contains(keyword.toLowerCase())) {
                    newCars.add(car);
                }
                return newCars;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<Car> getAllCars() {
        try {
            return server.getCar();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Car getCarByOwnerId(int sellerAccountNo) {

        try {
            return getCarById(sellerAccountNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Seller getSellerByCarId(int carAccountNo) {
        try {
            return sellerInfo(carAccountNo);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    //TODO:for filter
    public ArrayList<Car> getFilter(String brand, int mileage, int price, Model model) throws RemoteException {
        if (brand == null && mileage == 0 && price == 0 && model == null) {
            return server.getCar();
        }
        return server.getCar();
    }

    //for getCarBuOwnerId
    public Car getCarById(int sellerAccountNo) throws RemoteException {
        ArrayList<Car> cars = server.getCar();

        for (int i = 0; i < cars.size(); i++) {
            if (sellerAccountNo == cars.get(i).getSellerNo()) {
                return cars.get(i);
            }
        }
        return null;
    }

    // for getSellerInfo
    public Seller sellerInfo(int carAccountNo) throws RemoteException {
        ArrayList<Seller> sellers = server.getSeller();

        for (int i = 0; i < sellers.size(); i++) {
            if (carAccountNo == sellers.get(i).getAccountNumber()) {
                System.out.println("get seller : " + sellers.get(i).getUsername());
                return sellers.get(i);
            }
        }
        return null;
    }


}

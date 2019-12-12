package model;

import model.buyerModel.Buyer;
import model.buyerModel.BuyerAdd;
import model.buyerModel.BuyerModel;
import model.carModel.Car;
import model.carModel.CarCreate;
import model.carModel.CarModel;
import model.carModel.Model;
import model.displayCarModel.DisplayCarImp;
import model.displayCarModel.DisplayCarModel;
import model.loginModel.LoginImp;
import model.loginModel.LoginModel;
import model.mailModel.MailModel;
import model.mailModel.MailModelImp;
import model.mailModel.Message;
import model.sellerModel.Seller;
import model.sellerModel.SellerAdd;
import model.sellerModel.SellerModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/**
 * Class which implements ClientModel and PropertyChangeObserver
 * connect to loginModel,buyerModel,sellerModel,carModel,displayCarModel,mailModel
 * @author Haocheng
 * @version 4
 */
public class ClientModelManager implements ClientModel {
    private LoginModel loginModel;
    private BuyerModel buyerModel;
    private SellerModel sellerModel;
    private CarModel carModel;
    private DisplayCarModel displayCarModel;
    private MailModel mailModel;

    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public ClientModelManager() {
        try {
            loginModel = new LoginImp();
            buyerModel = new BuyerAdd();
            sellerModel = new SellerAdd();
            carModel = new CarCreate();
            displayCarModel = new DisplayCarImp();
            mailModel = new MailModelImp();
        } catch (RemoteException | NotBoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public boolean logIn(int accountNo, String password) {
        return loginModel.login(accountNo, password);
    }

    @Override
    public void addBuyer(Buyer buyer) {
        buyerModel.addBuyer(buyer);
    }

    @Override
    public void addSeller(Seller seller) {
        sellerModel.addSeller(seller);
    }

    @Override
    public void addCar(Car car) {
        carModel.addCar(car);
    }

    @Override
    public ArrayList<Car> filterByWord(String keyword) {
        return displayCarModel.filterByWord(keyword);
    }

    @Override
    public ArrayList<Car> filter(String brand, int mileage, int price, Model model) {
        return displayCarModel.filter(brand, mileage, price, model);
    }

    @Override
    public ArrayList<Car> getAllCars() {
        return displayCarModel.getAllCars();
    }

    @Override
    public Seller getSellerInfoBycarNumber(int carAccountNo) {
        return displayCarModel.getSellerByCarId(carAccountNo);
    }

    //TODO: mail
    @Override
    public void sendMessage(Message message) {

    }

    @Override
    public ArrayList<Message> getAllMessage() {
        return null;
    }

    @Override
    public ArrayList<Message> getMessageByAddresser(int currentNo, int addresserNo) {
        return null;
    }


    @Override
    public void addPropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.addPropertyChangeListener(listener);
        } else {
            support.addPropertyChangeListener(eventName, listener);

        }
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(String eventName, PropertyChangeListener listener) {
        if(eventName == null || "".equals(eventName)) {
            support.removePropertyChangeListener(listener);
        } else {
            support.removePropertyChangeListener(eventName, listener);
        }
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
// get time for message
    private String calcTimeStamp() {
        SimpleDateFormat sdfDate =
                new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date now = new Date();
        return sdfDate.format(now);
    }


}






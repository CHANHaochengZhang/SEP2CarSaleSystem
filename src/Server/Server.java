package Server;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.mailModel.IMailBox;
import model.mailModel.Message;
import model.sellerModel.Seller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Server extends Remote {

    boolean registerClient(IMailBox mb, int currentUserNo) throws RemoteException;

    ArrayList<Message> getMessage() throws RemoteException;

    ArrayList<Car> getCar() throws RemoteException;

    ArrayList<Seller> getSeller() throws RemoteException;

    ArrayList<Buyer> getBuyer() throws RemoteException;

    void addCar(Car car) throws RemoteException;

    void addBuyer(Buyer buyer) throws RemoteException;

    void addSeller(Seller seller) throws RemoteException;

    String serverHello() throws RemoteException;
}

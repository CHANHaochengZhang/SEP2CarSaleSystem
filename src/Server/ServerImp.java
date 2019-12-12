package Server;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.mailModel.IMailBox;
import model.mailModel.MailBox;
import model.mailModel.Message;
import model.sellerModel.Seller;
import persistence.DbAdder;
import persistence.DbAdderImp;
import persistence.DbGetter;
import persistence.DbGetterImp;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
/**
 * Class which implement Server, using RMI to access and bring method for clients
 *
 * @author Haocheng
 * @version 4
 */
public class ServerImp implements Server {

    private List<ClientContainer> clients;


    private DbAdder dbAdder;
    private DbGetter dbGetter;

    public ServerImp() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);

        dbAdder = new DbAdderImp();
        dbGetter = new DbGetterImp();

        clients = new ArrayList<>();


    }


    @Override
    public ArrayList<Message> getMessage() {
        return dbGetter.getMessage();
    }

    @Override
    public ArrayList<Car> getCar() {
        return dbGetter.getCar();
    }

    @Override
    public ArrayList<Seller> getSeller() {
        return dbGetter.getSeller();
    }

    @Override
    public ArrayList<Buyer> getBuyer() {
        return dbGetter.getBuyer();
    }

    @Override
    public void addCar(Car car) throws RemoteException {
        dbAdder.addCar(car);
    }

    @Override
    public void addBuyer(Buyer buyer) throws RemoteException {
        dbAdder.addBuyer(buyer);
    }

    @Override
    public void addSeller(Seller seller) throws RemoteException {
        dbAdder.addSeller(seller);
    }

    @Override
    public boolean registerClient(IMailBox mb, int currentUserNo) throws RemoteException {
        for (ClientContainer client : clients) {
            if (client.currentUserNo == currentUserNo) return false;
        }

        clients.add(new ClientContainer(mb, currentUserNo));

        return true;
    }

    //FX RMI
    @Override
    public String serverHello() {
        System.out.println("Hello from server");
        String msl = "hello from server";
        return msl;
    }

    public void addMessageInDataBase(Message message) {
        for (ClientContainer client : clients) {
            if (client.currentUserNo == message.getAddresserNo()) continue;

            try {
                dbAdder.addMessage(client.mailClient.sendMessage());
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }


    private class ClientContainer {

        int currentUserNo;
        IMailBox mailClient;

        ClientContainer(IMailBox mailClient, int currentUserNo) {

            this.mailClient = mailClient;
            this.currentUserNo = currentUserNo;
        }
    }

}

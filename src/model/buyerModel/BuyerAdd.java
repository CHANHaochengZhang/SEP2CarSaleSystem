package model.buyerModel;


import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * Class which implement DBAdder, as a adapter , DbAddImp can access the database to add car,buyer,seller,message objects .
 *
 * @author Haocheng
 * @version 4
 */
public class BuyerAdd implements BuyerModel{
    private Buyer buyer;
    private Server server;


    public BuyerAdd() throws RemoteException, NotBoundException {
        Registry rg = LocateRegistry.getRegistry("Localhost", 1888);
        server = (Server) rg.lookup("CarServer");
    }


    @Override
    public void addBuyer(Buyer buyer) {
        try {

            server.addBuyer(buyer);
            System.out.println(server.getBuyer());
            System.out.println("Add buyer successfully");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Buyer getBuyerByID(int accountNo) {
        try {
            ArrayList<Buyer> buyers = server.getBuyer();
            for (int i = 0; i < buyers.size(); i++) {
                if (buyers.get(i).getAccountNumber() == accountNo)
                    return buyers.get(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}

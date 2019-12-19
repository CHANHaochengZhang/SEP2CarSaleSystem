package model.sellerModel;


import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * Class which access to server and send new seller object to the database
 *
 * @author Haocheng
 * @version 4
 */
public class SellerAdd implements SellerModel {

    private Server server;

    public SellerAdd() throws RemoteException, NotBoundException {
        Registry rg = LocateRegistry.getRegistry("Localhost", 1888);
        server = (Server) rg.lookup("CarServer");
    }


    @Override
    public void addSeller(Seller seller) {
        try {
            server.addSeller(seller);
            System.out.println("Add seller successfully");


        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Seller getSellerByID(int accountNo) {
        try {
            ArrayList<Seller> sellers = server.getSeller();
            for (int i = 0; i < sellers.size(); i++) {
                if (sellers.get(i).getAccountNumber() == accountNo)
                    return sellers.get(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}

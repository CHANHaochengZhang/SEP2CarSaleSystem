package model.sellerModel;


import Server.Server;
import model.sellerModel.Seller;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/**
 * Class which access to server and send new seller object to the database
 *
 * @author Haocheng
 * @version 4
 */
public class SellerAdd implements SellerModel {
    private Seller seller;
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
}

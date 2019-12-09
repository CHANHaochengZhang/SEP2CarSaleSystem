package model.buyerModel;


import Server.Server;


import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BuyerAdd implements BuyerModel{
    private Buyer buyer;
    private Server server;


    public BuyerAdd() throws RemoteException, NotBoundException {
        Registry rg = LocateRegistry.getRegistry("Localhost", 1888);
        server = (Server) rg.lookup("CarServer");
    }


    public void testServerHello() {
        try {
            System.out.println(server.serverHello());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
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
}

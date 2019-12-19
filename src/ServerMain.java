

import Server.Server;
import Server.ServerImp;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {

    public static void main(String[] args) {
        try {
            Server server = new ServerImp();
            Registry registry = LocateRegistry.createRegistry(1888);


            registry.bind("CarServer", server);
            System.out.println("Server started");
            ServerImp serverImp = new ServerImp();



        } catch (RemoteException | AlreadyBoundException | NotBoundException e) {
            e.printStackTrace();
        }
    }
}

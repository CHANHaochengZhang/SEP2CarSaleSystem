package Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class testServer {

    public static void main(String[] args) {
        try {
            Server server = new ServerImp();
            System.out.println(server.getBuyer());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

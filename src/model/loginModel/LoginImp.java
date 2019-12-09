package model.loginModel;

import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class LoginImp implements LoginModel, Remote {


    private Server server;

    public LoginImp() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");
    }

    @Override
    public boolean login(int accountNo, String password) {
        try {
            return loopThroughUser(accountNo, password);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean loopThroughUser(int accountNo, String password) throws RemoteException {
        HashMap<Integer, String> accountMap = new HashMap<>();

        for (int i = 0; i < server.getBuyer().size(); i++) {
            accountMap.put(server.getBuyer().get(i).getAccountNumber(), server.getBuyer().get(i).getPassword());
        }
        for (int i = 0; i < server.getSeller().size(); i++) {
            accountMap.put(server.getSeller().get(i).getAccountNumber(), server.getSeller().get(i).getPassword());
        }
        System.out.println(accountMap);
        System.out.println("-----");
        for (int i : accountMap.keySet()) {

            if (accountNo == i) {
                String p = accountMap.get(i);
                if (password.equals(p)) {
                    System.out.println("Log in successfully");
                    return true;
                }
                break;
            }
        }
        return false;
    }
}

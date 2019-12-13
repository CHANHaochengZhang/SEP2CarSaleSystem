package model.loginModel;

import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Random;

/**
 * Class which implement LoginModel, send account number and password to confirm log in
 *
 * @author Haocheng
 * @version 4
 */
public class LoginImp implements LoginModel, Remote {
    // HashMap : AccountNumber, Password
    private HashMap<Integer, String> accountMap;
    //HashMap : AccountNumber , is Buyer or not (Buyer is true)
    private HashMap<Integer, Boolean> buyerSellerMap;
    private Server server;

    public LoginImp() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");

        accountMap = new HashMap<>();
        loopAccountMap();
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

    @Override
    public int getNumberForNewUser() {
        Random r = new Random();
        int number = r.nextInt(1000) + 1;
        for (int i : accountMap.keySet()) {
            if (number == i) {
                number = r.nextInt(1000) + 1;
            }
        }

        return number;
    }

    @Override
    public boolean isBuyer(int accountNo) {
        try {
            buyerOrSeller();
            for (int i : buyerSellerMap.keySet()) {
                if (accountNo == i) {
                    return buyerSellerMap.get(i);
                }
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * loop through the user database as HashMap:accountMap
     * p.s. I have to say , hash map is way much faster than arrayList,BTW
     *
     * @author Haocheng
     */

    public void loopAccountMap() throws RemoteException {
        for (int i = 0; i < server.getBuyer().size(); i++) {
            accountMap.put(server.getBuyer().get(i).getAccountNumber(), server.getBuyer().get(i).getPassword());
        }
        for (int i = 0; i < server.getSeller().size(); i++) {
            accountMap.put(server.getSeller().get(i).getAccountNumber(), server.getSeller().get(i).getPassword());
        }
        System.out.println(accountMap);
    }

    public void buyerOrSeller() throws RemoteException {
        buyerSellerMap = new HashMap<>();
        for (int i = 0; i < server.getBuyer().size(); i++) {
            buyerSellerMap.put(server.getBuyer().get(i).getAccountNumber(), true);
        }
        for (int i = 0; i < server.getSeller().size(); i++) {
            buyerSellerMap.put(server.getSeller().get(i).getAccountNumber(), false);
        }
        System.out.println(buyerSellerMap);
    }


    /**
     * @param accountNo , password, use accountMap to get both seller and buyers number and password,
     *                  compare with the accountNo and password which from client
     * @return boolean is true if log in successfully
     */
    public boolean loopThroughUser(int accountNo, String password) throws RemoteException {
        loopAccountMap();
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

package model.mailModel;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface IMailBox extends Remote {
    void sendMessage(String text, String date, int receiverID) throws RemoteException;
    ArrayList<Message> getMessage() throws RemoteException;
}

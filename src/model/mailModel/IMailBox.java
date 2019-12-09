package model.mailModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMailBox extends Remote {
    Message sendMessage() throws RemoteException;
}

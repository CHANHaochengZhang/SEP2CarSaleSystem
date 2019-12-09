package model.mailModel;

import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MailBox implements IMailBox{
    private  Message message;

    Server server;

    public MailBox() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");


    }


    @Override
    public Message sendMessage() throws RemoteException {
        return message;
    }

    public void setMessage(Message message){
        this.message = message;
    }
}

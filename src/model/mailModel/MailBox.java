package model.mailModel;

import Server.Server;
import model.ClientModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class MailBox implements IMailBox{
    private Message message;
    private int clientID;
    private ClientModel clientModel;
    Server server;

    public MailBox(ClientModel clientModel) throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");

        this.clientModel = clientModel;
        this.clientID = clientModel.getCurrentUser();
    }


    @Override
    public void sendMessage(String text, String date, int receiverID) {
        Message message = new Message(text, date, clientID, receiverID);
        try
        {
            server.addMessage(message);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
    }



    @Override
    public ArrayList<Message> getMessage(){
        ArrayList<Message> messages = new ArrayList<Message>();
        try
        {
            for(int i = 0; i<server.getMessage().size(); i++){
                if(server.getMessage().get(i).getReceiverNo() == clientID){
                    messages.add(server.getMessage().get(i));
                }
            }
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
        return messages;
    }


}

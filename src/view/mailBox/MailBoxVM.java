package view.mailBox;

import model.ClientModel;
import model.mailModel.IMailBox;
import model.mailModel.Message;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class MailBoxVM {
    private final IMailBox iMailBox;

    public MailBoxVM(IMailBox imailBox) {
        this.iMailBox = imailBox;
    }


    public ArrayList<Message> getMessages(){
        try
        {
            return iMailBox.getMessage();
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }

        return null;
    }


}

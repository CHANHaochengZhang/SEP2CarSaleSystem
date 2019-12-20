package core;

import model.ClientModel;
import model.ClientModelManager;
import model.mailModel.IMailBox;
import model.mailModel.MailBox;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ModelFactory {
    private ClientModel clientModel;
    private IMailBox iMailBox;

    public ClientModel getClientModel() {
        // lazy Instantiation
        if (clientModel == null) {
            clientModel = new ClientModelManager();
        }
        return clientModel;

    }


    public IMailBox getIMailBox(){

            try
            {
                iMailBox = new MailBox(getClientModel());
            }
            catch (RemoteException | NotBoundException e)
            {
                e.printStackTrace();
            }

        return iMailBox;
    }
    // more models like wishList , payment...
}

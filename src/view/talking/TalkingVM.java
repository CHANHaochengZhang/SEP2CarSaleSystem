package view.talking;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.mailModel.IMailBox;
import model.mailModel.Message;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TalkingVM {

    StringProperty text = new SimpleStringProperty();

    private int receiverNo;
    private IMailBox iMailBox;


    public TalkingVM(int receiverNo, IMailBox mailBox) {
        this.receiverNo = receiverNo;
        this.iMailBox = mailBox;
    }

    public void sendMessage(){
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        String time = sdf.format(calendar.getTime());
        try
        {
            iMailBox.sendMessage(text.getValue(),time,receiverNo);
        }
        catch (RemoteException e)
        {
            e.printStackTrace();
        }
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

    public int getReceiverNo()
    {
        return receiverNo;
    }
}

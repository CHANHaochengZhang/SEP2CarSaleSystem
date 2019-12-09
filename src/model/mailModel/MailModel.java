package model.mailModel;

import java.util.ArrayList;

public interface MailModel {
    void sendMessage(Message message);

    ArrayList<Message> getAllMessage();

    ArrayList<Message> getMessageByAddresser(int currentNo,int addresserNo);
}

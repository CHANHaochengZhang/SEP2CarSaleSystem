package model.mailModel;

import java.util.ArrayList;

public class MailModelImp implements MailModel {

    private MailBox mailBox;

    @Override
    public void sendMessage(Message message) {
        mailBox.setMessage(message);
    }

    @Override
    public ArrayList<Message> getAllMessage() {
        return null;
    }

    @Override
    public ArrayList<Message> getMessageByAddresser(int currentNo, int addresserNo) {
        return null;
    }
}

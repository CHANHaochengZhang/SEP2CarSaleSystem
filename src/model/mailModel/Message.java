package model.mailModel;

import java.io.Serializable;

public class Message implements Serializable {
    private static final long serialVersionUID = 4569773286601042523L;

    private String text;
    private String date;
    private int addresserNo;
    private int receiverNo;

    public Message(String text, String date, int addresserNo, int receiverNo) {
        this.text = text;
        this.date = date;
        this.addresserNo = addresserNo;
        this.receiverNo = receiverNo;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    public int getAddresserNo() {
        return addresserNo;
    }

    public int getReceiverNo() {
        return receiverNo;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddresserNo(int addresserNo) {
        this.addresserNo = addresserNo;
    }

    public void setReceiverNo(int receiverNo) {
        this.receiverNo = receiverNo;
    }

    @Override
    public String toString() {
        return "Message{" +
                "text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", addresser No=" + addresserNo +
                ", receiverNo=" + receiverNo +
                '}';
    }
}

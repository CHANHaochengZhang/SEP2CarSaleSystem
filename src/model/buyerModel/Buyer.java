package model.buyerModel;

import java.io.Serializable;
/**
 *  Class which contains all match information regarding a buyer.
 *
 *
 * @author wjj的爸爸
 * @version 4
 */
public class Buyer implements Serializable {
    private static final long serialVersionUID = 4569773286601042523L;
    private String username;
    private String password;
    private int accountNumber;



    public Buyer() {
    }

    public Buyer(Buyer buyer) {
        this.username = buyer.username;
        this.password = buyer.password;
        this.accountNumber = buyer.accountNumber;
    }

    public Buyer(String username, String password, int accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }


    @Override
    public String toString() {
        return "Buyer{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber=" + accountNumber +
                '}';
    }
}

package model.sellerModel;

import java.io.Serializable;
/**
 *  Class which contains all match information regarding a seller.
 *
 *
 * @author haocheng
 * @version 4
 */
public class Seller implements Serializable {

    private static final long serialVersionUID = 4569773286601042523L;

    private String username;
    private String password;
    private int accountNumber;
    private String streetName;
    private int streetNumber;
    private String city;
    private int postalCode;
    private long phoneNo;

    public Seller() {
    }

    public Seller(String username, String password, int accountNumber) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
    }

    public Seller(String username, String password, int accountNumber, String streetName, int streetNumber, String city, int postalCode, long phoneNo) {
        this.username = username;
        this.password = password;
        this.accountNumber = accountNumber;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNo = phoneNo;
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

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public long getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(long phoneNo) {
        this.phoneNo = phoneNo;
    }


    @Override
    public String toString() {
        return "Seller{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", accountNumber=" + accountNumber +
                ", streetName='" + streetName + '\'' +
                ", streetNumber=" + streetNumber +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", phoneNo=" + phoneNo +
                '}';
    }
}

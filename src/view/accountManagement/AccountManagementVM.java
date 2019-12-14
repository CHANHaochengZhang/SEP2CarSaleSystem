package view.accountManagement;


import model.ClientModel;
import model.buyerModel.Buyer;
import model.sellerModel.Seller;


public class AccountManagementVM {
    private ClientModel clientModel;
    private String accountNumber;
    private String userName;


    public AccountManagementVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        displayInfo();
    }


    public boolean isBuyer() {
        int acc = clientModel.getCurrentUser();
        return clientModel.isBuyer(acc);
    }


    public void displayInfo() {
        if (clientModel.isBuyer(clientModel.getCurrentUser())) {
            Buyer buyer = clientModel.getBuyerByID(clientModel.getCurrentUser());
            accountNumber = String.valueOf(buyer.getAccountNumber());
            userName = buyer.getUsername();
        } else {
            Seller seller = clientModel.getSellerByID(clientModel.getCurrentUser());
            accountNumber = String.valueOf(seller.getAccountNumber());
            userName = seller.getUsername();
        }
    }

    public String getAccountNumber() {
        System.out.println(accountNumber);
        return accountNumber;
    }

    public String getUserName()
    {
        System.out.println(userName);
        return userName;
    }

    public void current() {
        System.out.println("Account manage : current user is = " + clientModel.getCurrentUser());
    }
}

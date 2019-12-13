package model.sellerModel;

import model.sellerModel.Seller;

public interface SellerModel {
    public void addSeller(Seller seller);

    Seller getSellerByID(int accountNo);
}

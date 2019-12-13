package model.buyerModel;

import model.buyerModel.Buyer;

public interface BuyerModel {
    public void addBuyer(Buyer buyer);

    Buyer getBuyerByID(int accountNo);
}

package model;

import model.buyerModel.Buyer;
import model.displayCarModel.DisplayCarImp;
import model.displayCarModel.DisplayCarModel;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TestModel {
    public static void main(String[] args) {
        ClientModel cm = new ClientModelManager();
//        cm.addBuyer(new Buyer("new buyer1 ","jsdhfuhwkfjwen",9877));
//        System.out.println(cm.getAllCars());
//        System.out.println(cm.getSellerInfoBycarNumber(999));
//         System.out.println(cm.filterByWord("bmw"));
        System.out.println(cm.logIn(888,"HAHAHAHAHAHAHA"));

    }
}

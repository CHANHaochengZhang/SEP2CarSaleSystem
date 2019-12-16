package persistence;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.carModel.Model;
import model.mailModel.Message;
import model.sellerModel.Seller;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/*
Test methods must be decorated with @test
Test methods must be public void, no arguments
Each test method must be testable on its own, with no dependencies between methods.
 */
public class DbAdderImpTest {
    Car car = new Car("carName", "brand", Model.Mini, 1, 1, 1, 1, 1, 1, 1, "type", 1, "des", 2);
    Seller seller = new Seller("selelrName", "password", 1, "streetName", 1, "city", 1, 1);
    Buyer buyer = new Buyer("buyerName", "password", 2);
    Message message = new Message("helloText", "20191216", 1, 2);

    DbAdder dbAdder = new DbAdderImp();

    @Test
    public void addCar() {

        dbAdder.addCar(car);
    }

    @Test
    public void addSeller() {
        dbAdder.addSeller(seller);
    }

    @Test
    public void addBuyer() {
        dbAdder.addBuyer(buyer);
    }

    @Test
    public void addMessage() {
        dbAdder.addMessage(message);
    }
}
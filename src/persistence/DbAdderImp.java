package persistence;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.mailModel.Message;
import model.sellerModel.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Class which implement DBAdder, as a adapter , DbAddImp can access the database to add car,buyer,seller,message objects .
 *
 * @author Haocheng
 * @version 4
 */
public class DbAdderImp implements DbAdder {

    @Override
    public void addCar(Car car) {
        Connection c = null;
        Statement stmt = null;
        try {
            // setting: file - project structure - library - find your pgSQL .jar
            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:2333/postgres",
                    "postgres", "2333");

            System.out.println("Car Database open ok");

            stmt = c.createStatement();
            String sql = "INSERT INTO \"CarSellSystem\".car(name,brand,model,price,yearOfProduction,maximumCapacityOfCar,averageFuelConsumption,weight,LoadCapacity,topSpeed,typeOfTransmission,mileage,description,sellerNo) " +
                    "VALUES(' " + car.getName() +
                    " ',' " + car.getBrand() +
                    " ',' " + car.getModel() +
                    " ', " + car.getPrice() +
                    " , " + car.getYearOfProduction() +
                    " , " + car.getMaximumCapacityOfCar() +
                    " ," + car.getAverageFuelConsumption() +
                    "," + car.getWeight() +
                    " ," + car.getMaximumCapacityOfCar() +
                    "," + car.getTopSpeed() +
                    ",' " + car.getTypeOfTransmission() +
                    " '," + car.getMileAge() +
                    ",' " + car.getDescription() +
                    " ' ," + car.getSellerNo() +
                    " );";


            stmt.executeUpdate(sql);


            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Car Database update ok");
    }


    @Override
    public void addSeller(Seller seller) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:2333/postgres",
                    "postgres", "2333");

            System.out.println("Seller Database open ok");

            stmt = c.createStatement();
            String sql = "INSERT INTO \"CarSellSystem\".seller(accountNo,userName,password,streetName,streetNumber,city,postalCode,phoneNo) " +
                    "VALUES( " + seller.getAccountNumber() +
                    ",'" + seller.getUsername() +
                    "','" + seller.getPassword() +
                    "','" + seller.getStreetName() +
                    "'," + seller.getStreetNumber() +
                    " ,'" + seller.getCity() +
                    "'," + seller.getPostalCode() +
                    "," + seller.getPhoneNo() + ");";


            stmt.executeUpdate(sql);


            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Seller Database update ok");
    }


    @Override
    public void addBuyer(Buyer buyer) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:2333/postgres",
                    "postgres", "2333");

            System.out.println("buyer Database open ok");

            stmt = c.createStatement();
            String sql = "INSERT INTO \"CarSellSystem\".buyer(accountNo,userName,password) " +
                    "VALUES( " + buyer.getAccountNumber() +
                    ",'" + buyer.getUsername() +
                    "','" + buyer.getPassword() +
                    "');";


            stmt.executeUpdate(sql);


            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Buyer Database update ok");
    }

    @Override
    public void addMessage(Message message) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.postgresql.Driver");

            c = DriverManager.getConnection("jdbc:postgresql://localhost:2333/postgres",
                    "postgres", "2333");

            System.out.println("message Database open ok");

            stmt = c.createStatement();
            String sql = "INSERT INTO \"CarSellSystem\".message(msg,time,addresser,receiver) " +
                    "VALUES('" + message.getText() +
                    " ',' " + message.getDate() +
                    " '," + message.getAddresserNo() +
                    "," + message.getReceiverNo() + ");";


            stmt.executeUpdate(sql);


            stmt.close();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("message Database update ok");
    }
}

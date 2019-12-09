package persistence;

import model.buyerModel.Buyer;
import model.carModel.Car;
import model.carModel.Model;
import model.mailModel.Message;
import model.sellerModel.Seller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class DbGetterImp implements DbGetter {

    @Override
    public ArrayList<Car> getCar() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //don't forget to change localhost and password
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:2333/postgres",
                            "postgres", "2333");
            c.setAutoCommit(false);
            System.out.println("Opened Car database successfully");

            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM \"CarSellSystem\".car;");
            System.out.println("------------Car-------------");

            ArrayList<Car> cars = new ArrayList<>();
            while (rs.next()) {

                String name = rs.getString("name");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                int price = rs.getInt("price");
                int yearOfProduction = rs.getInt("yearOfProduction");
                int maximumCapacityOfCar = rs.getInt("maximumCapacityOfCar");
                int averageFuelConsumption = rs.getInt("averageFuelConsumption");
                int weight = rs.getInt("weight");
                int LoadCapacity = rs.getInt("LoadCapacity");
                int topSpeed = rs.getInt("topSpeed");
                String typeOfTransmission = rs.getString("typeOfTransmission");
                String description = rs.getString("description");
                int mileage = rs.getInt("mileage");
                int sellerNo = rs.getInt("sellerNo");

//                Model mEnum = Model.valueOf(model);


                Model mEnum;
                if (model.equals("Convertible")) {
                    mEnum = Model.Convertible;
                } else if (model.equals("Coupe")) {
                    mEnum = Model.Coupe;
                } else if (model.equals("Crossover")) {
                    mEnum = Model.Crossover;
                } else if (model.equals("Hatchback")) {
                    mEnum = Model.Hatchback;
                } else if (model.equals("Mini")) {
                    mEnum = Model.Mini;
                } else if (model.equals("Mpv")) {
                    mEnum = Model.Mpv;
                } else if (model.equals("Pickup")) {
                    mEnum = Model.Pickup;
                } else if (model.equals("Sedan")) {
                    mEnum = Model.Sedan;
                } else if (model.equals("SUV")) {
                    mEnum = Model.SUV;
                } else if (model.equals("VAN")) {
                    mEnum = Model.VAN;
                } else if (model.equals("Wagon")) {
                    mEnum = Model.Wagon;
                } else {
                    mEnum = Model.other;
                }


                Car car = new Car(name, brand, mEnum, price, yearOfProduction, maximumCapacityOfCar, averageFuelConsumption, weight, LoadCapacity, topSpeed, typeOfTransmission, mileage, description, sellerNo);
                System.out.println("get  Car database successfully: " + car);

                cars.add(car);

            }
            return cars;
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }


    @Override
    public ArrayList<Seller> getSeller() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //don't forget to change localhost and password
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:2333/postgres",
                            "postgres", "2333");
            c.setAutoCommit(false);
            System.out.println("Opened Car database successfully");

            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM \"CarSellSystem\".seller;");
            System.out.println("------------seller-------------");
            ArrayList<Seller> sellers = new ArrayList<>();

            while (rs.next()) {
                int accountNo = rs.getInt("accountNo");
                String password = rs.getString("password");
                String userName = rs.getString("userName");
                String streetName = rs.getString("streetName");
                int streetNumber = rs.getInt("streetNumber");
                String city = rs.getString("city");
                int postalCode = rs.getInt("postalCode");
                long phoneNo = rs.getLong("phoneNo");

                Seller seller = new Seller(userName, password, accountNo, streetName, streetNumber, city, postalCode, phoneNo);
                System.out.println("get  seller database successfully " + seller);
                sellers.add(seller);

            }
            return sellers;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public ArrayList<Buyer> getBuyer() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //don't forget to change localhost and password
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:2333/postgres",
                            "postgres", "2333");
            c.setAutoCommit(false);
            System.out.println("Opened Car database successfully");

            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM \"CarSellSystem\".buyer;");
            System.out.println("------------buyer-------------");
            ArrayList<Buyer> buyers = new ArrayList<>();

            while (rs.next()) {
                int accountNo = rs.getInt("accountNo");
                String password = rs.getString("password");
                String userName = rs.getString("userName");

                Buyer buyer = new Buyer(userName, password, accountNo);
                buyers.add(buyer);


                System.out.println("get Buyer database successfully " + buyer);


            }
            return buyers;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }

    @Override
    public ArrayList<Message> getMessage() {
        Connection c = null;
        Statement stmt = null;

        try {
            Class.forName("org.postgresql.Driver");
            //don't forget to change localhost and password
            c = DriverManager
                    .getConnection("jdbc:postgresql://localhost:2333/postgres",
                            "postgres", "2333");
            c.setAutoCommit(false);
            System.out.println("Opened Car database successfully");

            stmt = c.createStatement();
            ResultSet rs;
            rs = stmt.executeQuery("SELECT * FROM \"CarSellSystem\".message;");
            System.out.println("------------message-------------");
            ArrayList<Message> messages = new ArrayList<>();

            while (rs.next()) {

                String text = rs.getString("msg");
                String time = rs.getString("time");
                int addresser = rs.getInt("addresser");
                int receiver = rs.getInt("receiver");


                Message msg = new Message(text, time, addresser, receiver);
                System.out.println("get  Car database successfully " + msg);

                messages.add(msg);
            }
            return messages;

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return null;
    }
}

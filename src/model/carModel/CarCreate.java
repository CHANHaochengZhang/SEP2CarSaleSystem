package model.carModel;

import Server.Server;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class CarCreate implements CarModel{

    private Car car;
    private Server server;


    public CarCreate() throws RemoteException, NotBoundException {

        Registry registry = LocateRegistry.getRegistry("localhost", 1888);
        server = (Server) registry.lookup("CarServer");
    }




    @Override
    public void addCar(Car car) {
        try {
            server.addCar(car);
            System.out.println(server.getCar());
            System.out.println("Add car successfully");

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}

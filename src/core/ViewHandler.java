package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.accountManagement.AccountManagementController;
import view.login.LoginController;
import view.registerBuyer.RegisterBuyerController;
import view.registerSeller.RegisterSellerController;

import java.io.IOException;

public class ViewHandler {

    private Stage mainStage;
    private Stage addUserStage;

    private Stage carStage;

    private Scene addBuyerScene;
    private Scene addSellerScene;
    private Scene accountManage;
    private Scene carlistScene;

    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openLogin();
        mainStage.show();
        addUserStage = new Stage();


    }

    public void openLogin() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/login/loginView.fxml"));

        try {
            Parent root = loader.load();
            LoginController ctrl = loader.getController();
            ctrl.init(viewModelFactory.getLoginVM(), this);
            mainStage.setTitle("Log in");
            Scene loginScene = new Scene(root);
            mainStage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void openAddBuyer() {
        FXMLLoader loader = new FXMLLoader();
        if (addBuyerScene == null) {
            loader.setLocation(getClass().getResource("../view/registerBuyer/RegisterBuyerView.fxml"));

            try {
                Parent root = loader.load();
                RegisterBuyerController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getRegisterBuyerVM(), this);
                addBuyerScene = new Scene(root);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        addUserStage.setTitle("Register as Buyer");
        addUserStage.setScene(addBuyerScene);
        addUserStage.showAndWait();


    }

    public void openAddSeller() {
        FXMLLoader loader = new FXMLLoader();
        if (addSellerScene == null) {
            loader.setLocation(getClass().getResource("../view/registerSeller/RegisterSellerView.fxml"));

            try {
                Parent root = loader.load();
                RegisterSellerController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getRegisterSellerVM(), this);
                addSellerScene = new Scene(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        addUserStage.setTitle("Register as Seller");
        addUserStage.setScene(addSellerScene);
        addUserStage.showAndWait();
    }

    public void openAccountManagement(){
        FXMLLoader loader = new FXMLLoader();
        if (accountManage == null) {
            loader.setLocation(getClass().getResource("../view/accountManagement/AccountManagementView.fxml"));

            try {
                Parent root = loader.load();
                AccountManagementController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getAccountManagementVM(), this);
                accountManage = new Scene(root);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        addUserStage.setTitle("AccountManage");
        addUserStage.setScene(accountManage);
        addUserStage.showAndWait();
        //IllegalStateException
    }



}

package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.accountManagement.AccountManagementController;
import view.addCar.AddCarController;
import view.carDetail.CarDetailController;
import view.login.LoginController;
import view.mailBox.MailBoxController;
import view.registerBuyer.RegisterBuyerController;
import view.registerSeller.RegisterSellerController;
import view.talking.TalkingController;
import view.viewCar.ViewCarController;

import java.io.IOException;
import java.net.PortUnreachableException;

public class ViewHandler {

    private Stage mainStage;
    private Stage addUserStage;
    private Stage carStage;
    private Stage messageStage;


    private Scene addBuyerScene;
    private Scene addSellerScene;
    private Scene accountManage;
    private Scene carlistScene;
    private Scene carDetailScene;
    private Scene addCarScene;
    private Scene mailBoxScene;
    private Scene talkingScene;


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

    public void openAccountManagement() {
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
        addUserStage.show();

    }

    public void openCarList() {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/viewCar/ViewCarView.fxml"));

        try {
            Parent root = loader.load();
            ViewCarController ctrl = loader.getController();
            ctrl.init(viewModelFactory.getViewCarVM(), this);
            mainStage.setTitle("View products");
            carlistScene = new Scene(root);
            mainStage.setScene(carlistScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openCarDetail() {
        FXMLLoader loader = new FXMLLoader();
        if (carDetailScene == null) {
            loader.setLocation(getClass().getResource("../view/carDetail/CarDetailView.fxml"));

            try {
                Parent root = loader.load();
                CarDetailController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getCarDetailVM(), this);
                carDetailScene = new Scene(root);


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        carStage = new Stage();
        carStage.setTitle("Car Detail");
        carStage.setScene(carDetailScene);
        carStage.showAndWait();
    }

    public void openAddCar() {
        FXMLLoader loader = new FXMLLoader();
        if (addCarScene == null) {
            loader.setLocation(getClass().getResource("../view/addCar/AddCarView.fxml"));

            try {
                Parent root = loader.load();
                AddCarController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getAddCarVM(), this);
                addCarScene = new Scene(root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        carStage = new Stage();
        carStage.setTitle("Car Detail");
        carStage.setScene(addCarScene);
        carStage.showAndWait();
    }


    public void openMailBox() {
        FXMLLoader loader = new FXMLLoader();
        if (mailBoxScene == null) {
            loader.setLocation(getClass().getResource("../view/mailBox/MailBoxView.fxml"));

            try {
                Parent root = loader.load();
                MailBoxController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getMailBoxVM(), this);
                mailBoxScene = new Scene(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messageStage = new Stage();
        messageStage.setTitle("MailBox");
        messageStage.setScene(mailBoxScene);
        messageStage.showAndWait();
    }

    public void openTalking() {
        FXMLLoader loader = new FXMLLoader();
        if (talkingScene == null) {
            loader.setLocation(getClass().getResource("../view/mailBox/MailBoxView.fxml"));

            try {
                Parent root = loader.load();
                TalkingController ctrl = loader.getController();
                ctrl.init(viewModelFactory.getTalkingVM(), this);
                talkingScene = new Scene(root);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        messageStage = new Stage();
        messageStage.setTitle("MailBox");
        messageStage.setScene(talkingScene);
        messageStage.showAndWait();
    }

    public void closeUser() {
        addUserStage.close();
    }

}

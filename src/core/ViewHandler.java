package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.login.LoginController;
import view.registerBuyer.RegisterBuyerController;

import java.io.IOException;

public class ViewHandler {

    private Stage mainStage;
    private Scene addBuyerScene;
    private ViewModelFactory viewModelFactory;

    public ViewHandler(Stage stage, ViewModelFactory vmf) {
        viewModelFactory = vmf;
        mainStage = stage;
    }

    public void start() {
        openLogin();
        mainStage.show();

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
        mainStage.setTitle("Register as Buyer");
        mainStage.setScene(addBuyerScene);

    }


}

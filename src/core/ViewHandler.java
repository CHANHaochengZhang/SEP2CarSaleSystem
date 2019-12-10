package core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.login.LoginController;

import java.io.IOException;

public class ViewHandler {

    private Stage mainStage;

    public ViewHandler() {
        mainStage = new Stage();
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
            ctrl.init();
            mainStage.setTitle("Log in");
            Scene loginScene = new Scene(root);
            mainStage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

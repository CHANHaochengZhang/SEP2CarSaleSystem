package view.login;


import javafx.beans.property.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import javafx.scene.control.TextField;
import model.ClientModel;



public class LoginVM {

    private ClientModel clientModel;

    private Boolean logIn;
    private StringProperty accountNo;
    private StringProperty password;

    public LoginVM(ClientModel clientModel) {
        this.clientModel = clientModel;
        accountNo = new SimpleStringProperty();
        password = new SimpleStringProperty();
    }

    public boolean logInSuccessfully() {

        try {
            String r = accountNo.getValue();
            int a = Integer.valueOf(r);

            logIn = clientModel.logIn(a, password.getValue());

            if (logIn) {
                clientModel.setCurrentUser(a);
            }

            return logIn;

        } catch (NumberFormatException e) {
            System.out.println("Not int");
        }
        return false;
    }

    public StringProperty accountProperty() {
        return accountNo;
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setCurrent(int a) {
        clientModel.setCurrentUser(a);
    }

    public Boolean getLogIn() {
        return logIn;
    }
//TODO:
    // force the field to be numeric only
    // \d+ 匹配一个或多个数字
    public void numeric(TextField textField) {

        try {
            textField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue,
                                    String newValue) {
                    if (!newValue.matches("\\d*")) {
                        textField.setText(newValue.replaceAll("[^\\d]", ""));
                    }
                }
            });
        } catch (Exception e) {

        }

    }
}

package model.loginModel;

public interface LoginModel {
    boolean login(int accountNo, String password);

    int getNumberForNewUser();

    boolean isBuyer(int accountNo);
}

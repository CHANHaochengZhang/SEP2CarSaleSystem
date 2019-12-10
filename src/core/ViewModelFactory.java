package core;

import view.login.LoginVM;
import view.registerBuyer.RegisterBuyerVM;

public class ViewModelFactory {
    private LoginVM loginVM;
    private RegisterBuyerVM registerBuyerVM;

    private ModelFactory modelFactory;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginVM getLoginVM() {
        if (loginVM == null) loginVM = new LoginVM(modelFactory.getClientModel());
        return loginVM;

    }

    public RegisterBuyerVM getRegisterBuyerVM(){
        if (registerBuyerVM == null) registerBuyerVM = new RegisterBuyerVM(modelFactory.getClientModel());
        return registerBuyerVM;
    }
}

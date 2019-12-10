package core;

import view.login.LoginVM;

public class ViewModelFactory {
    private LoginVM loginVM;

    private ModelFactory modelFactory;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    public LoginVM getLoginVM() {
        if (loginVM == null) loginVM = new LoginVM(modelFactory.getClientModel());
        return loginVM;

    }
}

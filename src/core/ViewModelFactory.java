package core;

import view.accountManagement.AccountManagementVM;
import view.addCar.AddCarVM;
import view.carDetail.CarDetailVM;
import view.login.LoginVM;
import view.mailBox.MailBoxVM;
import view.registerBuyer.RegisterBuyerVM;
import view.registerSeller.RegisterSellerVM;
import view.talking.TalkingVM;
import view.viewCar.ViewCarVM;

public class ViewModelFactory {
    private LoginVM loginVM;
    private RegisterBuyerVM registerBuyerVM;
    private RegisterSellerVM registerSellerVM;
    private AccountManagementVM accountManagementVM;
    private AddCarVM addCarVM;
    private CarDetailVM carDetailVM;
    private MailBoxVM mailBoxVM;
    private TalkingVM talkingVM;
    private ViewCarVM viewCarVM;

    private ModelFactory modelFactory;


    public ViewModelFactory(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
    }

    //lazy inst
    public LoginVM getLoginVM() {
        if (loginVM == null) loginVM = new LoginVM(modelFactory.getClientModel());
        return loginVM;

    }

    public RegisterBuyerVM getRegisterBuyerVM() {
        if (registerBuyerVM == null) registerBuyerVM = new RegisterBuyerVM(modelFactory.getClientModel());
        return registerBuyerVM;
    }

    public RegisterSellerVM getRegisterSellerVM() {
        if (registerSellerVM == null)
            registerSellerVM = new RegisterSellerVM(modelFactory.getClientModel());
        return registerSellerVM;
    }

    public AccountManagementVM getAccountManagementVM() {
            accountManagementVM = new AccountManagementVM(modelFactory.getClientModel());
        return accountManagementVM;
    }

    public AddCarVM getAddCarVM() {
        if (addCarVM == null)
            addCarVM = new AddCarVM(modelFactory.getClientModel());
        return addCarVM;
    }

    public CarDetailVM getCarDetailVM() {

        carDetailVM = new CarDetailVM(modelFactory.getClientModel());
        return carDetailVM;
    }

    //TODO: Mail model
    public MailBoxVM getMailBoxVM() {
        mailBoxVM = new MailBoxVM(modelFactory.getIMailBox());
        return mailBoxVM;
    }

    //TODO: Mail model
    public TalkingVM getTalkingVM(int accountNo) {
        talkingVM = new TalkingVM(accountNo, modelFactory.getIMailBox());
        return talkingVM;
    }

    public ViewCarVM getViewCarVM() {
        if (viewCarVM == null)
            viewCarVM = new ViewCarVM(modelFactory.getClientModel());
        return viewCarVM;
    }
}

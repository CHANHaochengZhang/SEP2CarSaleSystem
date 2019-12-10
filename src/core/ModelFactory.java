package core;

import model.ClientModel;
import model.ClientModelManager;

public class ModelFactory {
    private ClientModel clientModel;

    public ClientModel getClientModel() {
        if (clientModel == null) {
            clientModel = new ClientModelManager();
        }
        return clientModel;
    }
}

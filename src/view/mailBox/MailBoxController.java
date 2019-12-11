package view.mailBox;

import core.ViewHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.mailModel.Message;

public class MailBoxController {

    private ViewHandler viewHandler;
    private MailBoxVM viewModel;


    @FXML
    private TableView<Message> mailListTable;
    @FXML
    private TableColumn<Message, String> messageName;
    @FXML
    private TableColumn<Message, String> messageText;
    @FXML
    private TableColumn<Message, String> messageTime;

    public void init(MailBoxVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;
    }
}

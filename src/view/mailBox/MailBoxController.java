package view.mailBox;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.mailModel.Message;

public class MailBoxController {
    @FXML
    private TableView<Message> mailListTable;
    @FXML
    private TableColumn<Message,String> messageName;
    @FXML
    private TableColumn<Message,String> messageText;
    @FXML
    private TableColumn<Message,String> messageTime;


}

package view.talking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TalkingController {
    @FXML
    private Text receiverName;
    @FXML
    private TableView talkTable;
    @FXML
    private TableColumn addresserName;
    @FXML
    private TableColumn text;
    @FXML
    private TableColumn time;

    public void sendMessage(ActionEvent actionEvent) {
    }
}

package view.talking;

import core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

public class TalkingController {
    private ViewHandler viewHandler;
    private TalkingVM viewModel;

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

    public void init(TalkingVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;
    }

    public void sendMessage(ActionEvent actionEvent) {
    }

    public void backToMailBox(ActionEvent actionEvent) {
        viewHandler.openMailBox();
    }
}

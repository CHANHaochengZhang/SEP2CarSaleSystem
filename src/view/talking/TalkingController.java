package view.talking;

import core.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.mailModel.Message;

public class TalkingController {
    private ViewHandler viewHandler;
    private TalkingVM viewModel;

    private ObservableList<Message> messages = FXCollections.observableArrayList();

    @FXML
    private Text receiverNo;
    @FXML
    private TableView<Message> talkTable;
    @FXML
    private TableColumn<Message, String> accountNo;
    @FXML
    private TableColumn<Message, String> text;
    @FXML
    private TableColumn<Message, String> time;
    @FXML
    private TextField textField;

    public void init(TalkingVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;

        receiverNo.setText(Integer.toString(vm.getReceiverNo()));

        textField.textProperty().bindBidirectional(vm.text);


            for(int i = 0; i<vm.getMessages().size(); i++){
                messages.add(vm.getMessages().get(i));
            }
            talkTable.setItems(messages);
            accountNo.setCellValueFactory(cellData -> new SimpleStringProperty(
                Integer.toString(cellData.getValue().getAddresserNo())));
            text.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getText()));
            time.setCellValueFactory(cellData -> new SimpleStringProperty(
                cellData.getValue().getDate()));

    }

    public void sendMessage(ActionEvent actionEvent) {
        viewModel.sendMessage();
    }

    public void backToMailBox(ActionEvent actionEvent) {
        viewHandler.openMailBox();
    }
}

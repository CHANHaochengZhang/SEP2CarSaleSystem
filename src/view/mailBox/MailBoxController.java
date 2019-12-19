package view.mailBox;

import core.ViewHandler;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.mailModel.Message;

public class MailBoxController {

    private ViewHandler viewHandler;
    private MailBoxVM viewModel;

    private ObservableList<Message> messages = FXCollections.observableArrayList();;


    @FXML
    private TableView<Message> mailListTable;
    @FXML
    private TableColumn<Message, String> messageAccountNo;
    @FXML
    private TableColumn<Message, String> messageText;
    @FXML
    private TableColumn<Message, String> messageTime;

    public void init(MailBoxVM vm, ViewHandler vh) {

        viewHandler = vh;
        viewModel = vm;

        if(!(viewModel.getMessages() == null))
        {
            for(int i = 0; i<vm.getMessages().size(); i++){
                messages.add(vm.getMessages().get(i));
            }
            mailListTable.setItems(messages);
            messageAccountNo.setCellValueFactory(cellData -> new SimpleStringProperty(
                String.valueOf(cellData.getValue().getAddresserNo())));
            messageText.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getText()));
            messageTime.setCellValueFactory(
                cellData -> new SimpleStringProperty(cellData.getValue().getDate()));
        }

        mailListTable.setOnMousePressed(e -> {
            // if mouse hover and double clicked
            if (e.isPrimaryButtonDown() && e.getClickCount() == 2) {
                if (mailListTable.getSelectionModel().getSelectedItem() != null) {
                    Message message = mailListTable.getSelectionModel().getSelectedItem();
                    viewHandler.openTalking(message.getAddresserNo());
                }
            }
        });
    }







}

package com.example.bank.Views;

import com.example.bank.Models.Client;
import com.example.bank.controllers.Admin.ClientCellController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class ClientCellFactory extends ListCell<Client>{
    @Override
    protected void updateItem(Client client, boolean empty) {
        super.updateItem(client, empty);
        if (empty){
            setText(null);
            setGraphic(null);
        }else {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/Admin/Client.fxml"));
            ClientCellController controller = new ClientCellController(client);
            fxmlLoader.setController(controller);
            setText(null);
            try {
                setGraphic(fxmlLoader.load());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

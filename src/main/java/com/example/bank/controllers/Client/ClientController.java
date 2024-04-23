package com.example.bank.controllers.Client;

import com.example.bank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientController implements Initializable {
    public BorderPane client_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().addListener((observable, oldVal, newVal) -> {
           switch (newVal){
               case TRANSACTIONS -> client_parent.setCenter(Model.getInstance().getViewFactory().getTransactionsView());
               case ACCOUNTS -> client_parent.setCenter(Model.getInstance().getViewFactory().getAccountsView());
               default -> client_parent.setCenter(Model.getInstance().getViewFactory().getDashboardView());
           }
        });
    }
}

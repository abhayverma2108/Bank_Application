package com.example.bank.controllers.Admin;

import com.example.bank.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable {
    public BorderPane admin_parent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().addListener((observable, oldVal, newVal) -> {
          switch (newVal) {
              case CLIENTS -> admin_parent.setCenter(Model.getInstance().getViewFactory().getClientsView());
              case DEPOSIT -> admin_parent.setCenter(Model.getInstance().getViewFactory().getDepositsView());
              default ->  admin_parent.setCenter(Model.getInstance().getViewFactory().getCreateClientView());
          }
        });
    }
}

package com.example.bank.Views;

import com.example.bank.controllers.Admin.AdminController;
import com.example.bank.controllers.Client.ClientController;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class ViewFactory {
    private AccountType loginAccountType;
    // Client Views
    private final ObjectProperty<ClientMenuOptions> clientSelectedMenuItem;
    private AnchorPane dashboardView;
    private AnchorPane transactionsView;
    private AnchorPane accountsView;

    //Admin Views
    private final ObjectProperty<AdminMenuOptions> adminSelectedMenuItem;
    private AnchorPane createClientView;
    private AnchorPane clientsView;
    private AnchorPane depositsView;

    public ViewFactory() {
        this.loginAccountType = AccountType.CLIENT;
        this.clientSelectedMenuItem = new SimpleObjectProperty<>();
        this.adminSelectedMenuItem = new SimpleObjectProperty<>();
    }

    public AccountType getLoginAccountType() {
        return loginAccountType;
    }

    public void setLoginAccountType(AccountType loginAccountType) {
        this.loginAccountType = loginAccountType;
    }

    public ViewFactory(ObjectProperty<ClientMenuOptions> clientSelectedMenuItem, ObjectProperty<AdminMenuOptions> adminSelectedMenuItem) {
        this.clientSelectedMenuItem = clientSelectedMenuItem;
        this.adminSelectedMenuItem = adminSelectedMenuItem;
    }


    /*
    *Client Views Section
    * */
    public ObjectProperty<ClientMenuOptions> getClientSelectedMenuItem() {
        return clientSelectedMenuItem;
    }

    public AnchorPane getDashboardView() {
        if (dashboardView == null) {
            try{
                dashboardView = new FXMLLoader(getClass().getResource("/fxml/Client/Dashboard.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return dashboardView;
    }

    public AnchorPane getTransactionsView() {
        if (transactionsView == null) {
            try {
                transactionsView = new FXMLLoader(getClass().getResource("/fxml/Client/Transactions.fxml")).load();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return transactionsView;
    }

    public AnchorPane getAccountsView() {
        if (accountsView == null) {
            try {
                accountsView = new FXMLLoader(getClass().getResource("/fxml/Client/Accounts.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return accountsView;
    }

    public void showClientWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Client/Client.fxml"));
        ClientController clientController = new ClientController();
        loader.setController(clientController);
        createStage(loader);
    }
    /*
    * Admin Views Section
    * */

    public ObjectProperty<AdminMenuOptions> getAdminSelectedMenuItem() {
        return adminSelectedMenuItem;
    }


    public AnchorPane getCreateClientView() {
        if (createClientView == null) {
            try {
                createClientView = new FXMLLoader(getClass().getResource("/fxml/Admin/CreateClient.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return createClientView;
    }

    public AnchorPane getClientsView() {
        if (clientsView == null) {
            try {
                clientsView = new FXMLLoader(getClass().getResource("/fxml/Admin/Clients.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return clientsView;
    }

    public AnchorPane getDepositsView() {
        if (depositsView == null) {
            try {
                depositsView = new FXMLLoader(getClass().getResource("/fxml/Admin/Deposit.fxml")).load();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return depositsView;
    }

    public void showAdminWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Admin/Admin.fxml"));
        AdminController controller = new AdminController();
        loader.setController(controller);
        createStage(loader);
    }


    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Login.fxml"));
        createStage(loader);
    }

    private void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
//        stage.getIcons().add(new Image(String.valueOf("/fxml/icon.jpg")));
//        stage.getIcons().add(new Image(<yourclassname>.class.getResourceAsStream("icon.png")));
        stage.setResizable(false);
        stage.setTitle("Bank");
        stage.show();
    }

    public void closeStage(Stage stage){
        stage.close();
    }
}

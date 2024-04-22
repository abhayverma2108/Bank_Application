module com.example.bank {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires de.jensd.fx.glyphs.fontawesome;
    requires java.sql;
    requires org.xerial.sqlitejdbc;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.example.bank to javafx.fxml;
    exports com.example.bank;
    exports com.example.bank.controllers;
    exports com.example.bank.controllers.Admin;
    exports com.example.bank.controllers.Client;
    exports com.example.bank.Models;
    exports com.example.bank.Views;
}
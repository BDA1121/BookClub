module com.example.thebookclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
//    requires eu.hansolo.tilesfx;


    opens com.example.thebookclub to javafx.fxml;
    exports com.example.thebookclub;
}
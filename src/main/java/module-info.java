module com.lolclient {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires org.json;


    opens com.lolclient to javafx.fxml;
    exports com.lolclient;
    exports com.lolclient.model;
    opens com.lolclient.model to javafx.fxml;
}
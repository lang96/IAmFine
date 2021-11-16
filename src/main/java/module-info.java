module com.doraemon.iamfine.iamfine {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens com.doraemon.iamfine.iamfine to javafx.fxml;
    exports com.doraemon.iamfine.iamfine;
}
package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class ConditionPageController {

    @FXML
    private Button backBtn;

    @FXML
    private TextArea textArea;

    @FXML
    public void toUserHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void lul() throws IOException {

        Alert errorAlert = new Alert(Alert.AlertType.CONFIRMATION);
        errorAlert.setHeaderText("Condition update");
        errorAlert.setContentText("Your message will be relayed to your connected social medias!");
        errorAlert.showAndWait();
        Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

}

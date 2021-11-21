package com.doraemon.iamfine;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

import java.io.IOException;

public class TherapistJoinMeetingController {

    @FXML
    private Button backBtn;

    @FXML
    private VBox pane;

    @FXML
    public void toTheraScheduleMeeting() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistMeeting.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void initialize(){
        WebView webView = new WebView();
        webView.getEngine().load("https://meet.google.com/");
        pane.getChildren().add(webView);
    }
}

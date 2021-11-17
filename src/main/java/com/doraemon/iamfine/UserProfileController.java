package com.doraemon.iamfine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserProfileController  implements Initializable {

    ObservableList<String> genderList = FXCollections.observableArrayList("Male", "Female");

    @FXML
    private ComboBox gender;

    @FXML
    private Button backBtn;

    @FXML
    private Hyperlink bindBtn;

    @FXML
    public void toUserHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void toBindingPage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("bindingPage.fxml"));
        Stage window = (Stage) bindBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        gender.setItems(genderList);
    }
}

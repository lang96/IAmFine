package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class BindingPageController {
    @FXML
    private TextField nameTextField, passwordTextField;

    @FXML
    private Label firstName, secondName, thirdName;

    @FXML
    private Button backBtn, addBtn, Del1Btn, Del2Btn, Del3Btn;

    @FXML
    public void toUserProfile() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void addingUserBtn() throws IOException {


    }
}

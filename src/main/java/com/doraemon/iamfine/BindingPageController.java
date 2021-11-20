package com.doraemon.iamfine;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.IOException;

public class BindingPageController extends Application {
    @FXML
    private TextField nameTextField, phoneNumTextField;

    @FXML
    private Label firstName, secondName, thirdName;

    @FXML
    private Button backBtn;

    @FXML
    public void toUserProfile() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("userProfile.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root,335,602));

    }

    @FXML
    public void addingUserBtn() {
        if (nameTextField.getText().equals("") || phoneNumTextField.getText().equals("")) {
            Alert dialog = new Alert(Alert.AlertType.ERROR,
                    "Please Fill in the names and phone number", ButtonType.OK);
            dialog.show();
        } else {
            String name = nameTextField.getText();
            String phoneNum = phoneNumTextField.getText();


            if (firstName.getText().equals("Name")) {
                firstName.setText(name);
            } else if (secondName.getText().equals("Name")) {
                secondName.setText(name);
            } else if (thirdName.getText().equals("Name")) {
                thirdName.setText(name);
            } else {
                Alert dialog = new Alert(Alert.AlertType.ERROR);
                dialog.setTitle("Error");
                dialog.setHeaderText("Reached maximum amount of contact");
                dialog.setContentText("Please delete one of the contact to add more");
                dialog.show();
            }
        }
    }

    @FXML
    public void deleteBtn1() {
        firstName.setText("Name");
    }

    @FXML
    public void deleteBtn2() {
        secondName.setText("Name");
    }

    @FXML
    public void deleteBtn3() {
        thirdName.setText("Name");
    }

    @FXML
    public void whatsappAction(){
        getHostServices().showDocument("https://web.whatsapp.com/");
    }

    @FXML
    public void facebookAction(){
        getHostServices().showDocument("https://www.facebook.com/");
    }

    @FXML
    public void instagramAction(){
        getHostServices().showDocument("https://www.instagram.com/");
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}

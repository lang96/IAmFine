package com.doraemon.iamfine;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import static com.doraemon.iamfine.MainApplication.currentUserID;
import static com.doraemon.iamfine.userType.User.UserList;
import static com.doraemon.iamfine.MainApplication.currentUserID;
import static com.doraemon.iamfine.MainApplication.currentUserID;
import static com.doraemon.iamfine.data.DataOperation.*;
import static com.doraemon.iamfine.userType.Therapist.*;
import static  com.doraemon.iamfine.data.DataOperation.*;

public class TherapistProfileController {

    @FXML
    private Button backBtn;

    @FXML
    private Label fullNameLabel;

    @FXML
    private TextField IDTextField, passwordTextField, phoneNumTextField,
            emailTextField, licenseTextField, experienceTextField;

    @FXML
    private ComboBox<String> gender;

    @FXML
    public void initialize() {

        gender.getItems().removeAll(gender.getItems());
        gender.getItems().addAll("Male", "Female");

        for (int i = 0; i < TherapistList.size(); i++) {

            if (TherapistList.get(i).getUsername().equals(currentUserID)) {

                fullNameLabel.setText(TherapistList.get(i).getFullName());
                IDTextField.setText(TherapistList.get(i).getUsername());
                passwordTextField.setText(TherapistList.get(i).getPassword());
                phoneNumTextField.setText(TherapistList.get(i).getPhone());
                emailTextField.setText(TherapistList.get(i).getEmail());
                licenseTextField.setText(TherapistList.get(i).getLicense());
                experienceTextField.setText(TherapistList.get(i).getExperience());
                gender.getSelectionModel().select(UserList.get(i).getGender());

            }
        }

    }

    @FXML
    public void toTherapistHomepage() throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
        Stage window = (Stage) backBtn.getScene().getWindow();
        window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
        window.setScene(new Scene(root, 335, 602));

    }

    @FXML
    public void confirmBtn() throws IOException {
        if (passwordTextField.getText().equals("") || phoneNumTextField.getText().equals("") ||
                emailTextField.getText().equals("") || licenseTextField.getText().equals("") ||
                experienceTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill all the details below completely!", ButtonType.OK);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setHeaderText("Are you sure to continue?");

            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(yes, no);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == yes) {

                String password = passwordTextField.getText();
                String phone = phoneNumTextField.getText();
                String email = emailTextField.getText();
                String license = licenseTextField.getText();
                String experience = experienceTextField.getText();
                String selectedGender = gender.getSelectionModel().getSelectedItem();

                editTherapist(currentUserID, password, phone, email, license, experience, selectedGender);

                Alert dialogue = new Alert(Alert.AlertType.CONFIRMATION,
                        "Change successful", ButtonType.OK);
                dialogue.showAndWait();
                Parent root = FXMLLoader.load(getClass().getResource("therapistHomepage.fxml"));
                Stage window = (Stage) backBtn.getScene().getWindow();
                window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                window.setScene(new Scene(root, 335, 602));
            }
        }
    }
}


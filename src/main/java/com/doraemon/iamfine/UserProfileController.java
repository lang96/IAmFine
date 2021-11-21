package com.doraemon.iamfine;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import static com.doraemon.iamfine.MainApplication.currentUserID;
import static com.doraemon.iamfine.data.DataOperation.*;
import static com.doraemon.iamfine.userType.User.*;



public class UserProfileController implements Initializable {


    @FXML
    private ComboBox<String> gender;

    @FXML
    private Button backBtn, confirmBtn;

    @FXML
    private Hyperlink bindBtn;

    @FXML
    private Label usernameLabel;

    @FXML
    private TextField passwordTextField,
    phoneNumTextField, emailTextField, ageTextField;

    @FXML
    private TextArea addressTextField;


    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        gender.getItems().removeAll(gender.getItems());
        gender.getItems().addAll("Male", "Female");

        for (int i = 0; i < UserList.size(); i++) {

            if (UserList.get(i).getUsername().equals(currentUserID)) {

                usernameLabel.setText(UserList.get(i).getUsername());
                passwordTextField.setText(UserList.get(i).getPassword());
                addressTextField.setText(UserList.get(i).getAddress());
                phoneNumTextField.setText(UserList.get(i).getPhone());
                emailTextField.setText(UserList.get(i).getEmail());
                ageTextField.setText(UserList.get(i).getAge());
                gender.getSelectionModel().select(UserList.get(i).getGender());

            }

        }

    }

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

    @FXML
    public void confirmAction() throws IOException {
        if (passwordTextField.getText().equals("") || passwordTextField.getText().equals("") ||
                addressTextField.getText().equals("") || phoneNumTextField.getText().equals("") ||
                emailTextField.getText().equals("") || ageTextField.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.ERROR,
                    "Please fill all the details below completely!", ButtonType.OK);
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmation");
            alert.setContentText("Are you sure to continue?");
            ButtonType yes = new ButtonType("Yes");
            ButtonType no = new ButtonType("No");

            alert.getButtonTypes().clear();
            alert.getButtonTypes().addAll(yes, no);
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get() == yes) {

                String password = passwordTextField.getText();
                String phone = phoneNumTextField.getText();
                String email = emailTextField.getText();
                String address = addressTextField.getText();
                String age = ageTextField.getText();
                String selectedGender = gender.getSelectionModel().getSelectedItem();

                editUser(currentUserID, password, phone, email, address, age, selectedGender);

                Alert dialogue = new Alert(Alert.AlertType.NONE,
                        "Change successful", ButtonType.OK);
                dialogue.showAndWait();
                Parent root = FXMLLoader.load(getClass().getResource("userHomepage.fxml"));
                Stage window = (Stage) confirmBtn.getScene().getWindow();
                window.getIcons().add(new Image(this.getClass().getResource("/raw/logo.png").toString()));
                window.setScene(new Scene(root,335,602));
            }
        }
    }
}

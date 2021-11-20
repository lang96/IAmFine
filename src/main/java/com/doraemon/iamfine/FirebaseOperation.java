package com.doraemon.iamfine;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.io.FileInputStream;
import java.io.IOException;

public class FirebaseOperation {

    public static void initFirebase() throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("credentials.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://i-am-fine-c73b6-default-rtdb.asia-southeast1.firebasedatabase.app/")
                .build();

        // .setCredentials(GoogleCredentials.fromStream(serviceAccount))

        FirebaseApp.initializeApp(options);

    }


}

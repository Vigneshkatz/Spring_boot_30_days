package com.katziio.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.util.Objects;

@SpringBootApplication
public class FirebaseCrudApplication {

    public static void main(String[] args) throws Exception {
        ClassLoader classLoader = FirebaseCrudApplication.class.getClassLoader();
        File file = new File(Objects.requireNonNull(classLoader.getResource("serviceApi.json")).getFile());
        String BASE_DB_URL = "https://console.firebase.google.com/u/0/project/fir-a92bb/firestore";
        FileInputStream serviceAccount = new FileInputStream(file.getAbsolutePath());
        try {
            FirebaseOptions options = new FirebaseOptions.Builder().
					setCredentials(GoogleCredentials.fromStream(serviceAccount)).
					setDatabaseUrl(BASE_DB_URL).
					build();
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        SpringApplication.run(FirebaseCrudApplication.class, args);
    }

}

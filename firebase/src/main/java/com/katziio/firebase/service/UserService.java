package com.katziio.firebase.service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.katziio.firebase.entity.User;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class UserService {
    private Firestore dbFireStore = FirestoreClient.getFirestore();

    public String deleteUser(String documentId) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> documentReference =this.dbFireStore.collection("Users")
                .document(documentId).delete();
        return "Successfully Deleted"+documentId;
    }

    public String updateUser(User user) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collection =this.dbFireStore.collection("Users")
                .document(user.getName()).set(user);
        return collection.get().getUpdateTime().toString();
    }

    public User getUser(String documentId) throws ExecutionException, InterruptedException {
        DocumentReference documentReference =this.dbFireStore.collection("Users")
                .document(documentId);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = apiFuture.get();
        User user;
        if(documentSnapshot.exists())
        {
            user = documentSnapshot.toObject(User.class);
            return user;
        }
        return null;
    }

    public String createUser(User user) throws ExecutionException, InterruptedException {
        ApiFuture<WriteResult> collection =this.dbFireStore.collection("Users")
                .document(user.getName()).set(user);
        return collection.get().getUpdateTime().toString();
    }
}

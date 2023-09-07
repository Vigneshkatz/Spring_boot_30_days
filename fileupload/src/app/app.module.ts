import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AngularFireModule } from "@angular/fire/compat";
import { AngularFireStorageModule } from "@angular/fire/compat/storage";

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AngularFireModule.initializeApp({
      apiKey: "AIzaSyBuLKnFnb9ZZJBgZDKG7jv9X4P1qYYPA4A",
      authDomain: "collabwithkatz.firebaseapp.com",
      projectId: "collabwithkatz",
      storageBucket: "collabwithkatz.appspot.com",
      messagingSenderId: "570440142532",
      appId: "1:570440142532:web:39fee0b6507d27f8460391",
      measurementId: "G-DRJPZ22CDS"
    }),
    AngularFireStorageModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

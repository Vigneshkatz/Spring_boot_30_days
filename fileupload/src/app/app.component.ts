import { Component } from '@angular/core';
import { AngularFireStorage } from '@angular/fire/compat/storage';
import { AngularFireUploadTask } from '@angular/fire/compat/storage';
import { Observable } from 'rxjs';
import { finalize } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fileupload';
  task!: AngularFireUploadTask; // Declare the task variable
  // percentage!: Observable<number>;

  constructor(private storage: AngularFireStorage) { }

  uploadFile(event: any) {
    const file = event.target.files[0];
    if (file) {
      // Now you have the selected file, you can proceed with the upload logic
      const filePath = `/uploads/${file.name}`;
      const fileRef = this.storage.ref(filePath);
      this.task = this.storage.upload(filePath, file);

      // Observe the percentage changes
      // this.percentage = this.task.percentageChanges();

      // Finalize the upload and get the download URL
      this.task.snapshotChanges().pipe(
        finalize(() => {
          fileRef.getDownloadURL().subscribe(downloadURL => {
            console.log('File URL:', downloadURL);
          });
        })
      ).subscribe();
    }
  }
}

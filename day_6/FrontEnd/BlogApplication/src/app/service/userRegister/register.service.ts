import { Injectable } from '@angular/core';
import { User } from 'src/app/common/user';
import { BlogApiService } from '../blogApi/blog-api.service';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  
  constructor(private apiService: BlogApiService) {
    // this.loginUser = new LoginUser();
  }
  register(user:User) {
    console.log(user);
    this.apiService.addUser(user).subscribe({
      next: (response: User) => {
        console.log('Received User:', response);
      },
      error: (error) => {
        console.error('Error fetching LoginUser:', error);
      }
    });
  }
}

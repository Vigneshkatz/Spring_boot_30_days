import { LoginUser } from 'src/app/common/login-user';
import { User } from './../../common/user';
import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private apiService: BlogApiService) {
    // this.loginUser = new LoginUser();
  }

  login(email: string, password: string): void {
    const loginUser: LoginUser = new LoginUser(email, password);
    console.log(loginUser);
    this.callLoginApi(loginUser);
  }

  callLoginApi(loginUser: LoginUser): void {
    this.apiService.getUser(loginUser).subscribe({
      next: (response: LoginUser) => {
        console.log('Received LoginUser:', response);
      },
      error: (error) => {
        console.error('Error fetching LoginUser:', error);
      }
    });
  }
}

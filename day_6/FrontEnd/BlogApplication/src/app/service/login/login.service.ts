import { LoginUser } from 'src/app/common/login-user';
import { User } from './../../common/user';
import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private apiService: BlogApiService) {
    // this.loginUser = new LoginUser();
  }

  login(email: string, password: string): Observable<User> { // Return Observable<User>
    const loginUser: LoginUser = new LoginUser(email, password);
    return this.callLoginApi(loginUser);
  }

  callLoginApi(loginUser: LoginUser): Observable<User> {
    return this.apiService.getUser(loginUser);
  }
}


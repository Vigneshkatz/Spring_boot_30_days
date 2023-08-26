import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUser } from 'src/app/common/login-user';
import { User } from 'src/app/common/user';

@Injectable({
  providedIn: 'root'
})
export class BlogApiService {

  private BASE_USER_REGISTER = 'http://localhost:8000/User/addUser';
  private BASE_GET_USER = 'http://localhost:8000/User/getUser'; // Updated URL for getting a user

  constructor(private http: HttpClient) { }

  addUser(user: User): Observable<any> {
    console.log(this.BASE_USER_REGISTER);
    return this.http.post(this.BASE_USER_REGISTER, user);
  }

  getUser(loginUser: LoginUser): Observable<any> {
    const url = `${this.BASE_GET_USER}?email=${encodeURIComponent(loginUser.email)}&password=${loginUser.password}`;
    console.log(this.http.get(url));
    return this.http.get(url);
  }
}

import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { LoginUser } from 'src/app/common/login-user';

@Injectable({
  providedIn: 'root'
})
export class BlogApiService {

  private BASE_USER_REGISTER = 'http://localhost:8000/User/addUser';
  private BASE_GET_USER = 'http://localhost:8000/User/getUser'; // Updated URL for getting a user

  constructor(private http: HttpClient) { }

  addUser(user: LoginUser): Observable<any> {
    // Send a POST request with the user object in the request body
    return this.http.post(this.BASE_USER_REGISTER, user);
  }

  getUser(loginUser: LoginUser): Observable<any> {
    const url = `${this.BASE_GET_USER}?email=${encodeURIComponent(loginUser.email)}&password=${loginUser.password}`;
    console.log(this.http.get(url));
    return this.http.get(url);
  }
}

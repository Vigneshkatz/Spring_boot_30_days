import { Injectable } from '@angular/core';
import { User } from 'src/app/common/user';
import { BlogApiService } from '../blogApi/blog-api.service';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  
  constructor(private apiService: BlogApiService) {
    // this.loginUser = new LoginUser();
  }

  register(user: User): Observable<User> {
    console.log(user);
    return this.apiService.addUser(user);
  }
}

import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';
import { User } from 'src/app/common/user';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private apiService: BlogApiService) { }

  getUserById(userId: number): Observable<User> {
    return this.apiService.getUserById(userId);
  }
}

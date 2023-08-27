import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';
import { Posts } from 'src/app/common/posts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class HomeService {


  constructor(private blogApi:BlogApiService) { }

  getPostList(): Observable<Posts[]> {
    return this.blogApi.getAllPost();
  }
}

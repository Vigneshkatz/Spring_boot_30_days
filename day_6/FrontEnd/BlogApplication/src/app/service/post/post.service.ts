import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';
import { Posts } from 'src/app/common/posts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {


  constructor(private blogApi: BlogApiService) { }
  
  addPost(post: Posts,userId:number): void {
    this.blogApi.addPost(post,userId).subscribe({
      next: (response: Posts) => {
        console.log('Received LoginUser:', response);
      },
      error: (error) => {
        console.error('Error fetching LoginUser:', error);
      }
    });
  }

  getPostById(postId: number): Observable<Posts> {
    return this.blogApi.getPostById(postId);
  }

  getPostByUserId(userId: number) :Observable<Posts[]> {
    return this.blogApi.getAllPostsByUserId(userId);
  }
  
}

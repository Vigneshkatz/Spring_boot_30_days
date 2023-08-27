import { Injectable } from '@angular/core';
import { BlogApiService } from '../blogApi/blog-api.service';
import { Posts } from 'src/app/common/posts';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private apiService: BlogApiService) { }
  
  addPost(post: Posts): void {
    this.apiService.addPost(post).subscribe({
      next: (response: Posts) => {
        console.log('Received LoginUser:', response);
      },
      error: (error) => {
        console.error('Error fetching LoginUser:', error);
      }
    });
  }
}

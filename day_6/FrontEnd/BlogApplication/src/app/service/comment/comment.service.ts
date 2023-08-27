import { Injectable } from '@angular/core';
import { Comment } from 'src/app/common/comment';
import { BlogApiService } from '../blogApi/blog-api.service';

@Injectable({
  providedIn: 'root'
})
export class CommentService {
  

  constructor(private apiService:BlogApiService) { }

  addComment(comment: Comment):void {
    
    this.apiService.addComment(comment).subscribe({
      next: (response: Comment) => {
        console.log('Received Comment:', response);
      },
      error: (error) => {
        console.error('Error fetching Comment:', error);
      }
    });
  }
}
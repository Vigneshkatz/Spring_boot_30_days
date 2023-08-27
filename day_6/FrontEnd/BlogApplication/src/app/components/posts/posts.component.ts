import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Posts } from 'src/app/common/posts';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {
  postId: number = 0;
  post!:Posts;

  constructor(private route: ActivatedRoute,
    private postService:PostService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.postId = +params['id']; // Convert to number
    });
    this.getPostDetails(this.postId);
    
  }

  getPostDetails(postId:number):void{
    this.postService.getPostById(this.postId).subscribe(
      (data: Posts) => {
        console.log(data)
        this.post = data;
      },
      error => {
        console.error('Error fetching post:', error);
      }
    );

  }
}

import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Comment } from 'src/app/common/comment';
import { Posts } from 'src/app/common/posts';
import { CommentService } from 'src/app/service/comment/comment.service';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent {
  postId: number = 0;
  post!:Posts;
  comments:Comment[]=[];

  constructor(private route: ActivatedRoute,
    private postService:PostService,private commentService:CommentService) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.postId = +params['id']; // Convert to number
    });
    this.getPostDetails(this.postId);
    this.getComments(this.postId);
  }
  
  getComments(postId: number):void {
    this.commentService.getCommentList(postId).subscribe((data) => {
      console.log(data);
      this.comments = data;
    });
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

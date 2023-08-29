import { ActivatedRoute } from '@angular/router';
import { Posts } from './../../common/posts';
import { Component } from '@angular/core';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {

  posts: Posts[]=[];
  userId:number=0;

  constructor(private route: ActivatedRoute,
    private postService: PostService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId=+params['userId'];
      console.log(this.userId);
      this.getPostsByUserId(+params['userId']);
    });
    ;
  }

  getPostsByUserId(userId:number){
    this.postService.getPostByUserId(userId).subscribe((data) => {
      console.log(data);
      this.posts = data;
    });
  }

}

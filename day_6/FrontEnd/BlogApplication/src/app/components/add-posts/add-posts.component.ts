import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Posts } from 'src/app/common/posts';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-add-posts',
  templateUrl: './add-posts.component.html',
  styleUrls: ['./add-posts.component.css']
})
export class AddPostsComponent {
  userId!:number;
  constructor(private datePipe: DatePipe,
    private postService: PostService,private route: ActivatedRoute) { }
  postForm: Posts = new Posts(
    0,
    '',
    '',
    '',
    '',
    new Date(),
    new Date(),
    new Date(),
    new Date(),
    []
  );
  tagInput: string = '';


  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId=+params['userId'];
      console.log(params['userId']);
      if (params['userId']) {
        console.log('User ID:', +params['userId']);
      } else {
        console.log('User ID not provided in the route.');
      }
    });
    ;
  }

  onSubmit(form: any) {
    console.log(this.postForm);
    const formattedPublishedAt = this.datePipe.transform(this.postForm.published_at, 'yyyy-MM-dd HH:mm:ss');
    console.log('Formatted Published At:', formattedPublishedAt);
    this.postService.addPost(this.postForm,this.userId);
  }
}

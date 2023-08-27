import { DatePipe } from '@angular/common';
import { Component } from '@angular/core';
import { Posts } from 'src/app/common/posts';
import { PostService } from 'src/app/service/post/post.service';

@Component({
  selector: 'app-add-posts',
  templateUrl: './add-posts.component.html',
  styleUrls: ['./add-posts.component.css']
})
export class AddPostsComponent {
  constructor(private datePipe: DatePipe,
    private postService: PostService) { }
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

  onSubmit(form: any) {
    console.log(this.postForm);
    const formattedPublishedAt = this.datePipe.transform(this.postForm.published_at, 'yyyy-MM-dd HH:mm:ss');
    console.log('Formatted Published At:', formattedPublishedAt);
    this.postService.addPost(this.postForm);
  }
}

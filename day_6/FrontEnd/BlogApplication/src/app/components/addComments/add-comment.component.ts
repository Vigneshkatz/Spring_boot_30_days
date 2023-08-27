import { Component } from '@angular/core';
import { Comment } from 'src/app/common/comment';
import { CommentService } from 'src/app/service/comment/comment.service';
@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.css']
})
export class AddCommentComponent {
  comment: Comment = new Comment(
    0,
    '',
    '',
    '',
    new Date(),
    new Date()
  );

  constructor(private commentService : CommentService)
  {

  }
  onSubmit() {
    console.log(this.comment);
    this.commentService.addComment(this.comment);
  }

}

import { Component } from '@angular/core';
import { Posts } from 'src/app/common/posts';
import { HomeService } from 'src/app/service/home/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  public posts:Posts[]=[];

  constructor(private homeService:HomeService)
  {

  }

  ngOnInit() {
    this.getPostList();
  }

  getPostList(){
    this.homeService.getPostList().subscribe(
      data => {
        console.log(data);
        this.posts = data;
      }
    );
  }
  
}

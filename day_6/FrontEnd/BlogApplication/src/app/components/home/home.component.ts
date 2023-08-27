import { UserService } from './../../service/user/user.service';
import { Component } from '@angular/core';
import { Posts } from 'src/app/common/posts';
import { User } from 'src/app/common/user';
import { HomeService } from 'src/app/service/home/home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  public posts:Posts[]=[];
  public user: User | null = null; 
  constructor(private homeService:HomeService, private userService:UserService)
  {

  }

  ngOnInit() {
    this.getUser();
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
  getUser(){
    console.log("calling getUser")
    // this.userService.getUser();
    this.userService.getUserById(7).subscribe(
      data => {
        console.log(data);
        this.user = data; // Assign the fetched user data to the user property
      },
      error => {
        console.error('Error fetching user:', error);
      }
    );
  }
  
}

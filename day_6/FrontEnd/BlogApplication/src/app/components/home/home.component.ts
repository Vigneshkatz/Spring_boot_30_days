import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { HomeService } from 'src/app/service/home/home.service';
import { Posts } from 'src/app/common/posts';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/service/user/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  public posts: Posts[] = [];
  public user: User | null = null;
  page: number = 1;

  constructor(
    private homeService: HomeService,
    private route: ActivatedRoute,
    private userService: UserService
  ) { }

  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      const userId = params['userId'];
      if (userId) {
        this.getUser(userId);
      }
    });

    this.getPostList();
  }

  getPostList() {
    this.homeService.getPostList().subscribe((data) => {
      console.log(data);
      this.posts = data;
    });
  }

  getUser(userId: number) {
    console.log('calling getUser');
    this.userService.getUserById(userId).subscribe(
      (data) => {
        console.log(data);
        this.user = data;
      },
      (error) => {
        console.error('Error fetching user:', error);
      }
    );
  }
}

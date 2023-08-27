import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login/login.service';
import { Router } from '@angular/router';
import { User } from 'src/app/common/user';
import { UserService } from 'src/app/service/user/user.service';
import { HomeService } from 'src/app/service/home/home.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private service: LoginService,
    private homeService:HomeService,
    private router: Router) { }

  fetchFormValue(user_email: string, user_password: string): void {
    this.service.login(user_email, user_password).subscribe(
      (response: User) => {
        console.log('Received LoginUser:', response);
        // Check if the user exists
        if (response) {
          // Navigate to home page and pass the user ID as a query parameter
          this.router.navigate(['/home'], { queryParams: { userId: response.id } });
        }
      },
      (error) => {
        console.error('Error fetching LoginUser:', error);
      }
    );
  }
}

import { Component } from '@angular/core';
import { User } from 'src/app/common/user';
import { RegisterService } from 'src/app/service/userRegister/register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private registerService: RegisterService, private router: Router) {}

  fetchFormValue(user_name: string, user_email: string, user_password: string) {
    const user: User = new User(user_name, user_email, user_password);
    this.registerService.register(user).subscribe(
      (response) => {
        console.log('User registered:', response);
        if (response) {
          // Navigate to home page and pass the user ID as a query parameter
          this.router.navigate(['/home'], { queryParams: { userId: response.id } });
        }
      },
      (error) => {
        console.error('Error registering user:', error);
      }
    );
  }
}

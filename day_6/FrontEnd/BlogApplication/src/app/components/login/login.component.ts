import { Component } from '@angular/core';
import { LoginService } from 'src/app/service/login/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  constructor(private service: LoginService) { }
  fetchFormValue(user_email: string, user_password: string): void {
    this.service.login(user_email, user_password);
  }
}

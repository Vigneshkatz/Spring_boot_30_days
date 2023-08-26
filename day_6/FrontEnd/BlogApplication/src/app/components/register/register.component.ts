import { Component } from '@angular/core';
import { User } from 'src/app/common/user';
import { RegisterService } from 'src/app/service/userRegister/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private registerService: RegisterService) {

  }
  fetchFormValue(user_name: string, user_email: string, user_password: string) {
    const user:User = new User(user_name,user_email,user_password);
    this.registerService.register(user);
  }

}

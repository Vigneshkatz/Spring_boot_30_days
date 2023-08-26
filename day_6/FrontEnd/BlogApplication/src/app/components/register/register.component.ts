import { Component } from '@angular/core';
import { RegisterService } from 'src/app/service/register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  constructor(private registerService: RegisterService) {

  }
  fetchFormValue(user_name: string, user_email: string, user_password: string) {
    this.registerService.register(user_name, user_email, user_password);
  }

}

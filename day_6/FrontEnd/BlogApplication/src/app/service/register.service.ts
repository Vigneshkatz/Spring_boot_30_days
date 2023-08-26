import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {
  
  register(user_name: string, user_email: string, user_password: string) {
    console.log(user_name, user_email, user_password);
  }

  constructor() { }
}

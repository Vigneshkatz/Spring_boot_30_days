import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  login(email: string, password: string): void {
    console.log('AuthService received:', email, password);
  }
}

export class LoginUser {
  public password: string;
  public email: string;

  constructor(email: string, password: string) {
    this.email = email;
    this.password = password;
  }
}

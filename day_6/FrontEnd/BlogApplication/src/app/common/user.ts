import { Posts } from './posts';
export class User {
    public id!: number | null;
    public name: string | null;
    public email!: string | null;
    public password!: string | null;
    public posts: Posts[] =[];
    constructor(name: string,
        email: string,
        password: string
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}

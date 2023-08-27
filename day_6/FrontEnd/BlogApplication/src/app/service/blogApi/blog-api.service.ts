import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { LoginUser } from 'src/app/common/login-user';
import { User } from 'src/app/common/user';
import { Posts } from 'src/app/common/posts';
import { Comment } from 'src/app/common/comment';

@Injectable({
  providedIn: 'root'
})
export class BlogApiService {

  private BASE_USER_REGISTER = 'http://localhost:8000/User/addUser';
  private BASE_GET_USER = 'http://localhost:8000/User/getUser';
  private BASE_URL = "http://localhost:8000";

  constructor(private http: HttpClient) { }

  // REGISTER USER
  addUser(user: User): Observable<any> {
    console.log(this.BASE_USER_REGISTER);
    return this.http.post(this.BASE_USER_REGISTER, user);
  }
  // LOGIN USER
  getUser(loginUser: LoginUser): Observable<any> {
    const url = `${this.BASE_GET_USER}?email=${encodeURIComponent(loginUser.email)}&password=${loginUser.password}`;
    console.log(this.http.get(url));
    return this.http.get(url);
  }
  getUserById(id: number): Observable<any> {
    const url = `${this.BASE_URL}/User/${id}`;
    console.log(this.http.get(url));
    return this.http.get(url);
  }

  // POST SECTION
  // ADD USER
  addPost(post: Posts): Observable<any> {
    console.log(JSON.stringify(post))
    const url = `${this.BASE_URL}/blogApi/1/addPost`;
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post(url, post, httpOptions);
  }

  getAllPost(): Observable<Posts[]> {
    const url = `${this.BASE_URL}/blogApi/getPosts`;
    return this.http.get<Posts[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching posts:', error);
        return throwError('Error fetching posts.');
      })
    );
  }

  // COMMENT SECTION
  addComment(comment: Comment): Observable<Comment> {
    const url = `${this.BASE_URL}/blogApi/1/addComments`;
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };

    return this.http.post<Comment>(url, comment, httpOptions).pipe(
      catchError((error) => {
        console.error('Error adding comment:', error);
        return throwError('Error adding comment.');
      })
    );
  }

  getPostById(postId: number): Observable<Posts> {
    const url = `${this.BASE_URL}/blogApi/getPost/${postId}`;
    return this.http.get<Posts>(url).pipe(
      catchError((error) => {
        console.error('Error adding comment:', error);
        return throwError('Error adding comment.');
      })
    );
  }
}
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
  private BASE_URL = "http://localhost:8000";

  constructor(private http: HttpClient) { }

  // REGISTER USER
  addUser(user: User): Observable<any> {
    const url = `${this.BASE_URL}/users`;
    return this.http.post(url, user);
  }

  // LOGIN USER
  getUser(loginUser: LoginUser): Observable<any> {
    const url = `${this.BASE_URL}/users/login`;
    const params = {
      email: loginUser.email,
      password: loginUser.password
    };
    return this.http.get(url, { params });
  }

  getUserById(userId: number): Observable<any> {
    const url = `${this.BASE_URL}/users/${userId}`;
    return this.http.get(url);
  }

  // POST SECTION
  // ADD POST
  addPost(post: Posts,useId:number): Observable<any> {
    const url = `${this.BASE_URL}/blogApi/users/${useId}/posts`;
    const httpOptions = {
      headers: new HttpHeaders({ 'Content-Type': 'application/json' })
    };
    return this.http.post(url, post, httpOptions);
  }

  getAllPosts(): Observable<Posts[]> {
    const url = `${this.BASE_URL}/blogApi/posts`;
    return this.http.get<Posts[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching posts:', error);
        return throwError('Error fetching posts.');
      })
    );
  }

  getPostById(postId: number): Observable<Posts> {
    const url = `${this.BASE_URL}/blogApi/posts/${postId}`;
    return this.http.get<Posts>(url).pipe(
      catchError((error) => {
        console.error('Error fetching post:', error);
        return throwError('Error fetching post.');
      })
    );
  }

  // COMMENT SECTION
  addComment(comment: Comment): Observable<Comment> {
    const url = `${this.BASE_URL}/blogApi/posts/1/comments`;
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

  getCommentsByPostId(postId: number): Observable<Comment[]> {
    const url = `${this.BASE_URL}/blogApi/posts/${postId}/comments`;
    return this.http.get<Comment[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching comments:', error);
        return throwError('Error fetching comments.');
      })
    );
  }

  getAllPostsByUserId(userId: number): Observable<Posts[]> {
    const url = `${this.BASE_URL}/blogApi/${userId}/posts`;
    return this.http.get<Posts[]>(url).pipe(
      catchError((error) => {
        console.error('Error fetching posts:', error);
        return throwError('Error fetching posts.');
      })
    );
  }

}


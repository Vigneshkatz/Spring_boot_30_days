import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
// import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { PostsComponent } from './components/posts/posts.component';
import { RegisterComponent } from './components/register/register.component';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AddPostsComponent } from './components/add-posts/add-posts.component';
import { DatePipe } from '@angular/common'; // Remove DatePipe from here
import { AddCommentComponent } from './components/addComments/add-comment.component';
import { ProfileComponent } from './components/profile/profile.component';

const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // Default route
  { path: 'home', component: HomeComponent },
  { path: 'post', component: PostsComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'addPost/:userId', component: AddPostsComponent },
  { path: 'addComment', component: AddCommentComponent },
  { path: 'profile/:userId', component: ProfileComponent },
  { path: 'post/:id', component: PostsComponent }
];


@NgModule({
  declarations: [
    AppComponent,
    RegisterComponent,
    LoginComponent,
    HomeComponent,
    PostsComponent,
    AddPostsComponent,
    AddCommentComponent,
    ProfileComponent,
  ],
  imports: [
    BrowserModule,
    // AppRoutingModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [DatePipe], // Add DatePipe to providers
  bootstrap: [AppComponent]
})
export class AppModule { }

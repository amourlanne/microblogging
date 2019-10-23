import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { HttpClientModule } from '@angular/common/http';

import {AppRoutingModule} from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { PostComponent } from './post/post.component';
import { PubComponent } from './pub/pub.component';
import { HomepageComponent } from './homepage/homepage.component';
import { ProfilpageComponent } from './profilpage/profilpage.component';
import { EditpostComponent } from './editpost/editpost.component';
import { ProfilComponent } from './profil/profil.component';
import {ReactiveFormsModule} from '@angular/forms';
import { CommentComponent } from './comment/comment.component';


@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    PostComponent,
    PubComponent,
    HomepageComponent,
    ProfilpageComponent,
    EditpostComponent,
    ProfilComponent,
    CommentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Post } from '../model/post.model';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  private postUrl = 'http://localhost:8080/api/posts';

  constructor(private httpClient: HttpClient) {
  }

  public getPosts(): Observable<Post[]> {
    return this.httpClient.get<Post[]>(this.postUrl);
  }

}

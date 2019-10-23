import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Post} from '../model/post.model';

@Injectable({
  providedIn: 'root'
})
export class EditPostService {
  private postUrl = 'http://localhost:8080/api/posts';

  constructor(private httpClient: HttpClient) {
  }

  public savePostToServer(post: Post) {
    this.httpClient
      .post(this.postUrl, post)
      .subscribe(
        () => {
          console.log('Enregistrement terminé !');
        },
        (error) => {
          console.log('Erreur ! : ' + error);
        }
      );
  }

}

import { Component, OnInit } from '@angular/core';
import { Post } from '../model/post.model';
import { PostService } from '../services/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  posts: Post[] = [];
  constructor(private postService: PostService) {
  }

  ngOnInit() {
    this.postService.getPosts().subscribe( data =>  {
      this.posts = data;
      console.log(this.posts);
    });
  }

}

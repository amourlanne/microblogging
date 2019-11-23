import {Component, OnInit} from '@angular/core';
import {Post} from '../model/post.model';
import {EditPostService} from '../services/editPost.service';
import {FormBuilder} from '@angular/forms';

@Component({
  selector: 'app-editpost',
  templateUrl: './editpost.component.html',
  styleUrls: ['./editpost.component.scss']
})

export class EditpostComponent implements OnInit {
  checkoutForm;
  items;

  constructor(private editPostService: EditPostService, private formBuilder: FormBuilder) {
    this.checkoutForm = this.formBuilder.group({
      name: '',
      content: ''
    });
  }

  ngOnInit() {
  }

  onSubmit(postData) {
    console.log('data saved', postData);
    this.items = this.editPostService.savePostToServer(postData);
    this.checkoutForm.reset();
  }

}


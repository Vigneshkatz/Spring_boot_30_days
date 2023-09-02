import { Component } from '@angular/core';

@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent {
  tags:string[]=[];

  tagInput: string = '';

  submitForm() {
    const tagsArray = this.tagInput.split(' ');
    const validTags = tagsArray.filter(tag => tag.trim() !== ''  && tag.startsWith('#'));
    this.tags.push(...validTags);
    console.log(this.tags);
  }
}

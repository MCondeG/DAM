import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Comic } from '../modelo/Comic';

@Component({
  selector: 'app-ver-comic',
  templateUrl: './ver-comic.page.html',
  styleUrls: ['./ver-comic.page.scss'],
})
export class VerComicPage implements OnInit {

  comic:Comic;
  imageComic:string;

  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.comic = JSON.parse(params["comic"]);
      console.log(this.comic);
    });
  }
  ngOnInit(): void {
    
  }

}

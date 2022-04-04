import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Movie } from 'src/modelo/Movie';
import { ApiService } from 'src/providers/api-service/ApiService';

@Component({
  selector: 'app-pagina3',
  templateUrl: './pagina3.page.html',
  styleUrls: ['./pagina3.page.scss'],
})
export class Pagina3Page implements OnInit {

  movie: Movie;

  constructor(private activatedRoute: ActivatedRoute,
    private apiService: ApiService,
    private navCtrl: NavController) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.movie = JSON.parse(params["movie"]);
      console.log(this.movie);
    });
  }

  ngOnInit() {
    
  }
}
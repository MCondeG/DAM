import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Hotel } from '../modelo/Hotel';

@Component({
  selector: 'app-valoraciones',
  templateUrl: './valoraciones.page.html',
  styleUrls: ['./valoraciones.page.scss'],
})
export class ValoracionesPage implements OnInit {

  private hotel:Hotel;
  
  constructor(public activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.hotel = JSON.parse(params["hotel"]);
      console.log(this.hotel);
    });
  }

  ngOnInit() {
  }

}

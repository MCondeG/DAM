import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import { Ciudad } from '../modelo/Ciudad';
import { Hotel } from '../modelo/Hotel';

@Component({
  selector: 'app-hoteles',
  templateUrl: './hoteles.page.html',
  styleUrls: ['./hoteles.page.scss'],
})
export class HotelesPage implements OnInit {

  private ciudad: Ciudad;

  constructor(public activatedRoute: ActivatedRoute,
    public navCtrl: NavController) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.ciudad = JSON.parse(params["ciudad"]);
      console.log(this.ciudad);
    });
  }

  ngOnInit() {
  }

  hotelClick(hotel: Hotel) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        hotel: JSON.stringify(hotel)
      }
    };
    this.navCtrl.navigateForward('/valoraciones', navigationExtras);
  }

}

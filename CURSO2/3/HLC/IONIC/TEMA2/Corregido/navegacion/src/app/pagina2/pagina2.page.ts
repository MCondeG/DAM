import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-pagina2',
  templateUrl: './pagina2.page.html',
  styleUrls: ['./pagina2.page.scss'],
})
export class Pagina2Page implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      let alumno:Alumno = JSON.parse(params["alumno"]);
      console.log(alumno);
    });
  }

  ngOnInit() {
  }

  ionViewWillLeave(): void {
    console.log('ionViewWillLeave pagina2');
  }

  ionViewDidLeave() {
    console.log('ionViewDidLeave pagina2');
  }

  ngOnDestroy() {
    console.log('ngOnDestroy pagina2');
  }

}

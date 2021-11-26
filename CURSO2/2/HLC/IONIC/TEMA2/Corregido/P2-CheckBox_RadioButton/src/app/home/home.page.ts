import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  apellidos:string="";
  nombre:string="";
  provincia:string="";
  familiaNumerosa:boolean;
  estadoCivil:string="";

  constructor() {}

}

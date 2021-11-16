import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { User } from '../modelo/User';

@Component({
  selector: 'app-user',
  templateUrl: './user.page.html',
  styleUrls: ['./user.page.scss'],
})
export class UserPage implements OnInit {

  private user: User;
  private numero: number;
  /*
  Esta página recibe parámetros de la anterior dentro de 'queryParams'
  Cargo sobre atributos de la clase los valores pasados como parámetros.
  El parámetro 'user' se pasó en formato JSON. Lo parseo para obtener un objeto.
  */
  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.user = JSON.parse(params["user"]);
      this.numero = params["numero"];
      console.log(this.user.gender);
    });
  }

  ngOnInit() {
    console.log(this.user.username);
  }

}
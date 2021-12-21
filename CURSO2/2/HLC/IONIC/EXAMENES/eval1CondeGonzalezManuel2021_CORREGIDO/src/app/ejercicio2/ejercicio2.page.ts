import { Component, OnInit } from '@angular/core';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { Usuario } from '../modelo/Usuario';

@Component({
  selector: 'app-ejercicio2',
  templateUrl: './ejercicio2.page.html',
  styleUrls: ['./ejercicio2.page.scss'],
})
export class Ejercicio2Page implements OnInit {

  private usuarios=new Array<Usuario>();
  dniPasaporte:string='';
  familiaNumerosa:boolean=false;

  constructor(private apiService: ApiServiceProvider) { }

  ngOnInit() {

    this.apiService.getUsuarios()
      .then( (usuarios:Usuario[])=> {
          this.usuarios=usuarios;
          console.log(this.usuarios);
      })
      .catch( (error:string) => {
          console.log(error);
      });

  }

}

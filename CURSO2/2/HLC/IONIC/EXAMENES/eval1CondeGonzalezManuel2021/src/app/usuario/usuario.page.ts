import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Usuario } from '../modelo/Usuario';

@Component({
  selector: 'app-usuario',
  templateUrl: './usuario.page.html',
  styleUrls: ['./usuario.page.scss'],
})

export class UsuarioPage implements OnInit {

  private usuario: Usuario;

  constructor(private activatedRoute: ActivatedRoute) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.usuario = JSON.parse(params["usuario"]);
      console.log(this.usuario);
    });
  }

  ngOnInit() {
    console.log(this.usuario);
  }

}
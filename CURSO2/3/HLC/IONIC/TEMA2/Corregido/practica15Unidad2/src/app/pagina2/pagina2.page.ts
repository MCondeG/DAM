import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AlertController, NavController } from '@ionic/angular';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-pagina2',
  templateUrl: './pagina2.page.html',
  styleUrls: ['./pagina2.page.scss'],
})
export class Pagina2Page implements OnInit {

  
  alumno: Alumno;
  
  constructor(private alertController: AlertController, private activatedRoute: ActivatedRoute){
    this.activatedRoute.queryParams.subscribe(params => {
      this.alumno = JSON.parse(params["alumno"]);
    });
  }

  ngOnInit() {
    let mensaje:string;
    mensaje="nombre: "+this.alumno.nombre+" "+this.alumno.apellidos;
    mensaje+=" edad: "+this.alumno.edad;
    mensaje+=" dni: "+this.alumno.dni;
    mensaje+=" dni padre: "+this.alumno.dniPadre;
    mensaje+=" dni padre: "+this.alumno.dniMadre;
    mensaje+=" sexo: "+this.alumno.sexo;
    mensaje+=" trabaja: "+this.alumno.trabaja;
    this.presentAlert(mensaje);
  }

  async presentAlert(mensaje:string) {
    const alert = await this.alertController.create({
      header: 'Alert',
      subHeader: 'Important message',
      message: mensaje,
      buttons: ['OK'],
    });
    await alert.present();
  }

}//end_class


import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-add-partido',
  templateUrl: './add-partido.page.html',
  styleUrls: ['./add-partido.page.scss'],
})
export class AddPartidoPage implements OnInit {

  formulario: FormGroup;
  equipos:string[]=["Sevilla","Betis","Madrid","Barcelona"];
  constructor(public modalCtrl: ModalController) { }

  ngOnInit() {
    this.formulario = new FormGroup({
      equipoLocal: new FormControl('', Validators.required),
      equipoVisitante: new FormControl('', Validators.required)
    });
  }

  onSubmit(valores: any) {
    let partido: Partido = new Partido();
    partido.equipoLocal=valores.equipoLocal;
    partido.equipoVisitante=valores.equipoVisitante;
    this.modalCtrl.dismiss(partido); 
  }

  closeModal(){
    this.modalCtrl.dismiss(); 
  }

}

import { Component, Input, OnInit } from '@angular/core';
import { DomSanitizer } from '@angular/platform-browser';
import { ModalController } from '@ionic/angular';
import { Expediente } from '../modelo/Expediente';

@Component({
  selector: 'app-ver-documento',
  templateUrl: './ver-documento.page.html',
  styleUrls: ['./ver-documento.page.scss'],
})
export class VerDocumentoPage implements OnInit {

  @Input() expedienteJson;
  expediente: Expediente;
  safeUrl: any;

  constructor(public modalCtrl: ModalController,
    private domSanit: DomSanitizer) {
  }

  getSafeUrl() {
    return this.domSanit.bypassSecurityTrustResourceUrl(this.expediente.urlFile);
  }

  ngOnInit() {
    this.expediente = Expediente.createFromJsonObject(JSON.parse(this.expedienteJson));
    this.safeUrl = this.getSafeUrl();
  }

  public closeModal() {
    this.modalCtrl.dismiss();
  }

}

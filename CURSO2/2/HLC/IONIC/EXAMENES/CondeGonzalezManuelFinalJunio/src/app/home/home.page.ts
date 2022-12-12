import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController, ToastController } from '@ionic/angular';
import { stringify } from 'querystring';
import { ApiServiceProvider } from 'src/app/providers/api-service/api-service';
import { FireServiceProvider } from 'src/app/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/app/providers/api-service/InterfaceProvider';
import { AddPartidoPage } from '../add-partido/add-partido.page';
import { GestionPartidoPageModule } from '../gestion-partido/gestion-partido.module';
import { GestionPartidoPage } from '../gestion-partido/gestion-partido.page';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private partidos = new Array<Partido>();
  private dataProvider: InterfaceProvider;

  constructor(private apiService: ApiServiceProvider,
    public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController,
    public alertCtrl: AlertController) {

    this.dataProvider = this.firebaseService;
  }


  ngOnInit(): void {
    this.dataProvider.getPartidos().subscribe((resultadoConsulta) => {
      this.partidos = new Array<Partido>();
      resultadoConsulta.forEach((datos: any) => {
        let partido: Partido = Partido.createFromJsonObject(datos.payload.doc.data());
        this.partidos.push(partido);
      })
    });
  }

  
  async nuevoPartido() {
    const modal = await this.modalController.create({
      component: AddPartidoPage,
      componentProps: {
      }
    });

    modal.onDidDismiss().then((dataNuevoPartido) => {
      let nuevoPartido: Partido = dataNuevoPartido['data'];
      if (nuevoPartido != null) {
        console.log(nuevoPartido);
        this.dataProvider.insertarPartido(nuevoPartido)
          .then((partido: Partido) => {
            this.partidos.push(partido);
          })
          .catch((error: string) => {
            console.log(error);
            this.presentToast("Error al insertar: " + error);
          });
      }
    });
    return await modal.present();
  }


  async gestionPartido(partido: Partido) {
    const modal = await this.modalController.create({
      component: GestionPartidoPage,
      componentProps: {
        'idPartido': 'partido.id',
        'equipoLocal': 'partido.equipoLocal',
        'equipoVisitante': 'partido.equipoVisitante',
        'puntosLocal': 'partido.puntosLocal',
        'puntosVisitante': 'partido.puntosVisitante'
      }
    });

    modal.onDidDismiss().then(() => {

    });
    return await modal.present();
  }


  async borrarPartido(partido: Partido) {

    this.dataProvider.borrarPartido(partido.id);
  }


  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }
}
import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController, ToastController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/app/providers/api-service/api-service';
import { FireServiceProvider } from 'src/app/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/app/providers/api-service/InterfaceProvider';
import { AddPartidoPage } from '../add-partido/add-partido.page';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private partidos = new Array<Partido>();
  private dataProvider: InterfaceProvider;

  //se inyectan los dos providers para poder cambiar entre firebase y json-server
  constructor(private apiService: ApiServiceProvider,
    public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController,
    public alertCtrl: AlertController) {

    //el atributo dataProvider permite cambiar la gestión de los datos entre firebase y json-server
    this.dataProvider = this.firebaseService;
  }

  /*
  cuando se carga la pantalla se llama al método getAlumnos de la Api. 
  Este es un método asíncrono que devuelve un objeto Promise del que debe ser evaluado el resultado.
  Si el acceso a la Api ha ido bien se ejecuta el código asociado a la cláusula then.  
  Símplemente se coge el array de alumnos que llega y se asocia a él el atributo alumnos de la clase.
  Si ha ido mal el acceso (por ejemplo si no hemos lanzado jsonServer) se coge el error que llega y se muestra por consola.
  */

  ngOnInit(): void {
    this.dataProvider.getPartidos().subscribe((resultadoConsulta) => {
      this.partidos = new Array<Partido>();
      resultadoConsulta.forEach((datos: any) => {
        let partido: Partido = Partido.createFromJsonObject(datos.payload.doc.data());
        this.partidos.push(partido);
      })
    });
  }

  /*
  este método pasa a un activity abierto en modal objeto alumno recién creado.
  El activity tiene un formulario para editar los datos. 
  Si los datos son válidos y se pulsa aceptar en el activity se devuelve el objeto alumno con los datos nuevos.
  En este caso se añade el nuevo objeto alumno al array.
  Si se pulsa cancelar en el activity se devuelve null.
  */
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
            this.partidos.push(partido);  //si se ha insertado en la api se añade en la lista
          })
          .catch((error: string) => {
            console.log(error);
            this.presentToast("Error al insertar: " + error);
          });
      }
    });
    return await modal.present();
  } //end_nuevoPartido

  iniciarPartido(indice: number) {
    this.partidos[indice].horaInicioPartido = new Date().getTime();
    this.firebaseService.modificarPartido(this.partidos[indice])
      .then((partido: Partido) => {
        //inserción correcta
      })
      .catch((error: Error) => {
        console.log(error.message);
      });
  }

  finalizarPrimerTiempo(indice: number) {
    this.partidos[indice].horaFinPrimeraParte = new Date().getTime();
    this.firebaseService.modificarPartido(this.partidos[indice])
      .then((partido: Partido) => {
        //inserción correcta
      })
      .catch((error: Error) => {
        console.log(error.message);
      });
  }

  iniciarSegundoTiempo(indice: number) {
    this.partidos[indice].horaInicioSegundaParte = new Date().getTime();
    this.firebaseService.modificarPartido(this.partidos[indice])
      .then((partido: Partido) => {
        //inserción correcta
      })
      .catch((error: Error) => {
        console.log(error.message);
      });
  }

  finalizarPartido(indice: number) {
    this.partidos[indice].horaFinPartido = new Date().getTime();
    this.firebaseService.modificarPartido(this.partidos[indice])
      .then((partido: Partido) => {
        //inserción correcta
      })
      .catch((error: Error) => {
        console.log(error.message);
      });
  }

  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }

  confirmar(mensaje: string, indice: number, accion: string) {
    this.alertCtrl.create({
      message: mensaje,
      buttons: [
        {
          text: 'Confirmar',
          handler: () => {
            switch (accion) {
              case 'INICIAR_PARTIDO':
                this.iniciarPartido(indice);
                break;
              case 'FINALIZAR_PRIMER_TIEMPO':
                this.finalizarPrimerTiempo(indice);
                break;
              case 'INICIAR_SEGUNDO_TIEMPO':
                this.iniciarSegundoTiempo(indice);
                break;
              case 'FINALIZAR_PARTIDO':
                this.finalizarPartido(indice);
                break;
            }
          }
        },
        {
          text: 'Cancelar',
          handler: () => {
            console.log('Cancelar');
          }
        }
      ]
    }).then(res => {
      res.present();
    });
  }//end_confirmar

}//end_class
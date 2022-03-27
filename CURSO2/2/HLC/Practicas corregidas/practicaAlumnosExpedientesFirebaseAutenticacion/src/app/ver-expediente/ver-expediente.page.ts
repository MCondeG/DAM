import { Component, Input, OnInit } from '@angular/core';
import { ModalController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/providers/api-service/InterfaceProvider';
import { Alumno } from '../modelo/Alumno';
import { NuevoEspedientePage } from '../nuevo-espediente/nuevo-espediente.page';
import { VerDocumentoPage } from '../ver-documento/ver-documento.page';

@Component({
  selector: 'app-ver-expediente',
  templateUrl: './ver-expediente.page.html',
  styleUrls: ['./ver-expediente.page.scss'],
})


export class VerExpedientePage implements OnInit {

  @Input() alumnoJson;
  alumno: Alumno;
  modificadoExpediente: boolean = false;
  private dataProvider: InterfaceProvider;

  constructor(public modalCtrl: ModalController,
    public firebaseService: FireServiceProvider
  ) {
    this.dataProvider = this.firebaseService;
  }

  ngOnInit() {
    this.alumno = Alumno.createFromJsonObject(JSON.parse(this.alumnoJson));
  }

  async nuevoExpediente() {

    const modal = await this.modalCtrl.create({
      component: NuevoEspedientePage,
      componentProps: {
        'alumnoJson': JSON.stringify(this.alumno)
      }
    });

    modal.onDidDismiss().then((dataAlumnoModificado) => {
      let alumnoModificado: Alumno = dataAlumnoModificado['data'];
      if (alumnoModificado != null) {
        this.alumno = alumnoModificado;
        this.modificadoExpediente = true;
      }
      else {
        //ha habido un error al insertar o se ha pulsado cancelar
        //no se hace nada
      }
    });
    return await modal.present();
  } //end_nuevoExpediente

  public closeModal() {
    if (this.modificadoExpediente) {
      //el alumno se ha modificado. Devuelvo el objeto alumno modificado
      this.modalCtrl.dismiss(this.alumno);
    }
    else {
      //el alumno no se ha modificado. No devuelvo datos
      this.modalCtrl.dismiss();
    }
  }

  async verDocumento(indice: number) {
    const modal = await this.modalCtrl.create({
      component: VerDocumentoPage,
      componentProps: {
        'expedienteJson': JSON.stringify(this.alumno.expedientes[indice])
      }
    });
    return await modal.present();  
  }//end_verDocumento

  eliminarDocumento(indice: number) {
    this.dataProvider.removeFile(this.alumno.expedientes[indice].urlFile)
      .then( (data) => {
        //se ha borrado el archivo de forma correcta
        //quito el documento del expediente del alumno 
        this.alumno.expedientes.splice(indice, 1);
        //modifico los datos del alumno en firebase
        this.dataProvider.modificarAlumno(this.alumno)
          .then(data => {
            //los datos del alumno se han modificado de forma correcta
            this.modificadoExpediente = true;
          })
          .catch(error => {
            console.log(error);
          })
      })
      .catch(error => {
        console.log(error);
      })
  }//end_eliminarDocumento


}//end_class

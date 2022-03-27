import { Component } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ApiServiceProvider } from '../providers/api-service/api-service';
import { FireServiceProvider } from '../providers/api-service/fire-service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  nombresColecciones: string[] = new Array();
  datosColeccion: any[];
  validations_form: FormGroup;

  constructor(public apiService: ApiServiceProvider,
    public formBuilder: FormBuilder,
    public fireService: FireServiceProvider) {
    this.validations_form = this.formBuilder.group({
      urlFile: new FormControl(null, Validators.required),
    });
  }

  documentOnChange(event: any) {
    let files: File[] = event.target.files;
    let tmppath = URL.createObjectURL(files[0]);
    this.validations_form.controls['urlFile'].setValue(tmppath);
  }

  onSubmit(values) {
    this.apiService.setUrl(values['urlFile']);
    this.realizarProceso();
  }

  async realizarProceso() {
    //leo los nombres de las colecciones
    //es una promesa. Con await hago que no se ejecute la siguiente sentencia
    //hasta que la promesa se resuelva
    console.log('leo colecciones del fichero');
    await this.apiService.getColecciones()
      .then((nombresColecciones: string[]) => {
        this.nombresColecciones = nombresColecciones;
      })
      .catch((error: string) => {
        console.log(error);
      });

    //al poner await en la sentencia anterior, no continúa la ejecución
    //hasta que la promesa se ha resuelto
    //await convierte un método asíncrono (devuelve una promesa) en síncrono
      
    //para cada colección borro todos sus elementos en firebase
    //con await hago que no se ejecute la siguiente sentencia hasta que no se halla borrado todo
    console.log('borro colecciones en firebase');
    console.log(this.nombresColecciones);
    for (let i = 0; i < this.nombresColecciones.length; i++) {
      //no puedo usar un forEach porque no me dejaría poner await dentro
      //por eso uso un bucle for
      await this.fireService.deleteCollection(this.nombresColecciones[i])
        .then((resultado: boolean) => {
          //el borrado de la colección se ha efectuado por completo
          console.log("borrado correcto de " + this.nombresColecciones[i] + " en firebase");
        })
        .catch((error: string) => {
          console.log(error);
        });
    }//end_for

    //para cada colección leo todos sus datos del fichero
    //tras leerlos recorro cada datos y los inserto en firebase
    for (let i = 0; i < this.nombresColecciones.length; i++) {
      //no puedo usar forEach porque no me dejaría poner await dentro
      //por eso uso un bucle for
      await this.apiService.getDatosColeccion(this.nombresColecciones[i])
        .then((data: any) => {
          this.datosColeccion = data;
        })
        .catch((error: string) => {
          console.log(error);
        });

      //se ha leido por completo la colección
      //recorro la colección e inserto cada dato en firebase
      console.log("insertando datos de " + this.nombresColecciones[i] + " en firebase");
      for (let j = 0; j < this.datosColeccion.length; j++) {
        //hago que se ejecute de forma síncrona
        //hasta que no inserta uno no inserta el siguiente
        await this.fireService.insertarElemento(this.nombresColecciones[i], this.datosColeccion[j])
          .then((element: any) => {
            //inserción correcta
            console.log("insertado elemento " + this.datosColeccion[j]['id']);
          })
          .catch((error: string) => {
            console.log(error);
          });
      }//end_for  para cada elemento dentro de la colección

    }//end_for para cada colección

    console.log("proceso finalizado");

  }//end_class


}//end_class

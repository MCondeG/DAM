import { Component, OnInit } from '@angular/core';
import { AlertController, ModalController, ToastController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/providers/api-service/InterfaceProvider';
import { EditarAlumnoPage } from '../editar-alumno/editar-alumno.page';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  private alumnos = new Array<Alumno>();
  private dataProvider: InterfaceProvider;

  //se inyectan los dos providers para poder cambiar entre firebase y json-server
  constructor(private apiService: ApiServiceProvider,
    public firebaseService: FireServiceProvider,
    public modalController: ModalController,
    public toastController: ToastController) {

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
    this.dataProvider.getAlumnos()
      .then((alumnos: Alumno[]) => {
        this.alumnos = alumnos;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }


  /*
  este método llama al método eliminarAlumno de la Api y le pasa el id del alumno a eliminar. 
  Se devuelve un objeto Promise. Si el borrado ha ido bien se ejecuta el código asociado a la cláusula then. 
  Símplemente se elimina el alumno del array de alumnos de la clase, lo que hará que deje de verse en la vista.
  Si el borrado ha ido mal muestro por consola el error que ha ocurrido.
  */
  eliminarAlumno(indice: number) {
    var urlAvatar = this.alumnos[indice].avatar;
    this.dataProvider.eliminarAlumno(this.alumnos[indice].id)
      .then(() => {
        //los datos del alumno se han eliminado correctamente de cloud firestore
        //elimino la imagen de avatar del storage de firebase
        this.dataProvider.removeImage(urlAvatar);
        this.alumnos.splice(indice, 1);
      })
      .catch((error: string) => {
        this.presentToast("Error al borrar: " + error);
      });

  }//end_eliminar_alumno


  /*
  este método pasa a un activity abierto en modal el objeto alumno que se encuentra en la posición de la lista que se ha pulsado.
  El activity tiene un formulario para modificar los datos. 
  Si los datos son válidos y se pulsa aceptar en el activity se devuelve el objeto alumno con los datos modificados.
  En este caso se actualiza el objeto alumno del array con los nuevos datos.
  Si se pulsa cancelar en el activity se devuelve null.
  */
  async modificarAlumno(indice: number) {
    const modal = await this.modalController.create({
      component: EditarAlumnoPage,
      componentProps: {
        'alumnoJson': JSON.stringify(this.alumnos[indice])
      }
    });

    modal.onDidDismiss().then((dataAlumnoModificado) => {
      let alumnoModificado: Alumno = dataAlumnoModificado['data'];
      if (alumnoModificado != null) {
        this.alumnos[indice] = alumnoModificado;  //si se ha modificado en la api se actualiza en la lista
      }
      else {
        //ha habido un error o se ha pulsado cancelar
        //no se hace nada
      }
    });

    return await modal.present();

  }//end_modificarAlumno

  /*
  este método pasa a un activity abierto en modal objeto alumno recién creado.
  El activity tiene un formulario para editar los datos. 
  Si los datos son válidos y se pulsa aceptar en el activity se devuelve el objeto alumno con los datos nuevos.
  En este caso se añade el nuevo objeto alumno al array.
  Si se pulsa cancelar en el activity se devuelve null.
  */

  async nuevoAlumno() {

    const modal = await this.modalController.create({
      component: EditarAlumnoPage,
      componentProps: {
        'alumnoJson': JSON.stringify(new Alumno())
      }
    });

    modal.onDidDismiss().then((dataNuevoAlumno) => {
      let nuevoAlumno: Alumno = dataNuevoAlumno['data'];
      if (nuevoAlumno != null) {
        this.alumnos.push(nuevoAlumno);  //si se ha insertado en la api se añade en la lista
      }
      else {
        //ha habido un error al insertar o se ha pulsado cancelar
        //no se hace nada
      }
    });
    return await modal.present();
  } //end_nuevoAlumno

  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }

  /*
  este método comentado permite modificar los datos del alumno mediante un alertController
  */
  /*
  async modificarAlumno(indice: number) {
    let alumno = this.alumnos[indice];
    const alert = await this.alertController.create({
      header: 'Modificar',
      inputs: [
        {
          name: 'first_name',
          type: 'text',
          value: alumno.first_name,
          placeholder: 'first_name'
        },
        {
          name: 'last_name',
          type: 'text',
          id: 'last_name',
          value: alumno.last_name,
          placeholder: 'last_name'
        },
        {
          name: 'email',
          id: 'email',
          type: 'text',
          value: alumno.email,
          placeholder: 'email'
        },
        {
          name: 'gender',
          id: 'gender',
          type: 'text',
          value: alumno.gender,
          placeholder: 'gender'
        },
        {
          name: 'avatar',
          value: alumno.avatar,
          type: 'url',
          placeholder: 'avatar'
        },
        {
          name: 'address',
          value: alumno.address,
          type: 'text',
          placeholder: 'address'
        },
        {
          name: 'city',
          value: alumno.city,
          type: 'text',
          placeholder: 'city'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: () => {
            console.log('Confirm Cancel');
          }
        }, {
          text: 'Ok',
          handler: (data) => {
            console.log(data);
            var alumnoModificado: Alumno = new Alumno();
            alumnoModificado.id = alumno.id;
            alumnoModificado.first_name = data['first_name'];
            alumnoModificado.last_name = data['last_name'];
            alumnoModificado.email = data['email'];
            alumnoModificado.gender = data['gender'];
            alumnoModificado.avatar = data['avatar'];
            alumnoModificado.address = data['address'];
            alumnoModificado.city = data['city'];
            this.dataProvider.modificarAlumno(alumnoModificado)
              .then((alumno: Alumno) => {
                this.alumnos[indice] = alumno;
              })
              .catch((error: string) => {
                console.log(error);
              });
            console.log('Confirm Ok');
          }
        }
      ]
    });

    await alert.present();
  }//end_modificarAlumno
  */

}//end_class
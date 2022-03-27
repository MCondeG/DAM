import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/providers/api-service/InterfaceProvider';
import { Alumno } from '../modelo/Alumno';

@Component({
  selector: 'app-editar-alumno',
  templateUrl: './editar-alumno.page.html',
  styleUrls: ['./editar-alumno.page.scss'],
})
export class EditarAlumnoPage implements OnInit {

  @Input() alumnoJson;
  alumno: Alumno;
  validations_form: FormGroup;
  private dataProvider: InterfaceProvider;
  private imageFile: File = null;
  private imageFileName: string = null;
  private lastImageUrl: string = null;

  constructor(public formBuilder: FormBuilder,
    public modalCtrl: ModalController,
    private apiService: ApiServiceProvider,
    public firebaseService: FireServiceProvider) {
    //el atributo dataProvider permite cambiar la gestión de los datos entre firebase y json-server
    this.dataProvider = this.firebaseService;
  }

  ngOnInit() {
    //los datos del alumno llegan como un objeto JSON pasado como cadena
    //hay que parsearlo y transformarlo en un objeto Alumno
    //si el id es null significa que se va a insertar los datos de un nuevo alumno
    //si el id no es null significa que se van a modificar los datos
    this.alumno = Alumno.createFromJsonObject(JSON.parse(this.alumnoJson));
    this.lastImageUrl = this.alumno.avatar;
    this.validations_form = this.formBuilder.group({
      first_name: new FormControl(this.alumno.first_name, Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-z A-ZáéíóúÁÉÍÓÚ]+$'),
        Validators.required
      ])),
      last_name: new FormControl(this.alumno.last_name, Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-z A-ZáéíóúÁÉÍÓÚ]+$'),
        Validators.required
      ])),
      email: new FormControl(this.alumno.email, Validators.compose([
        Validators.pattern('^[a-zA-Z0-9_.+-]+[@]{1}[a-zA-Z0-9-]+[.]{1}[a-zA-Z]+$'),
        Validators.required
      ])),
      address: new FormControl(this.alumno.address, Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-z A-ZáéíóúÁÉÍÓÚ0-9]+$'),
        Validators.required
      ])),
      city: new FormControl(this.alumno.city, Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-z A-ZáéíóúÁÉÍÓÚ]+$'),
        Validators.required
      ])),
      avatar: new FormControl(this.alumno.avatar, Validators.required),
      gender: new FormControl(this.alumno.gender, Validators.compose([
        Validators.required
      ]))
    });
  }

  onSubmit(values) {
    this.alumno.first_name = values['first_name'];
    this.alumno.last_name = values['last_name'];
    this.alumno.email = values['email'];
    this.alumno.address = values['address'];
    this.alumno.city = values['city'];
    this.alumno.avatar = values['avatar'];
    this.alumno.gender = values['gender'];
    if (this.alumno.id != null) { //estoy modificando datos
      this.dataProvider.modificarAlumno(this.alumno)
        .then((alumno: Alumno) => {
          //compruebo si la imagen se ha modificado
          if (this.imageFile != null) {
            //se ha modificado la imagen
            //borro la antigua
            this.dataProvider.removeFile(this.lastImageUrl);
          }
          this.modalCtrl.dismiss(alumno);
        })
        .catch((error: string) => {
          console.log(error);
          this.modalCtrl.dismiss();
        });
    }
    else {  //si el id es null estoy insertando un nuevo alumno
      this.dataProvider.insertarAlumno(this.alumno)
        .then((alumno: Alumno) => {
          this.modalCtrl.dismiss(alumno);
        })
        .catch((error: string) => {
          console.log(error);
          this.modalCtrl.dismiss();
        });
    }
    //los valores son correctos. 
    //Se devuekve un objeto Alumno con los datos del formulario.
    //el id del objeto no se cambia. Si estoy añadiendo nuevos datos es null.
    //si estoy modificando datos es el id que tenía ya el objeto Alumno.
  }

  public closeModal() {
    //si se cancela la edición y estaba insertando un nuevo alumno
    //debo comprobar si se ha añadido imagen
    if (this.alumno.id == null && this.imageFile != null) {
      this.dataProvider.removeFile(this.alumno.avatar);
    }
    this.modalCtrl.dismiss();  //se cancela la edición. No se devuelven datos.
  }


  imageOnChange(event: any) {
    this.imageFile = event.target.files.item(0);
    var extension = this.imageFile.name.substr(this.imageFile.name.lastIndexOf('.') + 1);
    //doy al nombre del fichero un número aleatorio 
    //le pongo al nombre también la extensión del fichero
    this.imageFileName = `${new Date().getTime()}.${extension}`;
    this.validations_form.controls.avatar.setValue("");
    this.dataProvider.uploadImage(this.imageFile, this.imageFileName)
      .then((downloadUrl) => {
        this.alumno.avatar = downloadUrl;
        this.validations_form.controls.avatar.setValue(downloadUrl);
      })
      .catch((error) => {
        console.log(error);
      });
  }


}//end_class

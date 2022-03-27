import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, ValidatorFn, Validators } from '@angular/forms';
import { AlertController, ModalController, ToastController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { FirebaseAuthService } from 'src/providers/api-service/firebase-auth-service';
import { Hotel } from '../modelo/Hotel';
import * as moment from 'moment';
import { Reserva } from '../modelo/Reserva';

@Component({
  selector: 'app-nueva-reserva',
  templateUrl: './nueva-reserva.page.html',
  styleUrls: ['./nueva-reserva.page.scss'],
})
export class NuevaReservaPage implements OnInit {

  @Input() hotelJson;
  hotel: Hotel;
  validations_form: FormGroup;
  email:string=null;

  constructor(public formBuilder: FormBuilder,
    public modalCtrl: ModalController,
    public alertController: AlertController,
    public firebaseService: FireServiceProvider,
    public toastController: ToastController,
    public firebaseAuthService: FirebaseAuthService) {
  }

  ngOnInit() {
    this.hotel = Hotel.createFromJsonObject(JSON.parse(this.hotelJson));
    this.validations_form = this.formBuilder.group({
      fechaEntrada: new FormControl('', Validators.compose([
        this.fechaEntradaValida,
        Validators.required
      ])),
      fechaSalida: new FormControl('', Validators.compose([
        this.fechaSalidaValida,
        Validators.required
      ]))
    },{
      validators: this.validarFormulario
  });
  }

  fechaEntradaValida(fc: FormControl): any {
    let fechaHoraActual: Date = new Date();
    let fechaActual: moment.Moment = moment(fechaHoraActual.getFullYear() + "/" + (fechaHoraActual.getMonth() + 1) + "/" + fechaHoraActual.getDate(), 'YYYY/MM/DD');
    let fechaFormulario: moment.Moment = moment(fc.value, 'YYYY/MM/DD');
    if (fechaActual.toDate().getTime() > fechaFormulario.toDate().getTime()) {  //milisegundos desde 1970
      //la fecha introducida es menor que la actual - la fecha no es válida
      return ({ fechaEntradaValida: true });
    }
    else {
      //la fecha introducida es mayor o igual a la actual - la fecha es válida
      return (null);
    }
  }//end_fechaEntradaValida

  fechaSalidaValida(fc: FormControl): any {
    let fechaHoraActual: Date = new Date();
    let fechaActual: moment.Moment = moment(fechaHoraActual.getFullYear() + "/" + (fechaHoraActual.getMonth() + 1) + "/" + fechaHoraActual.getDate(), 'YYYY/MM/DD');
    let fechaFormulario: moment.Moment = moment(fc.value, 'YYYY/MM/DD');
    if (fechaActual.toDate().getTime() > fechaFormulario.toDate().getTime()) {  //milisegundos desde 1970
      //la fecha introducida es menor que la actual - la fecha no es válida
      return ({ fechaSalidaValida: true });
    }
    else {
      //la fecha introducida es mayor o igual a la actual - la fecha es válida
      return (null);
    }
  }//end_fechaSalidaValida

  validarFormulario(formGroup:FormGroup){
    console.log('validarFormulario');
    let fechaEntrada: moment.Moment = moment(formGroup.controls['fechaEntrada'].value, 'YYYY/MM/DD');
    let fechaSalida: moment.Moment = moment(formGroup.controls['fechaSalida'].value, 'YYYY/MM/DD');

    if (fechaSalida.toDate().getTime() > fechaEntrada.toDate().getTime()) {  //milisegundos desde 1970
      //la fecha de salida es posterior a la de entrada
      //las fechas son válidas
      return (null);
    }
    else {
      //la fecha de salida es menor o igual a la de entrada - las fechas no son válidas
      return ({errorFormulario: true});
    }
  }

  ionViewDidEnter() {
    this.login();
  }

  onSubmit(values) {
    let reserva: Reserva = new Reserva();
    reserva.nombre = this.hotel.nombre;
    reserva.ciudad = this.hotel.ciudad;
    reserva.direccion = this.hotel.direccion;
    reserva.fechaEntrada = values['fechaEntrada'];
    reserva.fechaSalida = values['fechaSalida'];
    reserva.email = this.email;

    this.firebaseService.insertarReserva(reserva)
      .then((reserva: Reserva) => {
        this.closeModal();
      })
      .catch((error: string) => {
        console.log(error);
        this.closeModal();
      });
  }


  async login() {
    const alert = await this.alertController.create({
      header: 'login',
      inputs: [
        {
          name: 'email',
          type: 'text',
          value: null,
          placeholder: 'email'
        },
        {
          name: 'password',
          type: 'text',
          id: 'password',
          value: null,
          placeholder: 'password'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          cssClass: 'secondary',
          handler: () => {
            console.log('Confirm Cancel');
            this.closeModal();
          }
        }, {
          text: 'Ok',
          handler: (data) => {
            console.log(data['email']);
            console.log('Confirm Ok');
            this.firebaseAuthService.loginUser(data['email'], data['password'])
              .then((data) => {
                console.log("login correcto");
                this.email=data['user'].email;
              })
              .catch((error) => {
                console.log("Error en el login: " + error['message']);
                this.closeModal();
              });
          }
        }
      ]
    });
    await alert.present();
  }

  async presentToast(message: string) {
    const toast = await this.toastController.create({
      message: message,
      duration: 2000
    });
    toast.present();
  }

  closeModal() {
    this.firebaseAuthService.logoutUser();
    this.modalCtrl.dismiss();
  }

}//end_class

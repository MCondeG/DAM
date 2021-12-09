import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavigationExtras } from '@angular/router';
import { NavController } from '@ionic/angular';
import * as moment from 'moment';
import { Partido } from '../modelo/Partido';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage implements OnInit {

  formulario: FormGroup;
  equiposGroup: FormGroup;

  equipos: any = [
    {
      "equipo": "Alaves", "jugadores":
        ["Fernando Pacheco", "Antonio Sivera", "Aritz Castro", "Tachi", " Rubén Duarte", "Rodrigo Ely", "Víctor Laguardia"]
    },
    {
      "equipo": "Atletico Madrid", "jugadores":
        ["Ivo Grbic", "Jan Oblak", "Miguel San Román", "José Giménez", " Manuel Sánchez", "Renan Lodi", "Stefan Savic"]
    },
    {
      "equipo": "Cadiz", "jugadores":
        ["Jeremías Ledesma", "David Gil", "Juan Flere", "Sergio González", " Fali", "Marcos Mauro", "Carlos Akapo"]
    }
  ];

  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) { }

  ngOnInit() {
    this.equiposGroup = new FormGroup({
      equipoLocal: new FormControl('', Validators.required),
      equipoVisitante: new FormControl('', Validators.required)
    }, (formGroup: FormGroup) => {
      return this.validEquiposGroup(formGroup);
    });

    this.formulario = new FormGroup({
      fecha: new FormControl('', Validators.compose([
        this.fechaValida,
        Validators.required
      ])),
      equiposGroup: this.equiposGroup,
      golesEquipoLocal: new FormControl('', Validators.compose([
        Validators.min(0),
        Validators.pattern('^[0-9]+$'),
        Validators.required
      ])),
      golesEquipoVisitante: new FormControl('', Validators.compose([
        Validators.min(0),
        Validators.pattern('^[0-9]+$'),
        Validators.required
      ])),
      jugadoresEquipoLocal: new FormControl('', Validators.required),
      jugadoresEquipoVisitante: new FormControl('', Validators.required)
    });

  }//end_ngOnInit

  validEquiposGroup(formGroup: FormGroup) {
    if (formGroup.controls['equipoLocal'].value === formGroup.controls['equipoVisitante'].value)
      //no se permite que el equipo local sea igual al visitante
      return ({ validEquiposGroup: true });
    else
      return (null);
  }

  fechaValida(fc: FormControl): any {
    let fechaHoraActual: Date = new Date();
    let fechaActual: moment.Moment = moment(fechaHoraActual.getFullYear() + "/" + (fechaHoraActual.getMonth() + 1) + "/" + fechaHoraActual.getDate(), 'YYYY/MM/DD');
    let fechaFormulario: moment.Moment = moment(fc.value, 'YYYY/MM/DD');
    if (fechaActual.toDate().getTime() > fechaFormulario.toDate().getTime()) {  //milisegundos desde 1970
      //la fecha introducida es menor que la actual - la fecha no es válida
      return ({ fechaValida: true });
    }
    else {
      //la fecha introducida es mayor o igual a la actual - la fecha es válida
      return (null);
    }
  }//end_fechaValida

  onChangeEquipo(event: any) {
    this.formulario.controls['golesEquipoLocal'].setValue('');
    this.formulario.controls['golesEquipoVisitante'].setValue('');
    this.formulario.controls['jugadoresEquipoLocal'].setValue('');
    this.formulario.controls['jugadoresEquipoVisitante'].setValue('');
  }

  onSubmit(valores: any) {
    console.log(valores);
    let partido = new Partido(valores.equiposGroup.equipoLocal.equipo,
      valores.equiposGroup.equipoVisitante.equipo,
      valores.fecha, valores.golesEquipoLocal,
      valores.golesEquipoVisitante,
      valores.jugadoresEquipoLocal,
      valores.jugadoresEquipoVisitante);
    console.log(partido);
    let navigationExtras: NavigationExtras = {
      queryParams: {
        partido: JSON.stringify(partido),
      }
    };
    this.navCtrl.navigateForward('/pagina2', navigationExtras);
  }

} //end_class

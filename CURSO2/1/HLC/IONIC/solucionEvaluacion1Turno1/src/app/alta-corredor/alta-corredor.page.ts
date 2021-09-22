import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { NavController } from '@ionic/angular';
import { Corredor } from '../modelo/Corredor';

@Component({
  selector: 'app-alta-corredor',
  templateUrl: './alta-corredor.page.html',
  styleUrls: ['./alta-corredor.page.scss'],
})
export class AltaCorredorPage implements OnInit {

  formulario: FormGroup;
  grupo: FormGroup;

  constructor(public formBuilder: FormBuilder,
    private navCtrl: NavController) { }

  ngOnInit() {
    this.grupo = new FormGroup({
      dniCorredor: new FormControl('', Validators.compose([
        this.validDNIcorredor,
        Validators.required,
        Validators.maxLength(9),
        Validators.pattern('^([0-9]{8,8}[A-Za-z])?$')
      ])),
      edad: new FormControl('', Validators.compose([
        this.validEdad,
        Validators.required,
        Validators.pattern('^[0-9]+$')
      ]))
      ,
      federado: new FormControl(false),
      equipo: new FormControl('', Validators.compose([
        Validators.maxLength(30),
        Validators.pattern('^[0-9A-Za-z]+$')
      ])),
      telefonoTutorLegal: new FormControl('', Validators.compose([
        Validators.maxLength(10),
        Validators.pattern('^[0-9]{10}$')
      ]))
    }, (formGroup: FormGroup) => {
      return this.validarGrupo(formGroup);
    });
  
    this.formulario = this.formBuilder.group({
      grupo: this.grupo
    });
  }

  validarGrupo(fg: FormGroup){
    if(!fg.controls['edad'].valid)
        return({validarGrupo:true});  //no se valida
    if(!fg.controls['dniCorredor'].valid)
        return({validarGrupo:true});  //no se valida
    var edad=fg.controls['edad'].value;
    var federado=fg.controls['federado'].value;   
    var equipo=fg.controls['equipo'].value;
    var telefonoTutorLegal=fg.controls['telefonoTutorLegal'].value;
    if(federado && equipo=='')
      return({validarGrupo:true});  //no se valida
    
    if(!federado && edad<18 && telefonoTutorLegal=='')
      return({validarGrupo:true});  //no se valida

    return null;  //se valida
  }

  validDNIcorredor(fc: FormControl) {
    if(fc.value===''){
      return null;  //se valida
    }
    var letras = "TRWAGMYFPDXBNJZSQVHLCKE";
    var numeros = fc.value.substring(0, fc.value.length - 1);
    var numero = numeros % 23;
    var letraCorr = letras.charAt(numero);
    var letra = fc.value.substring(8, 9).toUpperCase();
    if (letraCorr != letra) {
      return ({ validDNIcorredor: true });  //no se valida
    } else {
      return (null);  //se valida
    }
  }

  validEdad(fc: FormControl) {
    var edad=fc.value;
    if(edad=='')
      return ({validEdad: true});  //no se valida
    if(edad<=12)
      return ({validEdad: true});  //no se valida
    else
      return (null);  //se valida porque tiene 12 años o más
  }

  onChangeFederado($event){
    this.formulario.get('grupo').get('equipo').setValue('');
    this.formulario.get('grupo').get('telefonoTutorLegal').setValue('');
  }

  onChangeEdad($event){
    this.formulario.get('grupo').get('equipo').setValue('');
    this.formulario.get('grupo').get('telefonoTutorLegal').setValue('');
  }

  onSubmit(values){
    var corredor=new Corredor(values['grupo']['dniCorredor'],
                              values['grupo']['federado'],
                              values['grupo']['edad'],
                              values['grupo']['equipo'],
                              values['grupo']['telefonoTutorLegal']);
    console.log(corredor);
    this.navCtrl.navigateRoot('/home');   
  }

}

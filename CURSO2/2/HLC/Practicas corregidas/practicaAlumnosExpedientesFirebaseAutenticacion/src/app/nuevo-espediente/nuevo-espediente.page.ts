import { Component, Input, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ModalController } from '@ionic/angular';
import { FireServiceProvider } from 'src/providers/api-service/fire-service';
import { InterfaceProvider } from 'src/providers/api-service/InterfaceProvider';
import { Alumno } from '../modelo/Alumno';
import { Expediente } from '../modelo/Expediente';

@Component({
  selector: 'app-nuevo-espediente',
  templateUrl: './nuevo-espediente.page.html',
  styleUrls: ['./nuevo-espediente.page.scss'],
})
export class NuevoEspedientePage implements OnInit {

  @Input() alumnoJson;
  alumno: Alumno;
  expediente: Expediente=new Expediente();
  validations_form: FormGroup;
  private dataProvider: InterfaceProvider;
  private pdfFile: File = null;
  private pdfFileName: string = null;
  private pdfFileUrl:string=null;

  constructor(public modalCtrl: ModalController,
    public formBuilder: FormBuilder,
    public firebaseService: FireServiceProvider) {
    this.dataProvider = this.firebaseService;
  }

  ngOnInit() {
    this.alumno = Alumno.createFromJsonObject(JSON.parse(this.alumnoJson));
    this.validations_form = this.formBuilder.group({
      descripcion: new FormControl(this.expediente.descripcion, Validators.compose([
        Validators.maxLength(50),
        Validators.minLength(1),
        Validators.pattern('^[a-z A-ZáéíóúÁÉÍÓÚ]+$'),
        Validators.required
      ])),
      urlFile: new FormControl(this.expediente.urlFile, Validators.required),
    });
  }

  public closeModal() {
    this.modalCtrl.dismiss();  //se cancela la edición. No se devuelven datos.
  }

  documentOnChange(event: FileList) {
    this.pdfFile = event.item(0);
    var extension = this.pdfFile.name.substr(this.pdfFile.name.lastIndexOf('.') + 1);
    //doy al nombre del fichero un número aleatorio 
    //le pongo al nombre también la extensión del fichero
    this.pdfFileName = `${new Date().getTime()}.${extension}`;
    this.validations_form.controls.urlFile.setValue("");
    this.dataProvider.uploadPdfDocument(this.pdfFile, this.pdfFileName)
      .then((downloadUrl) => {
        this.validations_form.controls.urlFile.setValue(downloadUrl);
      })
      .catch((error) => {
        console.log(error);
      });
  }

  onSubmit(values) {
    this.expediente.descripcion=values['descripcion'];
    this.expediente.urlFile=values['urlFile'];
    this.alumno.expedientes.push(this.expediente);
    this.dataProvider.modificarAlumno(this.alumno)
      .then((alumno: Alumno) => {
        this.modalCtrl.dismiss(alumno);
      })
      .catch((error: string) => {
        console.log(error);
        this.modalCtrl.dismiss();
      });
  }//end_onSubmit

}//end_class

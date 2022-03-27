import { Injectable } from '@angular/core';
import { Alumno } from 'src/app/modelo/Alumno';
import { InterfaceProvider } from './InterfaceProvider';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { AngularFireStorage } from '@angular/fire/compat/storage';

@Injectable()
export class FireServiceProvider implements InterfaceProvider {

    constructor(private angularFirestore: AngularFirestore,
        private afStorage: AngularFireStorage) {
    }

    uploadImage(file: File, name: string): Promise<string> {
        var promise: Promise<string> = new Promise<string>((resolve, reject) => {
            //Se comprueba que el tipo del fichero pertenece a un tipo imagen
            if (file.type.split('/')[0] !== 'image') {
                console.log('File type is not supported!')
                reject("El fichero no es de tipo imagen");
            }
            //se calcula el path dentro del storage de firebase
            //se guarda dentro de una carpeta avatar
            //el nombre del fichero es igual al id del alumno precedido de la hora dada por getTime 
            const fileStoragePath = `avatar/${name}`;

            // Image reference
            const imageRef = this.afStorage.ref(fileStoragePath);

            // File upload task
            this.afStorage.upload(fileStoragePath, file)
                .then((data) => {
                    imageRef.getDownloadURL().subscribe(resp => {
                        resolve(resp);
                    });
                })
                .catch((error) => {
                    reject(error);
                });
        });
        return (promise);
    }//end_uploadImage


    removeImage(imageUrl:string):Promise<string> {

        var promise:Promise<string> = new Promise<string>( (resolve, reject)=>{
      
          var imageRef = this.afStorage.refFromURL(imageUrl);
      
          imageRef.delete().subscribe(resp=>{
      
            resolve;
      
          },
      
          error => {
      
            reject(error);
      
          });
      
        });
      
        return(promise);  
      
      }//end_uploadImage

    /*
    este método devuelve un objeto 'Promise'. Esto es un elemento asíncrono que puede finalizar de dos formas: correctamente, en cuyo caso sale con resolve, o bien de forma incorrecta, acabando en ese caso con reject.
    El método llama al método get de alumno. .......sR, pasándole como parámetro la url que devuelve la colección alumnos de la Api. Lo que devuelve este método lo convertimos a Promise, para luego evaluar su resultado mediante then y catch.
    Si el acceso a la Api ha ido bien el código que se ejecuta es el ubicado en la cláusula then. Si ha ido mal se ejecuta el código ubicado en la cláusula catch. 
    Si todo ha ido bien convertimos el array de objetos Json que nos llega a un array de objetos alumnos, y lo devolvemos con resolve.
    Si el acceso ha ido mal devolvemos el mensaje de error que no llega mediante reject.
    */

    getAlumnos(): Promise<Alumno[]> {
        let promise = new Promise<Alumno[]>((resolve, reject) => {
            const alumnosRef = this.angularFirestore.collection('alumnos');
            const snapshot = alumnosRef.get().toPromise()
                .then((data: any) => {
                    let alumnos = new Array<Alumno>();
                    data.forEach(element => {
                        let alumnoJson = element.data();
                        let alumno = Alumno.createFromJsonObject(alumnoJson);
                        alumnos.push(alumno);
                    });
                    resolve(alumnos);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }

    /*
    este método manda una solicitud de borrado a la Api del usuario con un id determinado.
    Si el borrado va bien se sale son resolve devolviendo true.
    Si el borrado va mal se sale con reject, devolviendo el mensaje de error que nos llega
    */

    eliminarAlumno(id: any): Promise<Boolean> {
        let promise = new Promise<Boolean>((resolve, reject) => {
            this.angularFirestore.collection('alumnos').doc(id).delete().then(
                (data: any) => { // Success
                    console.log(data)
                    resolve(true);
                }
            )
                .catch((error: Error) => {
                    console.log(error.message);
                    reject(error.message);
                });
        });
        return promise;
    }//end_eliminar_alumno

    modificarAlumno(nuevosDatosAlumno: Alumno): Promise<Alumno> {
        let promise = new Promise<Alumno>((resolve, reject) => {
            console.log(nuevosDatosAlumno.id);
            this.angularFirestore.collection("alumnos").doc(nuevosDatosAlumno.id).update(JSON.parse(JSON.stringify(nuevosDatosAlumno)))
                .then(() => {
                    resolve(nuevosDatosAlumno);
                })
                .catch((error: Error) => {
                    console.log("ERROR: " + error.message);
                    reject(error.message);
                });
        });
        return promise;
    }//end_modificar_alumno

    insertarAlumno(datosNuevoAlumno: Alumno): Promise<Alumno> {
        let promise = new Promise<Alumno>((resolve, reject) => {
            datosNuevoAlumno.id = this.angularFirestore.collection("alumnos").ref.doc().id;
            this.angularFirestore.collection("alumnos").doc(datosNuevoAlumno.id).set(JSON.parse(JSON.stringify(datosNuevoAlumno)))
                .then(() => {
                    resolve(datosNuevoAlumno);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_insertarAlumno

}//end_class
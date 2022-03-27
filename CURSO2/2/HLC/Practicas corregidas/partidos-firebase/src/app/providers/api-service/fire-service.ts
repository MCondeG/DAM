import { Injectable } from '@angular/core';
import { InterfaceProvider } from './InterfaceProvider';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Partido } from 'src/app/modelo/Partido';


@Injectable()
export class FireServiceProvider implements InterfaceProvider {


    constructor(private angularFirestore: AngularFirestore) {
    }

    /*
    este método devuelve un observable que deberá ser gestionado por el controlador.
    cuando halla algún cambio en los datos de los partidos en firebase,
    firebase mandará de nuevo los datos de todos los partidos.
    como el controlador estará subscrito al observable, saltará el código que se halla puesto.
    Este código actualizará de nuevo el array de partidos, que se actualizará en la vista
    */
    getPartidos(): any {
        return (this.angularFirestore.collection('partidos').snapshotChanges());
    }


    modificarPartido(nuevosDatosPartido: Partido): Promise<Partido> {   
        let promise = new Promise<Partido>((resolve, reject) => {
            this.angularFirestore.collection("partidos").doc(nuevosDatosPartido.id).update(JSON.parse(JSON.stringify(nuevosDatosPartido)))
                .then(() => {
                    resolve(nuevosDatosPartido);
                })
                .catch((error: Error) => {
                    console.log("ERROR: "+error.message);
                    reject(error.message);
                });
        });
        return promise;
    }//end_modificar_partido

    insertarPartido(datosNuevoPartido: Partido): Promise<Partido> {
        let promise = new Promise<Partido>((resolve, reject) => {
            datosNuevoPartido.id = this.angularFirestore.collection("partidos").ref.doc().id;
            this.angularFirestore.collection("partidos").doc(datosNuevoPartido.id).set(JSON.parse(JSON.stringify(datosNuevoPartido)))
                .then(() => {
                    resolve(datosNuevoPartido);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_insertarPartido

}//end_class
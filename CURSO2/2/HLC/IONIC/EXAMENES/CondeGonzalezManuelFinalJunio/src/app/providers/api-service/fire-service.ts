import { Injectable } from '@angular/core';
import { InterfaceProvider } from './InterfaceProvider';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Partido } from 'src/app/modelo/Partido';


@Injectable()
export class FireServiceProvider implements InterfaceProvider {


    constructor(private angularFirestore: AngularFirestore) {
    }


    getPartidos(): any {
        return (this.angularFirestore.collection('partidos').snapshotChanges());
    }

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
    }

    borrarPartido(idPartido: string) {
        this.angularFirestore.collection("partidos").doc(idPartido).delete();
    }
}
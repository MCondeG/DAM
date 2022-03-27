import { Injectable } from '@angular/core';
import { AngularFirestore, Query, QuerySnapshot } from '@angular/fire/compat/firestore';
import { AngularFireStorage } from '@angular/fire/compat/storage';
import { Reserva } from 'src/app/modelo/Reserva';

@Injectable()
export class FireServiceProvider {

    constructor(private angularFirestore: AngularFirestore,
        private afStorage: AngularFireStorage) {
    }

    getReservas(fecha:string): Promise<Reserva[]> {
        let promise = new Promise<Reserva[]>((resolve, reject) => {
            console.log(fecha);
            let reservasRef:Query = this.angularFirestore.collection('reservas').ref.where('fechaEntrada','>=',fecha);
            reservasRef.get()
                .then((data: QuerySnapshot<any>) => {
                    let reservas = new Array<Reserva>();
                    data.forEach(element => {
                        let reservaJson = element.data();
                        let reserva = Reserva.createFromJsonObject(reservaJson);
                        reservas.push(reserva);
                    });
                    resolve(reservas);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getReservas

    insertarReserva(reserva: Reserva): Promise<Reserva> {
        let promise = new Promise<Reserva>((resolve, reject) => {
            reserva.id = this.angularFirestore.collection("reservas").ref.doc().id;
            this.angularFirestore.collection("reservas").doc(reserva.id).set(JSON.parse(JSON.stringify(reserva)))
                .then(() => {
                    resolve(reserva);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_insertarReserva

}//end_class
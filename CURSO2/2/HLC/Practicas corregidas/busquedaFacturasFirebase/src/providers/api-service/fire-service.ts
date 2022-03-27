import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { Factura } from 'src/app/modelo/Factura';

@Injectable()
export class FireServiceProvider  {

    constructor(private angularFirestore: AngularFirestore) {
    }

    getFacturas(): Promise<Factura[]> {
        let promise = new Promise<Factura[]>((resolve, reject) => {
            const facturasRef = this.angularFirestore.collection('facturas').ref;
            facturasRef.get()
                .then((data: any) => {
                    let facturas = new Array<Factura>();
                    data.forEach(element => {
                        let facturaJson = element.data();
                        let factura = Factura.createFromJsonObject(facturaJson);
                        facturas.push(factura);
                    });
                    resolve(facturas);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getFacturas

    getFacturasPorCliente(cliente: string): Promise<Factura[]> {
        let promise = new Promise<Factura[]>((resolve, reject) => {
            const facturasRef = this.angularFirestore.collection('facturas').ref;
            facturasRef.where('cliente', '==', cliente).get()
                .then((data: any) => {
                    let facturas = new Array<Factura>();
                    data.forEach(element => {
                        let facturaJson = element.data();
                        let factura = Factura.createFromJsonObject(facturaJson);
                        facturas.push(factura);
                    });
                    resolve(facturas);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getFacturasPorCliente

}//end_class
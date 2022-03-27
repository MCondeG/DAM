import { Injectable } from '@angular/core';
import { AngularFirestore, Query, QueryDocumentSnapshot, QuerySnapshot } from '@angular/fire/compat/firestore';
import { Factura } from 'src/app/modelo/Factura';

@Injectable()
export class FireServiceProvider {

    private snapshotActual: QuerySnapshot<any>;
    private ref: Query;
    //se declaran static para poder acceder a las constantes a través del nombre de la clase
    public static INICIO:number=1;
    public static SIGUIENTE:number=2;
    public static ANTERIOR:number=3;
    public static ULTIMO:number=4;

    constructor(private angularFirestore: AngularFirestore) {
    }

    async getFacturas(numElementosPorPagina: number, accion: number): Promise<Factura[]> {
        //en primer lugar monto la query a realizar dependiendo de la acción solicitada
        switch (accion) {
            case FireServiceProvider.INICIO:
                this.ref = this.angularFirestore.collection('facturas').ref
                    .orderBy('cliente').limit(numElementosPorPagina);
                break;
            case FireServiceProvider.SIGUIENTE:
                let lastDocumentInPage: QueryDocumentSnapshot<any>;
                lastDocumentInPage = this.snapshotActual.docs[this.snapshotActual.docs.length - 1];
                this.ref = this.angularFirestore.collection('facturas').ref
                    .orderBy('cliente').startAfter(lastDocumentInPage.data().cliente).limit(numElementosPorPagina);
                break;
            case FireServiceProvider.ANTERIOR:
                let firstDocumentInPage: QueryDocumentSnapshot<any>;
                firstDocumentInPage = this.snapshotActual.docs[0];
                this.ref = this.angularFirestore.collection('facturas').ref
                    .orderBy('cliente').endBefore(firstDocumentInPage.data().cliente).limitToLast(numElementosPorPagina);
                break;
            case FireServiceProvider.ULTIMO:
                //para obtener los últimos elementos debo hacer un 'truco'
                //obtengo la primera factura ordenadas descendentemente por cliente
                //una vez tengo este documento, solicito los X documentos anteriores a este incluyendo esa factura
                //en este caso los solicito ya ordenados por cliente de forma ascendente
                let lastDocument: QueryDocumentSnapshot<any>;
                this.ref = this.angularFirestore.collection('facturas').ref
                    .orderBy('cliente','desc').limit(1);
                //debo llamarlo con await para que no siga la ejecución hasta que no obtenga la última factura
                //y monte la query que me da los últimos documentos
                await this.ref.get()
                    .then((data) => {
                        lastDocument = data.docs[0];
                        this.ref = this.angularFirestore.collection('facturas').ref
                            .orderBy('cliente').endAt(lastDocument.data().cliente).limitToLast(numElementosPorPagina);
                    })
                    .catch((error) => {
                        console.log(error);
                    })
                break;
        }
        //una vez montada la query a realizar me traigo los datos
        //y los devuelvo en un promise transformados en array de objetos Factura
        let promise = new Promise<Factura[]>((resolve, reject) => {
            this.ref.get()
                .then((data: QuerySnapshot<any>) => {
                    if (data.empty) {
                        //se pulsa anterior estando en la primera página
                        //o se pulsa siguiente estando en la última página
                        reject("Fuera de límites");
                        //si no pongo return se ejecuta el código posterior
                        return;
                    }
                    //este atributo snapshot es una especie de 'cursor'
                    //me permite moverme adelante o atrás a partir de los documentos que contiene
                    this.snapshotActual = data;
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

}//end_class
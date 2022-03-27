import { Injectable } from '@angular/core';
import { AngularFirestore } from '@angular/fire/compat/firestore';
import { AngularFireStorage } from '@angular/fire/compat/storage';

@Injectable()
export class FireServiceProvider {

  constructor(private angularFirestore: AngularFirestore,
    private afStorage: AngularFireStorage) {
  }


  insertarElemento(coleccion: string, dato: any): Promise<any> {
    let promise = new Promise<any>((resolve, reject) => {
      let elemento=Object.assign({}, dato);  //hago copia del objeto, pues se pasa por referencia
      elemento['id'] = this.angularFirestore.collection(coleccion).ref.doc().id;
      this.angularFirestore.collection(coleccion).doc(elemento['id']).set(elemento)
        .then(() => {
          resolve(elemento);
        })
        .catch((error: Error) => {
          reject(error.message);
        });
    });
    return promise;
  }//end_insertarAlumno

  deleteCollection(coleccion:string): Promise<boolean> {
    let promise = new Promise<boolean>((resolve, reject) => {
      let ref=this.angularFirestore.collection(coleccion);
      ref.get().toPromise()
        .then((data: any) => {
          data.docs.forEach((doc: any) => {
            ref.doc(doc.id).delete()
              .catch((error:Error) => {
                console.log(error)
                reject(error.message);
              })
          });
          resolve(true);
        })
        .catch((error: Error) => {
          reject(error.message);
        });
    });
    return promise;
  }

}//end_class
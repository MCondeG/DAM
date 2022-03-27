import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class ApiServiceProvider  {

    private url:string = null;

    constructor(public http: HttpClient) {
    }

    setUrl(url){
        this.url=url;
    }
    
    //devuelve un array con todos los elementos existentes 
    //en una colección determinada del fichero con formato JSON
    getDatosColeccion(coleccion:string): Promise<any[]> {
        let promise = new Promise<any[]>((resolve, reject) => {
            //this.http.get('../../assets/datos/facturas.json').toPromise()
            this.http.get(this.url).toPromise()
                .then((data: any) => {
                    resolve(data[coleccion]);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//endGetDatosColecciones

    //devuelve un array de string con los nombres de todas las colecciones
    //existentes en el fichero con formato JSON.
    //para que funcione el fichero debe contener un objeto JSON con un campo para cada colección
    getColecciones():Promise<string[]>{
        let promise = new Promise<string[]>((resolve, reject) => {
            this.http.get(this.url).toPromise()
                .then((data: any) => {
                    let nombresColecciones:string[]=new Array();
                    for(let key in data){
                        nombresColecciones.push(key);
                    }
                    resolve(nombresColecciones);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getColecciones


}//end_class
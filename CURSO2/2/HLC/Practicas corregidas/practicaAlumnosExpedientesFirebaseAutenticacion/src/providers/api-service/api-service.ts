import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Alumno } from 'src/app/modelo/Alumno';
import { InterfaceProvider } from './InterfaceProvider';

@Injectable()
export class ApiServiceProvider  implements InterfaceProvider {

    private URL = "http://localhost:3000";

    constructor(public http: HttpClient) {
    }
    uploadPdfDocument(file: File, name: string): Promise<string> {
        throw new Error('Method not implemented.');
    }
    uploadImage(file: File, name: string): Promise<string> {
        throw new Error('Method not implemented.');
    }
    
    removeFile(urlFile: string): Promise<string> {
        throw new Error('Method not implemented.');
    }

    /*
    este método devuelve un objeto 'Promise'. Esto es un elemento asíncrono que puede finalizar de dos formas: correctamente, en cuyo caso sale con resolve, o bien de forma incorrecta, acabando en ese caso con reject.
    El método llama al método get del atributo http, pasándole como parámetro la url que devuelve la colección alumnos de la Api. Lo que devuelve este método lo convertimos a Promise, para luego evaluar su resultado mediante then y catch.
    Si el acceso a la Api ha ido bien el código que se ejecuta es el ubicado en la cláusula then. Si ha ido mal se ejecuta el código ubicado en la cláusula catch.
    Si todo ha ido bien convertimos el array de objetos Json que nos llega a un array de objetos alumnos, y lo devolvemos con resolve.
    Si el acceso ha ido mal devolvemos el mensaje de error que no llega mediante reject.
    */
    getAlumnos(): Promise<Alumno[]> {
        let promise = new Promise<Alumno[]>((resolve, reject) => {
            this.http.get(this.URL + "/alumnos").toPromise()
                .then((data: any) => {
                    let alumnos = new Array<Alumno>();
                    data.forEach(alumnoJson => {
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
    eliminarAlumno(alumno: Alumno): Promise<Boolean> {
        let promise = new Promise<Boolean>((resolve, reject) => {
            this.http.delete(this.URL + "/alumnos/" + alumno.id).toPromise().then(
                (data: any) => { // Success
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
            var header = { "headers": { "Content-Type": "application/json" } };
            let datos = JSON.stringify(nuevosDatosAlumno);
            this.http.put(this.URL + "/alumnos/" + nuevosDatosAlumno.id,
                datos,
                header).toPromise().then(
                    (data: any) => { // Success
                        let alumno: Alumno;
                        alumno = Alumno.createFromJsonObject(data);
                        resolve(alumno);
                    }
                )
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_modificar_alumno

    insertarAlumno(datosNuevoAlumno: Alumno): Promise<Alumno> {
        let promise = new Promise<Alumno>((resolve, reject) => {
            var header = { "headers": { "Content-Type": "application/json" } };
            delete datosNuevoAlumno.id; //cuando se hace un post no paso el id. El id es asignado por el servidor. Quito el atributo del objeto json
            let datos = JSON.stringify(datosNuevoAlumno);
            this.http.post(this.URL + "/alumnos/",
               datos,
                header).toPromise().then(
                    (data: any) => { // Success
                        let alumno: Alumno;
                        alumno = Alumno.createFromJsonObject(data);
                        resolve(alumno);
                    }
                )
                .catch((error: Error) => {
                   reject(error.message);
                });
        });
        return promise;
    }//end_insertarAlumno

}//end_class
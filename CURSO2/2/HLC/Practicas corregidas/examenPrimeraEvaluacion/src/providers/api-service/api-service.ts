import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Usuario } from 'src/app/modelo/Usuario';

@Injectable()
export class ApiServiceProvider {
    
    private URL="http://localhost:3000";

    constructor(public http: HttpClient){
    }

    getUsuarios():Promise<Usuario[]> {
        let promise = new Promise<Usuario[]>((resolve, reject) => {
            this.http.get(this.URL+"/usuarios").toPromise()
                .then((data:any)=>{
                    let usuarios=new Array<Usuario>();
                    data.forEach(usuarioJson => {
                        let usuario=Usuario.createFromJsonObject(usuarioJson);
                        usuarios.push(usuario);
                    });
                    resolve(usuarios);
                })
                .catch( (error:Error)=>{
                    reject(error.message);
                });
        });
        return promise;
    }
    
}//end_class
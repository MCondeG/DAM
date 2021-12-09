import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Md5 } from 'md5-typescript';
import { emitDistinctChangesOnlyDefaultValue } from '@angular/compiler/src/core';
import { Resultado } from './InterfaceGetComics';
import { Comic } from 'src/app/modelo/Comic';

@Injectable()
export class ApiServiceProvider {
    
    private BASEURL="https://gateway.marvel.com:443/v1/public/comics";

    constructor(public http: HttpClient){
    }
//limit:number,offset:number
    getComics():Promise<Comic[]> {
        //Key privada
        let private_key="65e9705d72d955431763cc7b7beee8bf00a59d88";
        //Key pública
        let public_key="1cf193263e6d2aeb7b600ec8e51939d5";

        //Fecha
        let ts = new Date().getTime();

        //Encriptador
        let hash=Md5.init(ts+private_key+public_key);

        //url hecha
        let url=this.BASEURL+"?orderBy=title"+
        // "&limit="+limit+
        //  "&offset="+offset+
        "&ts="+ts+
        "&apikey="+public_key+
        "&hash="+hash;

        //GET
        let promise = new Promise<any>((resolve, reject) => {
            //Petición por la url
            this.http.get(url).toPromise()
                //Especificar que devuelve
                .then((data:Resultado)=>{
                    let comics:Comic[]=[];
                    
                    //For each para montar el objeto
                    data.data.results.forEach(element => {
                        let comic= new Comic();
                        comic.title=element.title;
                        comic.thumbnail=element.thumbnail.path+"/portrait_medium.jpg";
                        comics.push(comic);
                    });
                    //Devuelve los comics
                    resolve(comics);
                })
                //ERROR
                .catch( (error:Error)=>{
                    reject(error.message);
                });
                

        });
        return promise;
    }
       
    



   
    
}//end_class
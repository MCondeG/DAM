import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Md5} from "md5-typescript";
import { Comic } from 'src/app/modelo/Comic';
import { Character } from 'src/app/modelo/Character';
import { ResultadoGetCharacters, ResultadoGetComics, ResultsGetCharacters, ResultsGetComics } from './interfacesApiService';

@Injectable()
export class ApiServiceProvider {
    
    private BASE_URL="http://gateway.marvel.com/v1/public";

    constructor(public http: HttpClient){
    }

    getComics(characterId:number):Promise<Comic[]> {
        let promise = new Promise<any>((resolve, reject) => {
            let url:string;
            let ts=new Date().getTime();
            let apikey="f9434f3d1fbfb4771b4a5e7a9b86ac3b";
            let privatekey="bc4b0df09bd2729a11d6c2dca247f8766e8d24c4";
            let hash=Md5.init(ts+privatekey+apikey);
            url=this.BASE_URL+"/characters/"+characterId+"/comics"+
            "?ts="+ts+
            "&apikey="+apikey+
            "&hash="+hash;
            this.http.get(url).toPromise()
                .then((data:ResultadoGetComics)=>{
                    let comics:Comic[]=[];
                    data.data.results.forEach((element:ResultsGetComics) => {
                        let comic=new Comic();
                        comic.title=element.title;
                        comic.thumbnail=element.thumbnail.path+"/standard_small."+element.thumbnail.extension;
                        comic.imageLandscapeMedium=element.thumbnail.path+"/landscape_small."+element.thumbnail.extension;
                        comic.description=element.description;
                        element.images.forEach(image => {
                            comic.images.push(image.path+"."+image.extension);
                        });
                        comics.push(comic);
                    });
                    resolve(comics);
                })
                .catch( (error:Error)=>{
                    reject(error.message);
                });
        });
        return promise;
    }//end_getComics

    getCharacters(limit:number, offset:number, characterName:string):Promise<any> {
        let promise = new Promise<any>((resolve, reject) => {
            let url:string;
            let ts=new Date().getTime();
            let apikey="f9434f3d1fbfb4771b4a5e7a9b86ac3b";
            let privatekey="bc4b0df09bd2729a11d6c2dca247f8766e8d24c4";
            let hash=Md5.init(ts+privatekey+apikey);
            url=this.BASE_URL+"/characters"+
            "?ts="+ts+
            "&apikey="+apikey+
            "&hash="+hash+
            "&limit="+limit+
            "&offset="+offset;
            if(characterName){
                url=url+"&nameStartsWith="+characterName.trim();
            }
            this.http.get(url).toPromise()
                .then((data:ResultadoGetCharacters)=>{
                    let characters:Character[]=[];
                    data.data.results.forEach((element:ResultsGetCharacters)=> {
                        let character=new Character();
                        character.id=element.id;
                        character.name=element.name;
                        character.description=element.description;
                        character.thumbnail=element.thumbnail.path+"/standard_small."+element.thumbnail.extension;
                        characters.push(character);
                    });
                    resolve({'characters':characters,
                             'total':data.data.total,
                             'offset':data.data.offset});
                })
                .catch( (error:Error)=>{
                    reject(error.message);
                });
        });
        return promise;
    }//end_getCharacters
    
}//end_class
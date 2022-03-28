import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Pelicula } from 'src/app/modelo/Pelicula';

@Injectable()
export class ApiServiceProvider {
    
    private BASE_URL = "http://api.themoviedb.org/3/search/movie?query=";
    private apikey = "&api_key=5fbddf6b517048e25bc3ac1bbeafb919";
    private URL: string;

    constructor(public http: HttpClient){
    }


    getMovies(movieName: string): Promise<Pelicula> {

        let promise = new Promise<Pelicula>((resolve, reject) => {
            this.URL = this.BASE_URL + encodeURI(movieName) + this.apikey;
            if(characterName) {
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

    }
    
}
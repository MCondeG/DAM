import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Configuration } from 'src/modelo/configuration';
import { Movie } from 'src/modelo/movie';


/*
  Generated class for the MovieProvider provider.

  See https://angular.io/guide/dependency-injection for more info on providers
  and Angular DI.
*/
@Injectable()
export class ApiServiceProvider {

  configuration: Configuration;

  constructor(public http: HttpClient) {
  }

  getMovies(movieName: string):Promise<Movie[]>{
    let promise=new Promise<Movie[]>( (resolve,reject)=>{
      this.getConfiguration()
        .then((configuration:any)=>{
            this.configuration=configuration;
            var url = 'http://api.themoviedb.org/3/search/movie?query=' + encodeURI(movieName) + '&api_key=5fbddf6b517048e25bc3ac1bbeafb919';
            this.http.get(url).toPromise()
              .then((data:any)=>{
                let movies: Movie[]=new Array<Movie>();
                let datos=data['results'];
                for(let dato of datos){
                  let movie=new Movie(dato['vote_count'],
                                      dato['id'],
                                      dato['video'],
                                      dato['vote_average'],
                                      dato['title'],
                                      dato['popularity'],
                                      dato['poster_path'],
                                      dato['backdrop_path'],
                                      dato['adult'],
                                      dato['overview'],
                                      dato['release_date']);

                  if(movie.poster_path!=null){
                      movie.poster_path=this.configuration.secure_base_url+'w92'+movie.poster_path;
                  }
                  movies.push(movie);
                }
                resolve(movies);
              })
              .catch((error:Error)=>{

              })
        })
        .catch((error:string)=>{
            reject(error);
        });    
    });
    return promise;
  }
  
  getConfiguration():Promise<any>{
    var url = 'http://api.themoviedb.org/3/configuration?api_key=5fbddf6b517048e25bc3ac1bbeafb919';
    let promise=new Promise<any>((resolve,reject)=>{
      this.http.get(url).toPromise()
        .then((data:any)=>{
          resolve(data['images']);
          })
        .catch((error:Error)=>{
          reject(error.message);
        })
    });
  return(promise);
  }

}

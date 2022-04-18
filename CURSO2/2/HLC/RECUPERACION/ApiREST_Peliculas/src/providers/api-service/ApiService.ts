import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movie } from 'src/modelo/Movie';

@Injectable()
export class ApiService {

    private BASE_URL = "http://api.themoviedb.org/3/search/movie?query=";
    private API_key = "&api_key=5fbddf6b517048e25bc3ac1bbeafb919";
    private URL: string;

    
    constructor(public http: HttpClient) {
    }


    getMovies(movieName: string): Promise<Movie[]> {
        
        let promise = new Promise<Movie[]>((resolve, reject) => {
            this.URL = this.BASE_URL + encodeURI(movieName) + this.API_key;
            this.http.get(this.URL).toPromise()
                .then((data: any) => {
                    let movies: Movie[] = new Array<Movie>();
                    let datos = data['results'];
                    for (let dato of datos) {
                        console.log(dato);
                        let movie = new Movie(
                            dato['id'],
                            dato['title'],
                            dato['release_date'],
                            dato['vote_average'],
                            dato['vote_count'],
                            dato['overview'],
                            dato['poster_path']);

                            if(movie.poster_path != null) movie.poster_path = "https://image.tmdb.org/t/p/w500" + movie.poster_path;

                        movies.push(movie);
                    }
                    resolve(movies);
                })
                .catch((error: string) => {
                    reject(error);
                });
        });
        return promise;
    }
}
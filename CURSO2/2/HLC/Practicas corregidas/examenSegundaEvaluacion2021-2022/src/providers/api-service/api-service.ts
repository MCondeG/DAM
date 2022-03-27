import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Hotel } from 'src/app/modelo/Hotel';

@Injectable()
export class ApiServiceProvider {

    private URL = "http://localhost:3000";

    constructor(public http: HttpClient) {
    }

    getHoteles(): Promise<Hotel[]> {
        let promise = new Promise<Hotel[]>((resolve, reject) => {
            this.http.get(this.URL + "/hoteles").toPromise()
                .then((data: any) => {
                    let hoteles = new Array<Hotel>();
                    data.forEach(hotelJson => {
                        let hotel = Hotel.createFromJsonObject(hotelJson);
                        hoteles.push(hotel);
                    });
                    resolve(hoteles);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }

}//end_class
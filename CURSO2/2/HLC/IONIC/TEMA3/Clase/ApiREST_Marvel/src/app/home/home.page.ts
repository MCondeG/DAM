import { Component } from '@angular/core';
import { ApiServiceProvider } from 'src/providers/api-service/api-service';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

  constructor(private apiService: ApiServiceProvider) {}



ngOnInit(): void {
  this.apiService.getComics()
    .then( (data:any)=> {
       
        console.log(data);
    })
    .catch( (error:string) => {
        console.log(error);
    });
}

}

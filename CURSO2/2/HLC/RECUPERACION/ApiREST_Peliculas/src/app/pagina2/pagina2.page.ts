import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import { AlertController, NavController, ToastController } from '@ionic/angular';
import { Movie } from 'src/modelo/Movie';
import { User } from 'src/modelo/User';
import { ApiService } from 'src/providers/api-service/ApiService';

@Component({
  selector: 'app-pagina2',
  templateUrl: './pagina2.page.html',
  styleUrls: ['./pagina2.page.scss'],
})


export class Pagina2Page implements OnInit {

  private user: User;
  private movies: Movie[];
  private movieName: string;


  constructor(private apiService: ApiService, public alertCtrl: AlertController, private activatedRoute: ActivatedRoute, private navCtrl: NavController, private toast: ToastController) {
    
    this.activatedRoute.queryParams.subscribe(params => {
      this.user = JSON.parse(params["user"]);
    });
  }


  ngOnInit() {

    this.movies = new Array<Movie>();
  }


  buscarPelicula() {
    this.apiService.getMovies(this.movieName)
      .then((busqueda: Movie[]) => {
        this.movies = busqueda;
      })
      .catch((error: string) => {
        console.log(error);
      });
  }

  async puntuar(indice: number) {
    let alert = await this.alertCtrl.create({
      header: 'Valorar',
      backdropDismiss: false,
      inputs: [
        {
          name: 'voto',
          type: 'number'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
          }
        },
        {
          text: 'OK',
          handler: data => {
            if ((data.voto >= 0) && (data.voto <= 9)) {
              console.log("Id: " + this.movies[indice].id);
              console.log("Titulo: " + this.movies[indice].title);
              console.log("Dni Usuario: " + this.user.dni);
              console.log("Valoración: " + data.voto);
              return true
            } else {
              this.numErroneo();
              return false

            }
          }
        }
      ]
    });
    alert.present();

    await alert.present();
  }

  numErroneo() {
    let toast = this.toast.create({
      message: 'Introduce una puntuación válida (0-9)',
      duration: 2000,
      position: 'top'
    }).then((toastData) => {
      toastData.present();
    });
  }

  clickPelicula(indice: number) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        movie: JSON.stringify(this.movies[indice])
      }
    };
    this.navCtrl.navigateForward('/pagina3', navigationExtras);
  }
}
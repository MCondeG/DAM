import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, NavigationExtras } from '@angular/router';
import { AlertController, NavController, ToastController } from '@ionic/angular';
import { NodeCompatibleEventEmitter } from 'rxjs/internal/observable/fromEvent';
import { ApiServiceProvider } from 'src/api_provider/api-service';
import { Configuration } from 'src/modelo/configuration';
import { Movie } from 'src/modelo/movie';
import { User } from 'src/modelo/user';

@Component({
  selector: 'app-pagina2',
  templateUrl: './pagina2.page.html',
  styleUrls: ['./pagina2.page.scss'],
})
export class Pagina2Page implements OnInit {

  configuration: Configuration[] = new Array();
  private user: User;
  movies: Movie[] = new Array();
  nombrePelicula: string;
  imagen: string = "/home/celiaperez/Escritorio/recuperacion1EvaluacionPerezOsunaCelia/src/cine.jpeg"
  constructor(private apiService: ApiServiceProvider, public alertCtrl: AlertController, private activatedRoute: ActivatedRoute, private navCtrl: NavController, private toast: ToastController) {
    this.activatedRoute.queryParams.subscribe(params => {
      this.user = JSON.parse(params["user"]);
      //console.log(this.user)
    });
  }

  ngOnInit() {
    this.configuration['poster_sizes'] = this.imagen
    /*this.apiService.getConfiguration()
      .then((configuracion: string) => {
        configuracion=this.imagen
        console.log(configuracion)
      })
      .catch((error: string) => {
        console.log(error);
      });*/

  }

  buscarPelicula(nombre) {
    console.log(nombre)
    this.apiService.getMovies(nombre)
      .then((movie: Movie[]) => {
        this.movies = movie
        //console.log(movie)
      })
      .catch((error: string) => {
        console.log(error);
      });
    //  console.log('buscando')
  }

  introducirPuntuacion() {
    //console.log('alert')
  }

  async presentAlert(indice: number) {
    let alert = await this.alertCtrl.create({
      header: 'Valorar',
      backdropDismiss: false,
      inputs: [
        {
          name: 'puntuacion',
          placeholder: 'vote',
          type: 'number'
        }
      ],
      buttons: [
        {
          text: 'Cancel',
          role: 'cancel',
          handler: () => {
            //console.log('Cancel clicked');
          }
        },
        {
          text: 'Confirmar',
          handler: data => {
            console.log('Confirm clicked');
            var valoresAceptados = /^[0-9]+$/;
            if (data.puntuacion.match(valoresAceptados)) {

              console.log("Id: " + this.movies[indice].id + " Titulo: " + this.movies[indice].title + " Dni: " + this.user.dni + " Puntuacion: " + data.puntuacion)
              return true
            } else {
              this.presentToast();
              return false

            }
          }
        }
      ]
    });
    alert.present();

    await alert.present();
  }

  movieClick(indice: number) {
    let navigationExtras: NavigationExtras = {
      queryParams: {
        movie: JSON.stringify(this.movies[indice])
      }
    };
    this.navCtrl.navigateForward('/pagina3', navigationExtras);
  }

  presentToast() {
    let toast = this.toast.create({
      message: 'Introduce un numero',
      duration: 1000,
      position: 'top'
    }).then((toastData) => {
      toastData.present();
    });
  }

}

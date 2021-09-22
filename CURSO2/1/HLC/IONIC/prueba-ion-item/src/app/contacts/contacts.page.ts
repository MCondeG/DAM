import { Component, OnInit } from '@angular/core';
import { NavController } from '@ionic/angular';

@Component({
  selector: 'app-contacts',
  templateUrl: './contacts.page.html',
  styleUrls: ['./contacts.page.scss'],
})
export class ContactsPage implements OnInit {

  contacts: string[];
  groupedContacts = []; //se inicializa vacío

  constructor(public navCtrl: NavController) {

    this.contacts = [
      'Kate Beckett',
      'Richard Castle',
      'Alexis Castle',
      'Lanie Parish',
      'Javier Esposito',
      'Kevin Ryan',
      'Martha Rodgers',
      'Roy Montgomery',
      'Jim Beckett',
      'Stana Katic',
      'Nathan Fillion',
      'Molly Quinn',
      'Tamala Jones',
      'Jon Huertas',
      'Seamus Dever',
      'Susan Sullivan'
    ];

    this.groupContacts(this.contacts);

  }

  groupContacts(contacts) {

    let sortedContacts = contacts.sort();  //se ordena el array de contactos
    let currentLetter = false;
    let currentContacts = [];

    //el array de contactos ya está ordenado. Se va recorriendo uno a uno
    //para cada contacto se ve su primera letra. Si esta letra ha cambiado con respecto
    //a la primera letra del contacto anterior creo un nuevo objeto 'newGroup'
    //este objeto tiene dos campos: la letra y un array con todos los contactos que comienzan
    //con dicha letra. Se hace que la variable currentContacts apunte al array del grupo
    //que se está tratando en ese momento
    //los contactos del array sortedContacts se van añadiendo a currentContacts
    sortedContacts.forEach((value, index) => {

      if (value.charAt(0) != currentLetter) {

        currentLetter = value.charAt(0);

        let newGroup = {
          letter: currentLetter,
          contacts: []
        };

        currentContacts = newGroup.contacts;
        this.groupedContacts.push(newGroup);

      }

      currentContacts.push(value);

    });  //end_forEach_sortedContacts

  }//end_method_groupContacts

  ngOnInit() {
  }

}//end_class
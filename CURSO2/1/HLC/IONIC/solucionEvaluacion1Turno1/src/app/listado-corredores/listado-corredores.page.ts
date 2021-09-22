import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado-corredores',
  templateUrl: './listado-corredores.page.html',
  styleUrls: ['./listado-corredores.page.scss'],
})
export class ListadoCorredoresPage implements OnInit {

  corredores = [
    {"dniCorredor":"04461824C","federado":true,"edad":16,"equipo":"C.A. MAURI CASTILLO","telefonoTutorLegal":""},
    {"dniCorredor":"11868449D","federado":true,"edad":68,"equipo":"C.A. ORIPPO","telefonoTutorLegal":""},
    {"dniCorredor":"37331919E","federado":false,"edad":15,"equipo":"","telefonoTutorLegal":"1141715026"},
    {"dniCorredor":"21006568D","federado":false,"edad":44,"equipo":"C.A. ORIPPO","telefonoTutorLegal":""},
    {"dniCorredor":"71248750C","federado":true,"edad":20,"equipo":"C.A HISPALENSE","telefonoTutorLegal":""},
    {"dniCorredor":"82861353D","federado":false,"edad":59,"equipo":"","telefonoTutorLegal":""},
    {"dniCorredor":"55333491D","federado":false,"edad":28,"equipo":"","telefonoTutorLegal":""},
    {"dniCorredor":"56434411E","federado":true,"edad":17,"equipo":"C.A. SAN PABLO","telefonoTutorLegal":""},
    {"dniCorredor":"91858871E","federado":true,"edad":47,"equipo":"C.A. ORIPPO","telefonoTutorLegal":""},
    {"dniCorredor":"42814642E","federado":false,"edad":16,"equipo":"","telefonoTutorLegal":"3273998881"},
    {"dniCorredor":"69366483A","federado":true,"edad":58,"equipo":"C.A. MAURI CASTILLO","telefonoTutorLegal":""}
  ];

  constructor() { }

  ngOnInit() {
  }

}

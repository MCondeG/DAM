import { Component } from '@angular/core';
import { Empleado } from '../modelo/Empleado';

@Component({
  selector: 'app-home',
  templateUrl: 'home.page.html',
  styleUrls: ['home.page.scss'],
})
export class HomePage {

ciudades: string[]=["sevilla", "madrid", "barcelona", "zaragoza"];

empleados: Empleado[]=[
    {
      "apellidos": "Dundridge",
      "nombre": "Bud",
      "practicas": true,
      "sueldo": 1944.55,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "McClay",
      "nombre": "Almeria",
      "practicas": false,
      "sueldo": 1469.86,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Whitmore",
      "nombre": "Bea",
      "practicas": false,
      "sueldo": 1130.33,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Wall",
      "nombre": "Casandra",
      "practicas": false,
      "sueldo": 1606.01,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Sissot",
      "nombre": "Eveline",
      "practicas": false,
      "sueldo": 1990.06,
      "categoria": "programador_senior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Bransom",
      "nombre": "Merilyn",
      "practicas": false,
      "sueldo": 1423.96,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Sneath",
      "nombre": "Ilsa",
      "practicas": true,
      "sueldo": 1449.43,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Downgate",
      "nombre": "Brena",
      "practicas": true,
      "sueldo": 1270.66,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Dumphry",
      "nombre": "Kristy",
      "practicas": false,
      "sueldo": 1279.97,
      "categoria": "analista",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Lambole",
      "nombre": "Hershel",
      "practicas": false,
      "sueldo": 1023.14,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Gingel",
      "nombre": "Cobby",
      "practicas": true,
      "sueldo": 1461.18,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Paske",
      "nombre": "Welch",
      "practicas": true,
      "sueldo": 1329.5,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Khan",
      "nombre": "Fleming",
      "practicas": true,
      "sueldo": 1580.81,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Swynfen",
      "nombre": "Baily",
      "practicas": false,
      "sueldo": 1533.07,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Le Marchand",
      "nombre": "Dorey",
      "practicas": false,
      "sueldo": 1420.77,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Guille",
      "nombre": "Dom",
      "practicas": true,
      "sueldo": 1884.48,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Cardno",
      "nombre": "Karna",
      "practicas": true,
      "sueldo": 1151.92,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Coode",
      "nombre": "Malanie",
      "practicas": true,
      "sueldo": 1783.81,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Biskupek",
      "nombre": "Mirna",
      "practicas": false,
      "sueldo": 1359.17,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Boarder",
      "nombre": "Vevay",
      "practicas": true,
      "sueldo": 1981.52,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Goschalk",
      "nombre": "Jehu",
      "practicas": false,
      "sueldo": 1081.81,
      "categoria": "programador_senior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Santi",
      "nombre": "Edouard",
      "practicas": true,
      "sueldo": 1404.84,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Craigmile",
      "nombre": "Andra",
      "practicas": true,
      "sueldo": 1168.56,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Chillingsworth",
      "nombre": "Cammy",
      "practicas": false,
      "sueldo": 1185.91,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Pavier",
      "nombre": "Deeanne",
      "practicas": false,
      "sueldo": 1886.82,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Ipplett",
      "nombre": "Lew",
      "practicas": true,
      "sueldo": 1646.7,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Mepham",
      "nombre": "Job",
      "practicas": false,
      "sueldo": 1275.86,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Butterley",
      "nombre": "Liva",
      "practicas": false,
      "sueldo": 1872.93,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Dunster",
      "nombre": "Arleen",
      "practicas": true,
      "sueldo": 1465.06,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Turbat",
      "nombre": "Wells",
      "practicas": true,
      "sueldo": 1178.41,
      "categoria": "programador_senior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Rymell",
      "nombre": "Berte",
      "practicas": false,
      "sueldo": 1737.53,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Cristoforetti",
      "nombre": "Violetta",
      "practicas": true,
      "sueldo": 1332.9,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Shayler",
      "nombre": "Merlina",
      "practicas": false,
      "sueldo": 1510.16,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Wherry",
      "nombre": "Robinette",
      "practicas": false,
      "sueldo": 1428.84,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Kermitt",
      "nombre": "Jilleen",
      "practicas": true,
      "sueldo": 1974.51,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Curado",
      "nombre": "Powell",
      "practicas": true,
      "sueldo": 1042.25,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Sherme",
      "nombre": "Diannne",
      "practicas": false,
      "sueldo": 1072.66,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Firebrace",
      "nombre": "Beck",
      "practicas": false,
      "sueldo": 1621.62,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Saunier",
      "nombre": "Sheridan",
      "practicas": true,
      "sueldo": 1729.62,
      "categoria": "analista",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Patroni",
      "nombre": "Hadria",
      "practicas": true,
      "sueldo": 1219.89,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Folley",
      "nombre": "Hadria",
      "practicas": false,
      "sueldo": 1517.36,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Leckenby",
      "nombre": "Queenie",
      "practicas": true,
      "sueldo": 1882.01,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Frie",
      "nombre": "Vernon",
      "practicas": true,
      "sueldo": 1245.64,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Lineham",
      "nombre": "Alisander",
      "practicas": false,
      "sueldo": 1640.63,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "De Ruggero",
      "nombre": "Dion",
      "practicas": false,
      "sueldo": 1309.86,
      "categoria": "programador_senior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Farland",
      "nombre": "Layla",
      "practicas": true,
      "sueldo": 1761.6,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Incogna",
      "nombre": "Damiano",
      "practicas": true,
      "sueldo": 1498.58,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Raithmill",
      "nombre": "Asher",
      "practicas": true,
      "sueldo": 1873.2,
      "categoria": "programador_senior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Marklew",
      "nombre": "Gussy",
      "practicas": false,
      "sueldo": 1354.86,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Lehmann",
      "nombre": "Larissa",
      "practicas": false,
      "sueldo": 1690.55,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Neames",
      "nombre": "Sela",
      "practicas": false,
      "sueldo": 1892.63,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Jaher",
      "nombre": "Melba",
      "practicas": true,
      "sueldo": 1718.24,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Conrart",
      "nombre": "Talbert",
      "practicas": true,
      "sueldo": 1266.44,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Mozzini",
      "nombre": "Nariko",
      "practicas": false,
      "sueldo": 1336.94,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Bande",
      "nombre": "Had",
      "practicas": true,
      "sueldo": 1263.43,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Oldham",
      "nombre": "Aili",
      "practicas": true,
      "sueldo": 1190.48,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Stansell",
      "nombre": "Dorolice",
      "practicas": false,
      "sueldo": 1053.75,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "MacAllaster",
      "nombre": "Keane",
      "practicas": true,
      "sueldo": 1126.66,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Smitton",
      "nombre": "Dannye",
      "practicas": false,
      "sueldo": 1255.81,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Hazleton",
      "nombre": "Vaughan",
      "practicas": true,
      "sueldo": 1318.39,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Couper",
      "nombre": "Marcelle",
      "practicas": true,
      "sueldo": 1370.85,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Flipsen",
      "nombre": "Obadias",
      "practicas": false,
      "sueldo": 1379.05,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Callcott",
      "nombre": "Erika",
      "practicas": false,
      "sueldo": 1008.8,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Esh",
      "nombre": "Viviyan",
      "practicas": false,
      "sueldo": 1255.47,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Fratczak",
      "nombre": "Wallie",
      "practicas": true,
      "sueldo": 1833.33,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Anderbrugge",
      "nombre": "Jackson",
      "practicas": true,
      "sueldo": 1399.04,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Sanders",
      "nombre": "Carolan",
      "practicas": true,
      "sueldo": 1028.73,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Leachman",
      "nombre": "Tallie",
      "practicas": false,
      "sueldo": 1428.09,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Stallibrass",
      "nombre": "Maynard",
      "practicas": true,
      "sueldo": 1318.51,
      "categoria": "programador_senior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Burborough",
      "nombre": "Carree",
      "practicas": false,
      "sueldo": 1495.43,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Inkpen",
      "nombre": "Daryn",
      "practicas": true,
      "sueldo": 1938.28,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Marcoolyn",
      "nombre": "Anissa",
      "practicas": true,
      "sueldo": 1260.94,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Hazeman",
      "nombre": "Kamila",
      "practicas": false,
      "sueldo": 1342.92,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Grisenthwaite",
      "nombre": "Townsend",
      "practicas": false,
      "sueldo": 1697.99,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Golightly",
      "nombre": "Tanney",
      "practicas": false,
      "sueldo": 1678.01,
      "categoria": "programador_senior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Willan",
      "nombre": "Benjie",
      "practicas": false,
      "sueldo": 1876.89,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Gard",
      "nombre": "Curtis",
      "practicas": true,
      "sueldo": 1419.33,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Frankling",
      "nombre": "Alina",
      "practicas": false,
      "sueldo": 1111.84,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Nolan",
      "nombre": "Dion",
      "practicas": true,
      "sueldo": 1912.72,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Fripps",
      "nombre": "Georgianna",
      "practicas": true,
      "sueldo": 1276.63,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Curtois",
      "nombre": "Vannie",
      "practicas": false,
      "sueldo": 1047.01,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Edelston",
      "nombre": "Sullivan",
      "practicas": true,
      "sueldo": 1036.74,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Ebden",
      "nombre": "Alfy",
      "practicas": false,
      "sueldo": 1804.3,
      "categoria": "programador_senior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Pyecroft",
      "nombre": "Bat",
      "practicas": true,
      "sueldo": 1436.16,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Wolfenden",
      "nombre": "August",
      "practicas": false,
      "sueldo": 1806.92,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Odlin",
      "nombre": "Joellyn",
      "practicas": true,
      "sueldo": 1948.86,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Village",
      "nombre": "Martina",
      "practicas": true,
      "sueldo": 1919.46,
      "categoria": "analista",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Sandland",
      "nombre": "Launce",
      "practicas": true,
      "sueldo": 1189.71,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Godlip",
      "nombre": "Shaun",
      "practicas": true,
      "sueldo": 1396.47,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Frohock",
      "nombre": "Gayle",
      "practicas": true,
      "sueldo": 1465.95,
      "categoria": "analista",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Hartopp",
      "nombre": "Tomaso",
      "practicas": true,
      "sueldo": 1938.05,
      "categoria": "programador_senior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Campelli",
      "nombre": "Dionis",
      "practicas": true,
      "sueldo": 1731.74,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "Grassett",
      "nombre": "Tomkin",
      "practicas": false,
      "sueldo": 1083.28,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Coulson",
      "nombre": "Angeli",
      "practicas": false,
      "sueldo": 1565.96,
      "categoria": "programador_junior",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Kingscote",
      "nombre": "Dennie",
      "practicas": false,
      "sueldo": 1244.49,
      "categoria": "analista",
      "ciudad": "sevilla"
    },
    {
      "apellidos": "Tripcony",
      "nombre": "Bren",
      "practicas": true,
      "sueldo": 1444.18,
      "categoria": "programador_junior",
      "ciudad": "zaragoza"
    },
    {
      "apellidos": "Dungate",
      "nombre": "Berky",
      "practicas": false,
      "sueldo": 1990.95,
      "categoria": "programador_junior",
      "ciudad": "barcelona"
    },
    {
      "apellidos": "MacConneely",
      "nombre": "Derek",
      "practicas": false,
      "sueldo": 1580.67,
      "categoria": "programador_junior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Fealey",
      "nombre": "Norean",
      "practicas": true,
      "sueldo": 1419.85,
      "categoria": "programador_senior",
      "ciudad": "madrid"
    },
    {
      "apellidos": "Scholard",
      "nombre": "Tammy",
      "practicas": false,
      "sueldo": 1249.84,
      "categoria": "programador_senior",
      "ciudad": "barcelona"
    }
  ];

  ciudad:string=null;
  mostrarEmpleados:boolean=false;
  empleadosSeleccionados:Empleado[];
  sueldo:number=null;
  practicas:boolean=false;
  categoria:string;
  

  constructor() {
  }


  public buscar(){
    var cadenaBuscarCiudad:string;
    var cadenaBuscarSueldo:string;

    if(this.ciudad==null)
      cadenaBuscarCiudad="true";
    else
      cadenaBuscarCiudad="empleado.ciudad.normalize().trim()===this.ciudad.normalize().trim()";

    if(this.sueldo==null)
      cadenaBuscarSueldo="true";
    else
      cadenaBuscarSueldo="empleado.sueldo>= this.sueldo";

    console.log(cadenaBuscarSueldo + "" + cadenaBuscarCiudad + "");

    this.empleadosSeleccionados=[];
    this.empleados.forEach(empleado=>{
        if(eval(cadenaBuscarCiudad) 
                && eval(cadenaBuscarSueldo)
                && this.practicas==empleado.practicas){
          this.empleadosSeleccionados.push(empleado);
        }
    })
    this.mostrarEmpleados=true;
  }

  public volver(){
    this.mostrarEmpleados=false;
    this.empleadosSeleccionados=[];
    //this.ciudad=null;
    //this.sueldo=null;
    //this.practicas=null;
  }


}//end_class

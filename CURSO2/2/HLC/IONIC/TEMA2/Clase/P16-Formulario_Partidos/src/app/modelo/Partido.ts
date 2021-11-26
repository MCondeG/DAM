import { InterfacePartido } from "./InterfacePartido";

export class Partido implements InterfacePartido{
    
    constructor(public equipoLocal:string, 
        public equipoVisitante: string,
        public fecha: Date,
        public golesEquipoLocal: number,
        public golesEquipoVisitante: number,
        public jugadoresEquipoLocal: string[],
        public jugadoresEquipoVisitante: string[]){
    }
    

}
export class Partido {
    constructor(public fecha: string, public equipoLocal: string, public equipoVisitante: string,
                public golesLocal: number, public golesVisitante: number, 
                public alineacionLocal: string[], public alineacionVisitante: string[]){

    }
}
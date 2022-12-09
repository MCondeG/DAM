export class Partido {

    equipoLocal: string = "";
    equipoVisitante: string = "";
    puntosLocal: number = 0;
    puntosVisitante: number = 0;


    constructor(equipoLocal: string, equipoVisitante: string, puntosLocal: number, puntosVisitante: number) {

        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.puntosLocal = puntosLocal;
        this.puntosVisitante = puntosVisitante;
    }
}
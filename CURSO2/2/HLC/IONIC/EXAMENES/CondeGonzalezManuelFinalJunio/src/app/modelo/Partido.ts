
export class Partido {

    id: string = null; 
    equipoLocal: string = null;
    equipoVisitante: string = null;
    puntosLocal: number = 0;
    puntosVisitante: number = 0;

    constructor() {
    }
    

    public static createFromJsonObject(jsonObject: any): Partido {
        let partido: Partido = new Partido();
        partido.id = jsonObject['id'];
        partido.equipoLocal = jsonObject['equipoLocal'];
        partido.equipoVisitante = jsonObject['equipoVisitante'];
        partido.puntosLocal = jsonObject['golesEquipoLocal'];
        partido.puntosVisitante = jsonObject['golesEquipoVisitante'];
        return partido;
    }
}
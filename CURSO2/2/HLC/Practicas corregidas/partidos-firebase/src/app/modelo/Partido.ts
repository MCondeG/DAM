
export class Partido {

    id: string = null; 
    equipoLocal: string = null;
    equipoVisitante: string = null;
    golesEquipoLocal: number = 0;
    golesEquipoVisitante: number = 0;
    horaInicioPartido: number=null;
    horaFinPrimeraParte: number=null;
    horaInicioSegundaParte: number=null;
    horaFinPartido: number=null;
    minutosJugados:string=null;

    constructor() {
    }

    public static createFromJsonObject(jsonObject: any): Partido {
        let partido: Partido = new Partido();
        partido.id = jsonObject['id'];
        partido.equipoLocal = jsonObject['equipoLocal'];
        partido.equipoVisitante = jsonObject['equipoVisitante'];
        partido.golesEquipoLocal = jsonObject['golesEquipoLocal'];
        partido.golesEquipoVisitante = jsonObject['golesEquipoVisitante'];
        partido.horaInicioPartido = jsonObject['horaInicioPartido'];
        partido.horaFinPrimeraParte = jsonObject['horaFinPrimeraParte'];
        partido.horaInicioSegundaParte = jsonObject['horaInicioSegundaParte'];
        partido.horaFinPartido = jsonObject['horaFinPartido'];
        partido.minutosJugados = jsonObject['minutosJugados'];
        return partido;
    }

    public noIniciado():boolean {
        if(this.horaInicioPartido==null)
            return true;
        else    
            return false;
    }

    public finalizado():boolean {
        if(this.horaFinPartido!=null)
            return true;
        else    
            return false;
    }

    public descanso():boolean{
        if(this.horaFinPrimeraParte!=null && this.horaInicioSegundaParte==null)
            return true;
        else
            return false;
    }

    public primerTiempo(){
        if(this.horaInicioPartido!=null && this.horaFinPrimeraParte==null)
            return true;
        else
            return false;
    }

    public segundoTiempo(){
        if(this.horaInicioSegundaParte!=null && this.horaFinPartido==null)
            return true;
        else
            return false;
    }

}//end_class
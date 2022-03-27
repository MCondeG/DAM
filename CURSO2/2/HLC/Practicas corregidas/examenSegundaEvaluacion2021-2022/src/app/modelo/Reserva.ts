
export class Reserva {

    id: any = null;  
    nombre: string = "";
    ciudad: string = "";
    direccion: string = "";
    fechaEntrada: string = null;
    fechaSalida: string = null;
    email:string=null;

    constructor() {
    }

    public static createFromJsonObject(jsonObject: any): Reserva {
        let reserva: Reserva = new Reserva();
        reserva.id = jsonObject['id'];
        reserva.nombre = jsonObject['nombre'];
        reserva.ciudad = jsonObject['ciudad'];
        reserva.fechaEntrada = jsonObject['fechaEntrada'];
        reserva.fechaSalida = jsonObject['fechaSalida'];
        reserva.email = jsonObject['email'];
        return reserva;
    }

}//end_class
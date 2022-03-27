
export class Hotel {

    id: any = null;  //el tipo es any para que valga para firebase (string) y json-server (number)
    nombre: string = "";
    ciudad: string = "";
    direccion: string = "";
    latitud: number = null;
    longitud: number = null;

    constructor() {
    }

    public static createFromJsonObject(jsonObject: any): Hotel {
        let hotel: Hotel = new Hotel();
        hotel.id = jsonObject['id'];
        hotel.nombre = jsonObject['nombre'];
        hotel.ciudad = jsonObject['ciudad'];
        hotel.direccion = jsonObject['direccion'];
        hotel.latitud = jsonObject['latitud'];
        hotel.longitud = jsonObject['longitud'];
        return hotel;
    }

}//end_class
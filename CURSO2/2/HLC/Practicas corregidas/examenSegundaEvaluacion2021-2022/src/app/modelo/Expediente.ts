export class Expediente {
    urlFile:string=null;
    descripcion:string=null;

    public static createFromJsonObject(jsonObject: any): Expediente {
        let expediente: Expediente = new Expediente();
        expediente.urlFile = jsonObject['urlFile'];
        expediente.descripcion = jsonObject['descripcion'];
        return expediente;
    }
}
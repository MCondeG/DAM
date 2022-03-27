import { Expediente } from "./Expediente";

export class Alumno {

    id: any = null;  //el tipo es any para que valga para firebase (string) y json-server (number)
    first_name: string = "";
    last_name: string = "";
    email: string = "";
    gender: string = 'Male';
    avatar: string = null;
    address: string = "";
    city: string = "";
    expedientes:Expediente[]=new Array();

    constructor() {
    }

    public static createFromJsonObject(jsonObject: any): Alumno {
        let alumno: Alumno = new Alumno();
        alumno.id = jsonObject['id'];
        alumno.first_name = jsonObject['first_name'];
        alumno.last_name = jsonObject['last_name'];
        alumno.email = jsonObject['email'];
        alumno.gender = jsonObject['gender'];
        alumno.avatar = jsonObject['avatar'];
        alumno.address = jsonObject['address'];
        alumno.city = jsonObject['city'];
        jsonObject.expedientes.forEach(expedienteJson => {
            alumno.expedientes.push(Expediente.createFromJsonObject(expedienteJson));
        });
        return alumno;
    }

}//end_class
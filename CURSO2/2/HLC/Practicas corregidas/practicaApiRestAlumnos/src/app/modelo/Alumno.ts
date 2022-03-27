export class Alumno {

    id: any = null;  //el tipo es any para que valga para firebase (string) y json-server (number)
    first_name: string = "";
    last_name: string = "";
    email: string = "";
    gender: string = 'Male';
    avatar: string = "";
    address: string = "";
    city: string = "";

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
        return alumno;
    }

}//end_class
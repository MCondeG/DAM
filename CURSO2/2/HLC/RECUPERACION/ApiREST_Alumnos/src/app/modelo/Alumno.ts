export class Alumno {

    
    constructor(public id:number,
        public first_name:string,
        public last_name:string,
        public email:string,
        public gender:string,
        public avatar:string,
        public address:string,
        public city:string,
        public postalCode:string
        )
    {  }
    
    
    public static createFromJsonObject(jsonObject:any):Alumno
    {
        let alumno:Alumno= new Alumno(jsonObject['id'],
            jsonObject['first_name'],
            jsonObject['last_name'],
            jsonObject['email'],
            jsonObject['gender'],
            jsonObject['avatar'],
            jsonObject['address'],
            jsonObject['city'],
            jsonObject['postalCode']);
            return alumno;
    }
                
}//end_class
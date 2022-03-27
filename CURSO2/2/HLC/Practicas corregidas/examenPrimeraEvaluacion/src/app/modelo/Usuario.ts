export class Usuario{
    id:number;
    apellidos:string;
    nombre:string;
    dni:string;
    pasaporte:string;
    nacionalidad:string;
    familiaNumerosa:boolean;
    categoriaFamiliaNumerosa:string;

    constructor(){}

    public static createFromJsonObject(jsonObject:any):Usuario
    {
        let usuario:Usuario= new Usuario();
            usuario.id=jsonObject['id'];
            usuario.apellidos=jsonObject['apellidos'];
            usuario.nombre=jsonObject['nombre'];
            usuario.dni=jsonObject['dni'];
            usuario.pasaporte=jsonObject['pasaporte'];
            usuario.nacionalidad=jsonObject['nacionalidad'];
            usuario.familiaNumerosa=jsonObject['familiaNumerosa'];
            usuario.categoriaFamiliaNumerosa=jsonObject['categoriaFamiliaNumerosa'];
            return usuario;
    }
}
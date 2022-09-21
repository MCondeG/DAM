import { InterfaceUsuario } from "./InterfaceUsutsario";

export class Usuario implements InterfaceUsuario{

    constructor(public apellidosNombre: string,
                public fechaNacimiento: Date,
                public dni: string){
    }
}
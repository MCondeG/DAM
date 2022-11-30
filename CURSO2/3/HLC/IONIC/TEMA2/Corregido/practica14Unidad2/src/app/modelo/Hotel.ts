import { Valoracion } from "./Valoracion"

export class Hotel {
    constructor(public nombre: string,
        public valoraciones: Valoracion[]){

    }
}
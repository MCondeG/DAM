export class Usuario {

    public nombre: string;
    public apellido: string;
    public dni: string;
    public pasaporte: string;
    public nacionalidad: string;
    public famNumerosa: boolean;

    
    constructor() {

        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.pasaporte = "";
        this.nacionalidad = "";
        this.famNumerosa = false;
    }
}
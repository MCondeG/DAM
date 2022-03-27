import { Alumno } from "src/app/modelo/Alumno";

export interface InterfaceProvider {

    getAlumnos():Promise<Alumno[]>;

    eliminarAlumno(alumno: Alumno): Promise<Boolean>;

    modificarAlumno(nuevosDatosAlumno: Alumno): Promise<Alumno>;

    insertarAlumno(datosNuevoAlumno: Alumno): Promise<Alumno>;

    removeFile(urlFile:string): Promise<string>

    uploadImage(file: File, name: string): Promise<string> 

    uploadPdfDocument(file: File, name: string): Promise<string> 

}
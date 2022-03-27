import { Observable } from "rxjs";
import { Partido } from "src/app/modelo/Partido";

export interface InterfaceProvider {

    getPartidos():Observable<Partido[]>;

    modificarPartido(nuevosDatosPartido: Partido): Promise<Partido>;

    insertarPartido(datosNuevoPartido: Partido): Promise<Partido>;

}
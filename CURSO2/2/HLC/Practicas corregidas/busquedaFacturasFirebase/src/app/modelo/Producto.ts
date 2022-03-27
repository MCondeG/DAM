export class Producto{

    id: number=null;
    descripcion:string;
    importeUnitario: number;

    constructor(){
    }

    public static createFromJsonObject(jsonObject: any): Producto {
        let producto: Producto = new Producto();
        producto.id = jsonObject['id'];
        producto.descripcion = jsonObject['descripcion'];
        producto.importeUnitario = jsonObject['importeUnitario'];
        return producto;
    }
}

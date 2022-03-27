export class DetalleProducto{

    descripcion: string;
    importeUnitario: number;
    unidades:number;

    constructor(){
    }

    getStringImporteUnitario():string{
        let cantidad:number=this.importeUnitario;
        let cadena:string=new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(cantidad);
        return cadena;
    }

    getImporteTotal():number{
        return (this.importeUnitario*this.unidades);
    }

    getStringImporteTotal():string{
        let cantidad:number=this.getImporteTotal();
        let cadena:string=new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(cantidad);
        return cadena;
    }

    public static createFromJsonObject(jsonObject: any): DetalleProducto {
        let detalleProducto: DetalleProducto = new DetalleProducto();
        detalleProducto.descripcion = jsonObject['descripcion'];
        detalleProducto.importeUnitario = jsonObject['importeUnitario'];
        detalleProducto.unidades = jsonObject['unidades'];
        return detalleProducto;
    }
}
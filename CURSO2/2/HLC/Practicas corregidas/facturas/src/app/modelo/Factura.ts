import { DetalleProducto } from "./DetalleProducto";

export class Factura{

    id: number=null;
    cliente: string=null;
    porcentajeIva: number=0.0;
    productos: DetalleProducto[]=new Array();

    constructor(){
    }

    getImporteTotalSinIva():number{
        let importeTotalSinIva:number=0.0;
        this.productos.forEach(detalleProducto =>{
            importeTotalSinIva+=detalleProducto.importeUnitario*detalleProducto.unidades;
        });
        return importeTotalSinIva;
    }

    getStringImporteTotalSinIva():string{
        let cantidad:number=this.getImporteTotalSinIva();
        let cadena:string=new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(cantidad);
        return cadena;
    }
    

    getImporteIva():number{
        let importeIva:number=0.0;
        importeIva=this.getImporteTotalSinIva()*this.porcentajeIva/100;
        return importeIva;
    }

    getImporteTotalConIva():number{
        let importeTotalConIva:number=0.0;
        importeTotalConIva=this.getImporteTotalSinIva()+this.getImporteIva();
        return importeTotalConIva;
    }

    getStringImporteTotalConIva():string{
        let cantidad:number=this.getImporteTotalConIva();
        let cadena:string=new Intl.NumberFormat('es-ES', { style: 'currency', currency: 'EUR' }).format(cantidad);
        return cadena;
    }

    public static createFromJsonObject(jsonObject: any): Factura {
        let factura: Factura = new Factura();
            factura.id=jsonObject['id'];
            factura.cliente=jsonObject['cliente'];
            factura.porcentajeIva=jsonObject['porcentajeIva'];
            jsonObject.productos.forEach(detalleProductoJson => {
                let detalleProducto:DetalleProducto=new DetalleProducto();
                detalleProducto.descripcion=detalleProductoJson['descripcion'];
                detalleProducto.unidades=detalleProductoJson['unidades'];
                detalleProducto.importeUnitario=detalleProductoJson['importeUnitario'];
                factura.productos.push(detalleProducto);
            });
        return factura;
    }


}
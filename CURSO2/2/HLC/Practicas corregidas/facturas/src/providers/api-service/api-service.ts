import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Cliente } from 'src/app/modelo/Cliente';
import { Factura } from 'src/app/modelo/Factura';
import { Producto } from 'src/app/modelo/Producto';

@Injectable()
export class ApiServiceProvider {

    private URL = "http://localhost:3000";

    constructor(public http: HttpClient) {
    }

    getFacturas(): Promise<Factura[]> {
        let promise = new Promise<Factura[]>((resolve, reject) => {
            this.http.get(this.URL + "/facturas").toPromise()
                .then((data: any) => {
                    let facturas = new Array<Factura>();
                    data.forEach(facturaJson => {
                        let factura = Factura.createFromJsonObject(facturaJson);
                        facturas.push(factura);
                    });
                    resolve(facturas);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getFacturas

    getClientes(): Promise<Cliente[]> {
        let promise = new Promise<Cliente[]>((resolve, reject) => {
            this.http.get(this.URL + "/clientes").toPromise()
                .then((data: any) => {
                    let clientes = new Array<Cliente>();
                    data.forEach(clienteJson => {
                        let cliente = Cliente.createFromJsonObject(clienteJson);
                        clientes.push(cliente);
                    });
                    resolve(clientes);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getClientes

    getProductos(): Promise<Producto[]> {
        let promise = new Promise<Producto[]>((resolve, reject) => {
            this.http.get(this.URL + "/productos").toPromise()
                .then((data: any) => {
                    let productos = new Array<Producto>();
                    data.forEach(productoJson => {
                        let producto = Producto.createFromJsonObject(productoJson);
                        productos.push(producto);
                    });
                    resolve(productos);
                })
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_getProductos

    insertarFactura(nuevaFactura: Factura): Promise<Factura> {
        let promise = new Promise<Factura>((resolve, reject) => {
            var header = { "headers": { "Content-Type": "application/json" } };
            delete nuevaFactura.id; //cuando se hace un post no paso el id. El id es asignado por el servidor. Quito el atributo del objeto json
            let datos = JSON.stringify(nuevaFactura);
            this.http.post(this.URL + "/facturas/",datos,header).toPromise().then(
                    (data: any) => { // Success
                        let factura: Factura;
                        factura = Factura.createFromJsonObject(data);
                        resolve(factura);
                    }
                )
                .catch((error: Error) => {
                    reject(error.message);
                });
        });
        return promise;
    }//end_insertarFactura
 
}//end_class
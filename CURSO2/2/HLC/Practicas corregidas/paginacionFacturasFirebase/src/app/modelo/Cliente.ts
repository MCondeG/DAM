export class Cliente {

    id: number;
    cliente: string;

    constructor() {
    }

    public static createFromJsonObject(jsonObject: any): Cliente {
        let cliente: Cliente = new Cliente();
        cliente.id = jsonObject['id'];
        cliente.cliente = jsonObject['cliente'];
        return cliente;
    }
}
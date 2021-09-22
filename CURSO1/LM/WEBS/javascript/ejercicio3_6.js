
    function calcularPrecio() {
        var precio = parseInt(document.getElementById('pizza').value);
        var cantidad = parseInt(document.getElementById('cantidad').value);
        var total = precio*cantidad;
        document.getElementById('preciototal').value = total;
    }
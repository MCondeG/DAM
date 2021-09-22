function borrar(control) {
    control.value = '';
}

function verificar(control) {
    if (control.value.length < 7 || control.value.length > 20) alert('ERROR. Introduzca una clave de 7 a 20 caracteres');
}
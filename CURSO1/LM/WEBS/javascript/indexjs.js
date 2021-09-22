function desplegar(element) {
    element.parentNode.getElementsByClassName("enlaces")[0].classList.toggle("show");
}

window.onclick = function(event) {
  if (!event.target.matches('.boton')) {
    var desplegables = document.getElementsByClassName("enlaces");
    for (var i = 0; i < desplegables.length; i++) {
      var n = desplegables[i];
      if (n.classList.contains('show')) n.classList.remove('show');
    }
  }
}

    function comprobar() {
      var deporte = '';
        if (document.getElementById("c1").checked) deporte = deporte+' Fútbol,';
        if (document.getElementById("c2").checked) deporte = deporte+' Básket,';
        if (document.getElementById("c3").checked) deporte = deporte+' Tenis,';
        alert('Has seleccionado:'+deporte.substring(0, (deporte.length - 1)));
    }
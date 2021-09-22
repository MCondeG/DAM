function loadXMLDoc() {
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) myFunction(this);
    };
    xmlhttp.open("GET", "XML/cdcatalog.xml", true);
    xmlhttp.send();
}

function myFunction(xml) {
    var x, xmlDoc, table;
    xmlDoc = xml.responseXML;
    table = "<tr><th>Artist</th><th>Title</th><th>Year</th></tr>";
    x = xmlDoc.getElementsByTagName("CD");
    for (var i = 0; i < x.length; i++) {
        table += "<tr><td>"+x[i].getElementsByTagName("ARTIST")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("TITLE")[0].childNodes[0].nodeValue+"</td><td>"+x[i].getElementsByTagName("YEAR")[0].childNodes[0].nodeValue+"</td></tr>";
    }

    document.getElementById("demo").innerHTML = table;
}
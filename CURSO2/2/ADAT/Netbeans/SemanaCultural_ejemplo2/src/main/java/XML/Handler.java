package XML;

import modelo.Profesor;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class Handler extends DefaultHandler {
     
    ArrayList<Profesor> lista = new ArrayList<>();
    StringBuilder cadena = new StringBuilder();
    Profesor p = new Profesor();

    @Override
    public void startDocument() {
    }
  
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atrbts) {    
        cadena.setLength(0);
        if (qName.equalsIgnoreCase("profesor")) {
            int id = Integer.parseInt(atrbts.getValue("id"));
            p = new Profesor();
            p.setId_profesor(id);
        }        
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (qName.equalsIgnoreCase("nombre")) {
            p.setNombre(cadena.toString());
        }
        else if (qName.equalsIgnoreCase("usuario")) {
            p.setNombreUsuario(cadena.toString());
        }
        else if (qName.equalsIgnoreCase("password")) {
            p.setPassword(cadena.toString());
        }
        else if (qName.equalsIgnoreCase("profesor")) {
            lista.add(p);
        }  
    } 

    @Override
    public void characters(char[] chars, int inicio, int lon) {
        cadena.append(chars, inicio, lon);
    }
    
    public ArrayList<Profesor> getLista() {
        return lista;
    }
    
    public Profesor getProfesor() {
        return p;
    }
  
}
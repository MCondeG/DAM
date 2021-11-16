package XML;

import modelo.Profesor;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.InputStream;
import java.util.ArrayList;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

public class Parser {
    
    private String archivoXML;
    private Handler handler;

    public Parser(String archivoXML) {
        this.archivoXML=archivoXML;
        handler = new Handler();
    }
    
    public Parser() {    
    }

    public ArrayList<Profesor> procesarFichero() throws Exception {
            leerXml(archivoXML);
            return handler.getLista();
    }
    
    private void leerXml(String archivoXML) throws Exception {
        File file = new File(archivoXML);
        InputStream entrada = new FileInputStream(file);
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();
        XMLReader lector = saxParser.getXMLReader();
        lector.setContentHandler(handler);
        lector.parse(new InputSource(entrada));
    }

}

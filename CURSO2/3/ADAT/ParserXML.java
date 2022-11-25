package ;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


public class ParserXML {

    
    private SAXHandler handler;
    
    
    public ParserXML(){
        this.handler = new SAXHandler();
    }

    
    public SAXHandler getHandler() {
        return handler;
    }

    public void setHandler(SAXHandler handler) {
        this.handler = handler;
    }    
    
    
    public void leerXML(String rutaFichero) throws Exception {
        
        //localizo el fichero XML
        File file = new File(rutaFichero);
	InputStream entrada = new FileInputStream(file);
        
        //Instancio una factoria y la factoria me proporciona un objeto de la
        //clase SaxParser
        SAXParserFactory factory = SAXParserFactory.newInstance();
	SAXParser saxParser = factory.newSAXParser();  
        
        //Del objeto saxParser obtengo un lector de archivos XML
        XMLReader lector = saxParser.getXMLReader();
        
        //le pasamos al lector el manejador específico para ese archivo XML
        lector.setContentHandler(this.handler);
        lector.parse(new InputSource(entrada));   
    }
}

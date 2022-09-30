import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler; 

// Crear un manejador SAX para procesar el documento
public class SAXHandler extends DefaultHandler {
	
	public void startDocument() throws SAXException {
		System.out.println("startDocument");
	}
	
	public void endDocument() throws SAXException {
		System.out.println("endDocument"); 
	}
	
	
	public void characters(char[] ch, int start, int length)
	    throws SAXException {
	    String charString = new String(ch, start, length); 
	    System.out.println("caracteres: " + charString); 
	}
	
	public void startElement(String namespaceURI, String localName, 
	                         String qName, Attributes atts) 
	    throws SAXException {
	    System.out.println("startElement: " + qName);
	    
	    // Lista atributos y sus valores
	    for (int i=0; i<atts.getLength(); i++) {
	    	System.out.println("Atributo: " + atts.getLocalName(i));
	    	System.out.println("\tValor: " + atts.getValue(i));
	    }
	}
	
	public void endElement(String nameSpaceURI, String localName, String qName) 
	    throws SAXException {
	    System.out.println("endElement: " + qName);
	}
	
	public void ignorableWhitespace(char[] ch, int start, int length) 
	    throws SAXException {
	    System.out.println(length + " caracteres en blanco ignorables"); 
	}
	
	public void startPrefixMapping(String prefix, String uri) 
	    throws SAXException {
	    System.out.println("Comienza prefijo de namespace: " + prefix); 
	}
	
	public void endPrefixMapping(String prefix) 
	    throws SAXException {
	    System.out.println("Termina prefijo de namespace: " + prefix); 
	} 
	
	public void processingInstruction(String instruction, String data) 
	    throws SAXException {
	    System.out.println("Instrucción: " + instruction + ", datos: " + data); 
	}
	
	public void skippedEntity(String name) throws SAXException {
		System.out.println("Entidad saltada: " + name);
	}
	
}
		
	 
		
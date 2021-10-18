/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pruebaxml;


import DaoImplements.DaoProfesorXML;
import java.util.ArrayList;
import modelo.Profesor;


/**
 *
 * @author enrique
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        DaoProfesorXML dp= new DaoProfesorXML("./src/profesoresJulioVerne.xml");
        
        
        ArrayList<Profesor> profesores=dp.verProfesores();
        
        
        for(Profesor p:profesores){
           
           System.out.println("profesor: "+p.getNombre()+"   cp:   "+p.getCp()+" "+p.getHorasLectivas()+" "+p.isMayor55());
        }
    }
}
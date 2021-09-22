/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexionbd;

/**
 *
 * @author enrique
 */
public class PruebaConexionBd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ConexionBD conexion=new ConexionBD("mysql","libreria","root","enrique");
        conexion.ejecutarSQL("select * from libros");
//        conexion.mostrarRegistrosln();
//        System.out.println("***************************************");
//        conexion.mostrarRegistros();
        conexion.imprimirTabla();
       

    }

}

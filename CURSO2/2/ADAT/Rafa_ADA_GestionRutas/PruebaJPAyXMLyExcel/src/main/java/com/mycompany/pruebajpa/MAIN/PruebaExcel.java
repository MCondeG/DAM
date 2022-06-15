/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pruebajpa.MAIN;

import Excel.DocumentoExcel;
import Excel.DocumentoExcelEditable;
import java.io.IOException;
import com.mycompany.pruebajpa.ENTITY.Ruta;

/**
 *
 * @author rafa
 */
public class PruebaExcel {
    
    public static void main(String[] args) throws IOException {
        
        //OPERACIONES CON CLASE DOCUMENTOEXCEL
        String archivo="src/salida.xls";
        DocumentoExcel doc = new DocumentoExcel(archivo);
         //*** SE EMPIEZA A CONTAR COMO HOJA 0, FILA 0 Y COLUMNA 0 ***
        System.out.println("Nombre Hoja Numero 1: "+doc.getNombreHoja(0));
        System.out.println("Nombre Hoja Numero 2: "+doc.getNombreHoja(1));
        doc.setHojaActual(0); 
        System.out.println("Hoja Actual: "+doc.getNombreHojaActual());
       
        
        
        int nColumnas = doc.getNumCols("Ruta1");
        int nFilas = doc.getNumFilas("Ruta1");
        
        
        System.out.println("Numero de columna de la pagina1: "+nColumnas);
        System.out.println("Numero de filas de la pagina1: "+nFilas);
        System.out.println("---------------------------");
        
        
        int celda=0;
        int fila=0;
        
        
        Ruta ruta = new Ruta();
     
        
        for(celda=0;celda<nColumnas;celda++){
            
            for(fila=0;fila<nFilas;fila++){
              
                String dato = doc.getDato(fila, celda);
               
               
                   if(isNumeric(dato)==true){
                       
                       ruta.setDistanciaReal(Float.valueOf(dato));
                       System.out.println("Distancia : "+dato);
                   } else if(isNumeric(dato)==false && !dato.equals("")){
                       ruta.setDescripcion(dato);
                       System.out.println("Descripcion: "+dato);
                   }else{
                       
                   }               
                
                
                 
                
                 
            }
            
         
            
        }
    
        
        
       
        
        //OPERACIONES CON CLASE DOCUMENTOEXCELEDITABLE
        DocumentoExcelEditable doc2 = new DocumentoExcelEditable(archivo);
        //Creamos el archivo Excel
        doc2.crearArchivoEditable();
        //Creamos las hojas
        doc2.crearHoja("Ruta3");
        
        System.out.println("Nombre hoja creada: "+doc2.getNombreHoja(0));
        System.out.println("*************************************");


        //Hacemos la hoja la actual
        doc2.setHojaActual(0);
        System.out.println("Hoja Actual: "+doc2.getNombreHojaActual());
        System.out.println("*************************************");

        //Introducimos los datos
        doc2.insertarEtiqueta(0, 0, "Nombre Posicion");
        doc2.insertarEtiqueta(0, 1, "Huelva");
        doc2.insertarEtiqueta(0, 2, "Almeria");
        doc2.insertarEtiqueta(1, 0, "Longitud");
        doc2.insertarNumero(1, 1, 200);
        doc2.insertarNumero(1, 2, 350);
        
       
        
        
       
        Ruta ruta2 = new Ruta();
        
        int nColumnasEditable = doc2.getNumCols("Ruta3");
        int nFilasEditable = doc2.getNumFilas("Ruta3");
        
         System.out.println("Numero de columna de la pagina2: "+nColumnasEditable);
        System.out.println("Numero de filas de la pagina2: "+nFilasEditable);
        System.out.println("*************************************");

        
        for(celda=0;celda<=nColumnasEditable;celda++){

            
            for(fila=0;fila<=nFilasEditable;fila++){
                
              String dato = doc2.getDato(fila, celda);
               
             
               
                   if(isNumeric(dato)==true){
                       
                       ruta2.setDistanciaReal(Float.valueOf(dato));
                       System.out.println("Distancia : "+dato);
                   } else if(isNumeric(dato)==false && !dato.equals("")){
                       
                       ruta2.setDescripcion(dato);
                       System.out.println("Descripcion: "+dato);
                   }   else{
                      
                   }            
                
                
                 
                 ruta.setDescripcion(doc2.getDato(fila, celda));
               

            }
            
            
        }

    
        doc2.escribir();
        doc2.cerrar();  
    }
    
    
    public static boolean isNumeric(String str) {
    try {
        double d = Double.parseDouble(str);
    } catch (NumberFormatException nfe) {
        return false; //Error no es numerico
    }
    return true; //Es numerico
}

 
}

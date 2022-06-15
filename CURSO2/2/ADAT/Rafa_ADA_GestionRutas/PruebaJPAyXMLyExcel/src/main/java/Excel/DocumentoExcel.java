/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import java.io.File;
import java.util.Locale;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.biff.CountryCode;

/**
 *
 * @author rafa
 */
public class DocumentoExcel {
    
    private Workbook archivoExcel;
    private Sheet hoja;
  
    public DocumentoExcel(String archivo){
       try {
           //configuración básica
                WorkbookSettings wbSettings = new WorkbookSettings();
                wbSettings.setEncoding("ISO-8859-1");
                wbSettings.setLocale(new Locale("es", "ES"));
                wbSettings.setExcelDisplayLanguage("ES");
                wbSettings.setExcelRegionalSettings("ES");
                wbSettings.setCharacterSet(CountryCode.SPAIN.getValue());
                
                archivoExcel = Workbook.getWorkbook(new File(archivo),wbSettings);
             
            
                
        } catch (Exception ex) {
            System.out.println(ex);
        } 
      
}

    
   
   public int getNumeroHojas(){
       return archivoExcel.getNumberOfSheets();
   }
   public Sheet getHojaActual(){
       return hoja;
   }
   public String getNombreHoja(int n){
       return archivoExcel.getSheet(n).getName();
   }
    public String getNombreHojaActual(){
       return hoja.getName();
   }
   public int getNumFilasActual(){
       
       return hoja.getRows();
   }
   public int getNumColsActual(){
       
       return hoja.getColumns();
   }
   public int getNumFilas(String nombre){
       return archivoExcel.getSheet(nombre).getRows();
   }
   public int getNumCols(String nombre){
       return archivoExcel.getSheet(nombre).getColumns();
   }
   public int getNumFilas(int n){
       return archivoExcel.getSheet(n).getRows();
   }
   public int getNumCols(int n){
       return archivoExcel.getSheet(n).getColumns();
   }
   public void setHojaActual(int numero){
       
        hoja = archivoExcel.getSheet(numero); 
        
   }
   public void setHojaActual(String nombre){
       
        hoja = archivoExcel.getSheet(nombre); 
   }
   public String getDato(int h, int fila, int columna){
    
      return archivoExcel.getSheet(h).getCell(columna, fila).getContents();
     
      
   } 
   public String getDato(String nombre, int fila, int columna){
       return archivoExcel.getSheet(nombre).getCell(columna, fila).getContents();
   } 
   public String getDato( int fila, int columna){
       return hoja.getCell(columna, fila).getContents();
   } 
}

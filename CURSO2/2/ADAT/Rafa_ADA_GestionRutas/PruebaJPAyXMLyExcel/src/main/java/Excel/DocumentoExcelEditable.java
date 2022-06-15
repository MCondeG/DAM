/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Excel;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.biff.CountryCode;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author rafa
 */
public class DocumentoExcelEditable {
     
    private WritableWorkbook copia;
    private Workbook archivoExcel;
    private WritableSheet hoja;
    private WritableFont  formatoFuente;
    private WritableCellFormat formatoCelda;
    private NumberFormat formatoNumero;

  
    
    public DocumentoExcelEditable(String archivo){
       try {
           //configuración básica
              WorkbookSettings wbSettings = new WorkbookSettings();
              wbSettings.setEncoding("ISO-8859-1");
              wbSettings.setLocale(new Locale("es", "ES"));
              wbSettings.setExcelDisplayLanguage("ES");
              wbSettings.setExcelRegionalSettings("ES");
              wbSettings.setCharacterSet(CountryCode.SPAIN.getValue());
                
              archivoExcel = Workbook.getWorkbook(new File(archivo),wbSettings);
               // se leera y escribira en todo momento sobre la copia
              copia = Workbook.createWorkbook(new File("src/editable.xls"), archivoExcel); 
  
                // formato por defecto
              formatoFuente = new WritableFont(WritableFont.ARIAL,10, WritableFont.BOLD);
              formatoCelda = new WritableCellFormat(formatoFuente);
              formatoCelda.setWrap(true);
              formatoNumero = new NumberFormat("#.###");
                
        } catch (Exception ex) {
            System.out.println(ex);
        } 
      
}
   public void crearArchivoEditable(){
   }
   
   public void crearHoja(String nombre){
       hoja=copia.createSheet(nombre, 0);
   }
   public void setHojaActual(int numero){
       
        hoja = copia.getSheet(numero); 
        
   }
   public void setHojaActual(String nombre){
       
        hoja = copia.getSheet(nombre); 
   }
   
   public void escribir(){
       try {
            copia.write();
        } catch (IOException ex) {
            System.out.println(ex);
        }
   }
   public void cerrar(){
        try {
            copia.close();
        } catch (IOException ex) {
           System.out.println(ex);
        } catch (WriteException ex) {
           System.out.println(ex);
        }
   }
   
   public int getNumeroHojas(){
       return copia.getNumberOfSheets();
   }
   public WritableSheet getHojaActual(){
       return hoja;
   }
   public String getNombreHoja(int n){
       return copia.getSheet(n).getName();
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
       return copia.getSheet(nombre).getRows();
   }
   public int getNumCols(String nombre){
       return copia.getSheet(nombre).getColumns();
   }
   public int getNumFilas(int n){
       return copia.getSheet(n).getRows();
   }
   public int getNumCols(int n){
       return copia.getSheet(n).getColumns();
   }
   
   public void insertarEtiqueta(int col, int fila, String dato){
       
       Label contenido = new Label(col,fila, dato, formatoCelda);
       try {
            hoja.addCell(contenido);
        } catch (WriteException ex) {
            System.out.println(ex);
        }
         
       
   }
   public void insertarFormula(int col, int fila, String dato){
       
       Formula contenido = new Formula(col,fila, dato);
       try {
            hoja.addCell(contenido);
        } catch (WriteException ex) {}
       
   }
   public void insertarNumero(int col, int fila, double numero){
//        WritableCellFormat formato = new WritableCellFormat(formatoNumero);
//        Number n = new Number(col,fila,numero,formato);
          jxl.write.Number n = new jxl.write.Number(col,fila,numero);
         try {
            hoja.addCell(n);
        } catch (WriteException ex) {}
   }
    
   public String getDato(int h, int c, int f){
       return copia.getSheet(h).getCell(c, f).getContents();
   } 
   public String getDato(String nombre, int c, int f){
       return copia.getSheet(nombre).getCell(c, f).getContents();
   } 
   public String getDato(int c, int f){
       return hoja.getCell(c, f).getContents();
   } 
}

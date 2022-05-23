package com.example.examenRec.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface IDaoProducto {

    @Query("SELECT * FROM producto WHERE idProducto LIKE :idProducto")
    public Producto getProductoID(int idProducto);
    @Query("SELECT precio FROM producto WHERE idProducto LIKE :idProducto")
    int getPrecioProId(int idProducto);

    @Query("SELECT * FROM producto")
    public  List<Producto> getProductos();
    @Insert
    public void insertarProducto(Producto producto);
    @Delete
    public void borrarProducto(Producto producto);
    @Update
    public void editarProducto(Producto producto);

    @Query("DELETE FROM producto")
    public void borrarTabla();


    /*public long crearProducto(Producto productoSQLite) {

        long idAlimento = 0;

        try {
            GestionBD gestionBD = new GestionBD(this.context);
            SQLiteDatabase db = gestionBD.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", alimentoSQLite.getNombre());
            values.put("grprot", alimentoSQLite.getGrprot());
            values.put("grgrasa", alimentoSQLite.getGrgrasa());
            values.put("grhidratos", alimentoSQLite.getGrhidratos());

            idAlimento = db.insert(TABLA_ALIMENTO, null, values);
        } catch (Exception ex) {
            ex.toString();
        }

        return idAlimento;
    }
    */


}

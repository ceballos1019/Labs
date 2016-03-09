package co.edu.udea.compumovil.gr8.lab2apprun;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Sergio on 08/03/2016.
 */
public class ConexionBD {

    private SQLiteDatabase db;
    private Context nContext;
    private MyDBHandler handler;


    //Constructor de la Clase
    //Recibe como parámetro una variable de Tipo contexto
    // Esto debido a que Para acceder o crear la BD lo pide la Clase SQLiteOpenHelper

    public ConexionBD(Context c){
        nContext=c;

    }

    public void abrirConexion() {
        handler =new MyDBHandler(nContext );
        db=handler.getWritableDatabase();

    }

    public void cerrarConexion(){
        handler.close();
    }

    public void insertar(String nombre, String contraseña){
        ContentValues values= new ContentValues();
        values.put(handler.COLUMN_USUARIO,nombre);
        values.put(handler.COLUMN_CONTRASEÑA,contraseña);
        db.insert(handler.TABLA_USUARIOS,null,values);
        }

}



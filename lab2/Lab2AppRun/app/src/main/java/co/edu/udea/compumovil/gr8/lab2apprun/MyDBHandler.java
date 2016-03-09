package co.edu.udea.compumovil.gr8.lab2apprun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Sergio on 08/03/2016.
 */
public class MyDBHandler extends SQLiteOpenHelper  {

//informacion de la base de datos
public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "CarrerasDB.db";
    public static final String TABLA_USUARIOS = "usarios";

    //informacion de la tabla
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USUARIO = "usuario";
    public static final String COLUMN_CONTRASEÑA = "contraseña";

    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USUARIOS_TABLA = "CREATE TABLE " +
                TABLA_USUARIOS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + COLUMN_USUARIO
                + " TEXT," + COLUMN_CONTRASEÑA  + " TEXT" + ")";
        db.execSQL(CREATE_USUARIOS_TABLA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLA_USUARIOS);
        onCreate(db);


       }

}

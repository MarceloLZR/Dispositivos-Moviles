package com.example.mycontactos20232;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.jetbrains.annotations.Nullable;

public class ConexionSqlite extends SQLiteOpenHelper {
    public ConexionSqlite(@Nullable Context context){
        super(context,"MICONTACTOBD",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql ="CREATE TABLE contacto(idcontacto INTEGER, nombre text,alias text,tipo INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS contacto";
        db.execSQL(sql);
        onCreate(db);
    }
    public void insertarContacto(Contacto c){
        String sql = "INSERT INTO contacto(idcontacto,nombre,alias,tipo) VALUES('"+c.getIdcontacto()+"','"+c.getNombre()+"','"+c.getAlias()+"','"+c.getTipo()+"')";
        this.getWritableDatabase().execSQL(sql);
    }
    public void eliminarContacto(int idcontacto){
        String sql = "DELETE FROM contacto where idcontacto='"+idcontacto+"'";
        this.getWritableDatabase().execSQL(sql);
    }
    public void editarContacto(Contacto c, String nombreX, String aliasX, int tipoX) {
        String sql = "UPDATE contacto SET nombre = '" + nombreX + "', alias = '" + aliasX + "', tipo = " + tipoX + " WHERE idcontacto = " + c.getIdcontacto();
        this.getWritableDatabase().execSQL(sql);
    }
    public void listarContacto(){
        SQLiteDatabase db = this.getReadableDatabase();
        String columas[] = {"idcontacto","nombre","alias","tipo"};
        Cursor cursor = db.query("contacto",columas,null,null,null,null,null);
        MainActivity.miscontactos.clear();
        MainActivity.contador = 0;
        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            int idcontacto = cursor.getInt(0);
            String nombre = cursor.getString(1);
            String alias = cursor.getString(2);
            int tipo = cursor.getInt(3);
            MainActivity.miscontactos.add(new Contacto(idcontacto,nombre,alias,tipo));
            MainActivity.contador++;
        }
    }
}

package com.example.ejemplobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ClientesSQLiteHelper extends SQLiteOpenHelper{
	
	String cadSQL="CREATE TABLE Clientes(codigo INTEGER,nombre TEXT, telefono TEXT)";
	
	public ClientesSQLiteHelper(Context contexto, String nombre, CursorFactory almacen, int version){
		super(contexto,nombre,almacen,version);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd){
		
		bd.execSQL(cadSQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva){
		bd.execSQL("DROP TABLE IF EXISTS Clientes");
		bd.execSQL(cadSQL);
	}
}

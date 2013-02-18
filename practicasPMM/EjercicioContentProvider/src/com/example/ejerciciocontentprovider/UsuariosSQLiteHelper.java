package com.example.ejerciciocontentprovider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class UsuariosSQLiteHelper extends SQLiteOpenHelper {

	String cadSQL = "CREATE TABLE Clientes (codigo INTEGER,nombre TEXT,telefono TEXT)";

	public UsuariosSQLiteHelper(Context context, String name,
			CursorFactory almacen, int version) {
		super(context, name, almacen, version);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase bd) {
		bd.execSQL(cadSQL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase bd, int versionAnterior, int versionNueva) {
		// TODO Auto-generated method stub
		
		//Eliminamos la versión anterior de la tabla
		bd.execSQL("DROP TABLE IF EXISTS Clientes");
		
		//Creamos la nueva versión de la tabla
		bd.execSQL(cadSQL);
		
	}

	
	

}
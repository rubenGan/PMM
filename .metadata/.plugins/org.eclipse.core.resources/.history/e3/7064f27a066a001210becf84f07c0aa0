package com.example.ejemplobd;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

public class EjemploBD extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejemplo_bd);
		
		ClientesSQLiteHelper cliBDh = new ClientesSQLiteHelper(this,"DBClientes",null,1);
		
		SQLiteDatabase bd =cliBDh.getWritableDatabase();
		
		if(bd!=null){
			for (int cont=1;cont<=3;cont++){
				int codigo=cont;
				String nombre="Cliente "+cont;
				String telefono=cont+" XXXXXXX";
				
				bd.execSQL("INSERT INTO Clientes(codigo,nombre,telefono) VALUES("+codigo+",'"+nombre+"','"+telefono+"')");
			}
			bd.close();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ejemplo_bd, menu);
		return true;
	}

}

package com.example.ejerciciocontentprovider;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class EjerContentProvider extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ejer_content_provider);
		ListView listView = (ListView)findViewById(R.id.listView);
		ArrayList datos = new ArrayList();
		ArrayAdapter<String> adaptador;
		String usuario;
		Cursor c;
		final int TEXTO_ENVIADO = 0;
		final TextView recogeDatos =(TextView)findViewById(R.id.textRecoge);
		
		
		//abrimos la base de datos en modo escritura
				UsuariosSQLiteHelper cliBDh = new UsuariosSQLiteHelper(this,"DBClientes",null,1);
				
				//Obtenemos referencia a la base de datos para poder modificarla
				SQLiteDatabase bd = cliBDh.getWritableDatabase();
				
				//En caso de que abra de forma correcta la bd
				if(bd!=null)
				{
					//introducimos tres clientes de ejemplo
					for(int cont=0; cont<=2;cont++)
					{
						//creamos los datos
						int codigo = cont;
						String nombre = "Cliente" + cont;
						String telefono = cont + "0000000";
						
						//Introducimos los datos en la tabla clientes
						//bd.execSQL("INSERT INTO Clientes(codigo, nombre, telefono)"+ "VALUES ("+codigo+",'"+nombre+"','"+telefono+"')");
						
						
					}
					
					bd.close();
					
					bd = cliBDh.getReadableDatabase();
					
					 adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
					listView.setAdapter(adaptador);

					String[] args = new String[]{"Cliente1"};
					
					c = bd.rawQuery("SELECT codigo,nombre,telefono FROM Clientes",null );
					if(c.moveToFirst())
					{
						do{
							usuario = c.getString(1);
														
							adaptador.add(c.getString(1));
						
							
						}while(c.moveToNext());
						
							
						bd.close();
						 
						
					}
							
			
	}
		
		 listView.setOnItemClickListener(new OnItemClickListener() {

	            @Override

	            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
	            	
	            	
	            Toast.makeText(a.getContext(), " opcion seleccionada es: " +a.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
	            Intent intent = new Intent (getApplicationContext(),ModificarDatos.class );
	            intent.putExtra("seleccion", a.getItemAtPosition(position).toString());
	            startActivityForResult(intent,TEXTO_ENVIADO);
	            }

	            protected void onActivityResult(int codigoEnviado,int codigoResultado, Intent datos){
	        		if(codigoEnviado == TEXTO_ENVIADO)
	        		{
	        			if(codigoResultado == Activity.RESULT_OK)
	        			{
	        				Bundle extras = getIntent().getExtras();
	        				if(extras!=null){
	        					recogeDatos.setText( extras.getString("modificado"));
	        				}
	        			}
	        		}
	        		
	        	}
	        });
	
}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_ejer_content_provider, menu);
		return true;
	}

}

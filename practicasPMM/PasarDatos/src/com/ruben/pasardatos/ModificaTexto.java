package com.ruben.pasardatos;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ModificaTexto extends Activity
{
	EditText editText;
	Button btnCambiar;
	Button btnCancelar;	
	Spinner spinner;
	String nombreCli = null ;		
	Cursor c;
	
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.modificatexto);
		
		editText = (EditText)findViewById(R.id.editText);
		editText.setText(this.getIntent().getExtras().getString("texto"));
		btnCambiar = (Button)findViewById(R.id.btnAceptar);
		btnCancelar = (Button)findViewById(R.id.btnCancelar);
		
		spinner = (Spinner)findViewById(R.id.spinnerDatos);
		
		ArrayAdapter adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		
		
		//abrimos la base de datos en modo escritura
		ClientesSQLHelper cliBDh = new ClientesSQLHelper(this,"DBClientes",null,1);
		
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
				bd.execSQL("INSERT INTO Clientes(codigo, nombre, telefono)"+ "VALUES ("+codigo+",'"+nombre+"','"+telefono+"')");
				
				
			}
			
			bd.close();
			
			bd = cliBDh.getReadableDatabase();
			
			
			String[] args = new String[]{"Cliente1"};
			//Cursor c = db.rawQuery("SELECT cliente,telefono FROM Clientes WHERE cliente=?",args);
			c = bd.rawQuery("SELECT codigo,nombre,telefono FROM Clientes",null );
			if(c.moveToFirst())
			{
				do{
					nombreCli = c.getString(1);					
				adapter.add(c.getString(1));
					
					
				}while(c.moveToNext());
				
					
				bd.close();
				
			}
		
		}
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView, View v,
					int posicion, long id) {
				
				// TODO Auto-generated method stub
				
				 
                Toast.makeText(parentView.getContext(), "Has seleccionado "+parentView.getItemAtPosition(posicion).toString(), Toast.LENGTH_LONG).show();
			 
				editText.setText(parentView.getItemAtPosition(posicion).toString());
				
				
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnCambiar.setOnClickListener(new OnClickListener(){
		public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentSubActi1 = new Intent(ModificaTexto.this,ModificaTexto.class);
				intentSubActi1.putExtra("texto", editText.getText());
				setResult(Activity.RESULT_OK,intentSubActi1);
				ModificaTexto.this.finish();
				
			}
			
		});
		
		btnCancelar.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intentSubActi2 = new Intent(ModificaTexto.this,ModificaTexto.class);
				intentSubActi2.putExtra("texto", editText.getText());
				setResult(Activity.RESULT_CANCELED,intentSubActi2);
				ModificaTexto.this.finish();
				
				
			}
			
		});
		
	}

}

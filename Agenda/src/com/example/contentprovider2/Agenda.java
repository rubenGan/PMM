package com.example.contentprovider2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Agenda extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda);
		Button btnConsultar=(Button)findViewById(R.id.BtnConsultar);
		Button btnInsertar=(Button)findViewById(R.id.BtnInsertar);
		Button btnEliminar=(Button)findViewById(R.id.BtnEliminar);
		Button btnLlamadas=(Button)findViewById(R.id.BtnLlamadas);
		final TextView txtResultados=(TextView)findViewById(R.id.TxtResultados);
		
		final ListView listView=(ListView)findViewById(R.id.listWiev1);
		 final ArrayAdapter<String> adaptador;
		 final ArrayList datos;
		 datos = new ArrayList();
		 adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, datos);
		
		btnConsultar.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				//Columnas de la tabla a recuperar
				String[]proyeccion=new String[]{"_id","usuario","password","email"};
				//Incorporamos el URI al que queremos acceder
				String uri="content://org.ejemplo.aguilar.EjemploContentProvider/usuarios";
				Uri usuariosUri=Uri.parse(uri);
				Log.e("contentProvider2","LLEGAMOS");
				
				datos.clear(); 
				//Obtenemos una referencia al content provider al que queremos acceder
				ContentResolver cr=getContentResolver();
				//Hacemos la consulta
				Cursor cur=cr.query(usuariosUri,proyeccion,null,null,null);
							//columnas a devolver,where del query, argumentos variables, order by
				
				if(cur.moveToFirst()){
					String usuario,password,email;
					int colUsuario=cur.getColumnIndex("usuario");
					int colPassword=cur.getColumnIndex("password");
					int colEmail=cur.getColumnIndex("email");
					
					txtResultados.setText("");
					
					
					do{
						usuario=cur.getString(colUsuario);
						password=cur.getString(colPassword);
						email=cur.getString(colEmail);
						//txtResultados.append(usuario+" -"+password+" - "+email+"\n");
						datos.add(usuario+" -"+password+" - "+email+"\n");
						listView.setAdapter(adaptador);
					}while(cur.moveToNext());
					
					
				}
			}
		});
		
		btnInsertar.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0){
				//Creamos los datos de un usuario nuevo
				ContentValues values=new ContentValues();
				values.put("usuario","UsuarioN");
				values.put("password","PasswordXXX");
				values.put("email", "nuevo@cefire.com");
				
				//Incorporamos el URI al que queremos acceder
				String uri="content://org.ejemplo.aguilar.EjemploContentProvider/usuarios";
				Uri usuariosUri=Uri.parse(uri);
				//Obtenemos una referencia al content provider al que queremos acceder
				ContentResolver cr=getContentResolver();
				
				//Insertamos un nuevo usuario
				cr.insert(usuariosUri, values);					
				
			}
		});
		btnEliminar.setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View arg0){
				//Incorporamos el URI al que querremos acceder
				String uri="content://org.ejemplo.aguilar.EjemploContentProvider/usuarios";
				Uri usuariosUri=Uri.parse(uri);
				//Obtenemos una referencia al content provider al que queremos acceder
				ContentResolver cr=getContentResolver();
				
				//Eliminamos el usuario introducido con el botón Insertar
				cr.delete(usuariosUri,"usuario"+" = 'UsuarioN'",null);
				
			}
			
		});
		
		btnLlamadas.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View arg0){
				//Columnas que queremos recuperar
				String[]proyeccion=new String[]{Calls.TYPE,Calls.NUMBER};
				
				//URI a la que queremos acceder. En este caso es la del historial de llamadas
				Uri llamadasUri = Calls.CONTENT_URI;
				//Referencia al content provider al que queremos acceder
				ContentResolver cr=getContentResolver();
				Cursor cur=cr.query(llamadasUri, proyeccion, null, null,null);
					//columnas a devolver,where del query,argumentos variables, order by
				if(cur.moveToFirst()){
					int tipo, colTipo=cur.getColumnIndex(Calls.TYPE),colTelefono=cur.getColumnIndex(Calls.NUMBER);
					String tipoLlamada="",telefono;
					txtResultados.setText("");
					datos.clear();
					do{
						tipo=cur.getInt(colTipo);
						telefono=cur.getString(colTelefono);
						
						if(tipo==Calls.INCOMING_TYPE)
							tipoLlamada="ENTRADA";
						else if(tipo==Calls.OUTGOING_TYPE)
							tipoLlamada="SALIDA";
						else if(tipo==Calls.MISSED_TYPE)
							tipoLlamada="PERDIDA";
						
						//txtResultados.append(tipoLlamada+" - "+telefono+"\n");
						datos.add(tipoLlamada+" - "+telefono+"\n");
						listView.setAdapter(adaptador);
					}while(cur.moveToNext());
					
				}
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_agenda, menu);
		return true;
	}

}

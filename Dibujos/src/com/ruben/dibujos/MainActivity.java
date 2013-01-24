package com.ruben.dibujos;

import com.ruben.dibujos.R;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	static Button botonCalcular;	
	static TextView labelCirculo;
	static TextView labelCirculo2;
	static EditText editTextCirculo;
	static TextView labelCuadrado;
	static TextView labelCuadrado2;
	static EditText editTextCuadrado;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	
		botonCalcular=(Button)findViewById(R.id.botonCalcular);		
		labelCirculo = (TextView)findViewById(R.id.labelCirculo);	
		labelCirculo2 = (TextView)findViewById(R.id.labelCirculo2);
		editTextCirculo = (EditText)findViewById(R.id.editTextCirculo);		
		labelCuadrado = (TextView)findViewById(R.id.labelCuadrado);	
		labelCuadrado2 = (TextView)findViewById(R.id.labelCuadrado2);	
		editTextCuadrado = (EditText)findViewById(R.id.editTextCuadrado);
	
		Spinner spinnerFiguras = (Spinner)findViewById(R.id.spinnerFiguras);
		final String[] datosSpinner = new String[]{"Cuadrado", "Circulo"};
		
		ArrayAdapter<String> adaptador = new ArrayAdapter<String>
        (this, android.R.layout.simple_spinner_item, datosSpinner);
		
		adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinnerFiguras.setAdapter(adaptador);

	
		spinnerFiguras.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				
				String spinnerCadena = datosSpinner[position];

			 if(spinnerCadena.equals("Circulo")){
					
									
					labelCuadrado.setVisibility(View.INVISIBLE);
					labelCuadrado2.setVisibility(View.INVISIBLE);
					editTextCuadrado.setVisibility(View.INVISIBLE);
					
					
					botonCalcular.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							Intent intent = new Intent(MainActivity.this, DibujaArea.class);
				
							Bundle bundle = new Bundle();
							bundle.putString("CIRCULO", editTextCirculo.getText().toString());
							intent.putExtras(bundle);
							
							startActivity(intent);
						}
						
					});
				}else{
									
					labelCirculo.setVisibility(View.INVISIBLE);
					labelCirculo2.setVisibility(View.INVISIBLE);
					editTextCirculo.setVisibility(View.INVISIBLE);
				
					
					
					botonCalcular.setOnClickListener(new OnClickListener(){

						@Override
						public void onClick(View arg0) {
							Intent intent = new Intent(MainActivity.this, DibujaArea.class);
				
							Bundle bundle = new Bundle();
							bundle.putString("CUADRADO", editTextCuadrado.getText().toString());
							intent.putExtras(bundle);
							
							startActivity(intent);
						}
						
					});
					
				}

				
				
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

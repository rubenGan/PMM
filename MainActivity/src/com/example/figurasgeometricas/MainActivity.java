package com.example.figurasgeometricas;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button btnRect,btnCirc,btnTri;
	private TextView texto;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnRect= (Button)findViewById(R.id.btnRect);
		texto=(TextView)findViewById(R.id.textView1);
		
		btnRect.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				Intent intent1 = new Intent(MainActivity.this, Rectangulo.class);
				startActivity(intent1);
			}
		});
		btnCirc=(Button)findViewById(R.id.btnCirc);
		btnCirc.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				Intent intent2 = new Intent(MainActivity.this, Circulo.class);
				startActivity(intent2);
			}
		});
		btnTri=(Button)findViewById(R.id.btnTri);
		btnTri.setOnClickListener(new View.OnClickListener() {		
			public void onClick(View v) {
				Intent intent3 = new Intent(MainActivity.this, Triangulo.class);
				startActivity(intent3);
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

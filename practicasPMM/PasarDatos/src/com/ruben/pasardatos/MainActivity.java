package com.ruben.pasardatos;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final int CODIGO_TEXTO = 0;
	TextView txtCambiado;
	Button btnCambiaTexto;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		txtCambiado = (TextView) findViewById(R.id.textView);
		btnCambiaTexto = (Button)findViewById(R.id.btnCambiaTexto);
		
		btnCambiaTexto.setOnClickListener(new OnClickListener(){
			public void onClick(View v)
			{
				Intent intent = new Intent(MainActivity.this,ModificaTexto.class);
				intent.putExtra("texto",txtCambiado.getText());
				MainActivity.this.startActivityForResult(intent,CODIGO_TEXTO);
			}
		});
	}
	
	protected void onActivityResult(int codigoEnviado,int codigoResultado, Intent intent){
		if(codigoEnviado == CODIGO_TEXTO)
		{
			if(codigoResultado == Activity.RESULT_OK)
			{
				txtCambiado.setText(intent.getExtras().get("texto").toString());
			}
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

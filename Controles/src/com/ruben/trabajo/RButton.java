package com.ruben.trabajo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RadioButton;

public class RButton extends Activity{
	
	RadioButton radioSoltero;
	RadioButton radioCasado;
	RadioButton radioOtro;
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rbutton);

		radioSoltero = (RadioButton) findViewById(R.id.radio0);
		radioCasado = (RadioButton) findViewById(R.id.radio1);
		radioOtro = (RadioButton) findViewById(R.id.radio2);
		
		
	}

}

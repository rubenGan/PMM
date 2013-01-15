package com.example.ejercicioexamen;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.CheckBox;

public class MainActivity extends Activity implements OnClickListener{

	EditText et;
	   
    public void onCreate(Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
    	
    	Spinner spinner = (Spinner)findViewById(R.id.spinner1);
       ArrayAdapter<CharSequence> adapter = ArrayAdapter.
        createFromResource(this, R.array.edad_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
          
    	et =  ((EditText)findViewById(R.id.editText1));
     	((Button)(findViewById(R.id.button1))).setOnClickListener(this);
       ((Button)(findViewById(R.id.button2))).setOnClickListener(this);
    }
    public void onClick(View v) {
      switch(v.getId()) {
	  case R.id.button1:	
	    String show = "";
	    show += ((EditText)findViewById(R.id.editText2)).getText();
	    String sexo = "hombre";
	    if(((RadioButton)findViewById(R.id.radio0)).isChecked())
	        sexo = "mujer";
	    show += " es "+sexo+" tiene ";
	  show += ((Spinner)findViewById(R.id.spinner1)).getSelectedItem()+" años y ";
	    		
	  String estudiante = "no es estudiante";
	  if(((CheckBox)findViewById(R.id.checkBox1)).isChecked())
	    	estudiante = "es estudiante";
	   show += estudiante;
	   et.setText(show);
	   break;
	    	
	   case R.id.button2:	
	    	 ((EditText)findViewById(R.id.editText2)).setText("");
	    	 ((CheckBox)findViewById(R.id.checkBox1)).setChecked(false);
	    	 ((Spinner)findViewById(R.id.spinner1)).setSelection(0);
	    	 ((RadioButton)findViewById(R.id.radio0)).setChecked(true);
	    	 et.setText("");
	    	break;   	
	  }// del switch
	}//metodo        }}
}
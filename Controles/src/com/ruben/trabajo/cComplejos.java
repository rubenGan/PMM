package com.ruben.trabajo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cComplejos extends Activity{
	
	
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ccomplejos);
       
        final Button boton1= (Button)findViewById(R.id.btnSpinner);
        final Button boton2= (Button)findViewById(R.id.btnLista);
       
        
        boton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				Intent intent1 = new Intent (cComplejos.this,CmbBox.class);
		    	startActivity(intent1);
		    	
		    	
		    	
			}
			
			
		});
        boton2.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v)
			{
        		Intent intent2 = new Intent (cComplejos.this,Listado.class);
        		startActivity(intent2);
			}
			
			
		});
    
        
        
        
        
    }

}



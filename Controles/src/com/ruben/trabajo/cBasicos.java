package com.ruben.trabajo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cBasicos extends Activity
{
	
	
	public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cbasicos);
       
        final Button btn1= (Button)findViewById(R.id.button1);
        final Button btn2= (Button)findViewById(R.id.button2);
        final Button btn3= (Button)findViewById(R.id.button3);
        
        btn1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v)
			{
				Intent intent1 = new Intent (cBasicos.this,CampoTexto.class);
		    	startActivity(intent1);
		    	
		    	
		    	
			}
			
			
		});
        btn2.setOnClickListener(new View.OnClickListener() {
        	public void onClick(View v)
			{
        		Intent intent2 = new Intent (cBasicos.this,CkBox.class);
        		startActivity(intent2);
			}
			
			
		});
        btn3.setOnClickListener(new View.OnClickListener() {
	        public void onClick(View v)
			{
	        	Intent intent3 = new Intent (cBasicos.this,RButton.class);
	        	startActivity(intent3);
			}
			
			
		});
        
        
        
        
    }

}

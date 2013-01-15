package com.example.figurasgeometricas;



import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Circulo extends Activity{
	
	private TextView texto, area;
	private EditText radio;
	double r;
	Paint pincel;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circulo);
        
        texto = (TextView)findViewById(R.id.textoCirculo);//pide el radio
        area = (TextView)findViewById(R.id.area);//resultado
        
       radio = (EditText)findViewById(R.id.radioCirculo);//introduce el radio.
            
    		 pincel = new Paint();
    		   pincel.setColor(Color.BLUE);
    		   pincel.setStrokeWidth(15);
    		   pincel.setStyle(Style.FILL);
    		   setContentView(R.layout.circulo);
      
       final Button  btnCalcularCirc = (Button)findViewById(R.id.btnCalcularCirc);
       btnCalcularCirc.setOnClickListener(new View.OnClickListener() { 
    	   @Override
			public void onClick(View arg0) 
			{
    		  
    			double resultado;
    		
    			
    			r = Double.parseDouble(radio.getText().toString());
    			
    			resultado = Math.PI*(r*r);
    		
    			area.setText("El área del círculo es: "+String.valueOf(resultado));
    	  
       }
    	
       });
     
	}
	
		public void onDraw(Canvas canvas){
			canvas.drawColor(Color.BLUE);
			canvas.drawCircle(50,80,(float) r,pincel);
			
		}
	}

	
	


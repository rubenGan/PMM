package com.ruben.dibujos;

import android.R.string;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

@SuppressLint("DrawAllocation")
public class DibujaArea extends MainActivity {
	Bundle bundle;
	
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
        TextView texto = new TextView(this);
        texto.setText("El area del " + " es:");
    }
    
    public class EjemploView extends View {
    	public EjemploView(Context contexto) {
    		super(contexto);
    		
  
    	}
    	@Override
    	protected void onDraw(Canvas canvas) {
    		int altura = getHeight() / 2;
			int ancho = getWidth() / 2;
			Paint pincel = new Paint();
			
			Paint pincelTexto = new Paint();
    		pincelTexto.setColor(Color.BLACK);
    		pincelTexto.setTextSize(20);
			
    		bundle = getIntent().getExtras();
    		
    		//como hago para comparar la clave, no el valor, del bundle que pasa la informacion de una pantalla a otra.
    		if(bundle.getString("CIRCULO") != null){
    			
    			int medidas = Integer.parseInt(bundle.getString("CIRCULO"));
    			int totalMedida = medidas * 10;
        		pincel.setColor(Color.BLUE);
        		pincel.setStrokeWidth(20);
        		pincel.setStyle(Paint.Style.FILL);
        		canvas.drawCircle(ancho,altura,medidas,pincel);
        		
        		
        		
        		int radioCuadrado = medidas * medidas;
        		double producto = ( Math.PI * radioCuadrado);
        		String area = "El area total del circulo es: "  +producto;
        		canvas.drawText(area, 100, 350, pincelTexto);
    			
        		
        		
    		}else{
    			int lado = Integer.parseInt(bundle.getString("CUADRADO"));
    			
    			pincel.setColor(Color.BLUE);
        		pincel.setStrokeWidth(20);
        		pincel.setStyle(Paint.Style.FILL);
        		canvas.drawRect(altura, ancho +lado, altura + lado, ancho, pincel);
        	
        		
        		int producto = lado * lado;
        		String area = "El area total del cuadrado es: " + producto;
        		canvas.drawText(area, 100, 350, pincelTexto);
    		}
    		
    	}
    }
}
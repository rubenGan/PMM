package juego.solobici;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class Solobici extends Activity {

	private Button bAcercaDe;
	private Button bJuego;
	private Button bPreferencias;
	private Button bOtenerPreferencias;
	private Button bSalir;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        //Botón y escuchador para la pantalla "Acerca de"
        //Al hacer click en este botón llamamos al método lanzarAcercaDe()
        bAcercaDe = (Button) findViewById(R.id.Boton03);
        bAcercaDe.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarAcercaDe();
        	}
        });

        //Botón y escuchador para la pantalla "Juego"
        //Al hacer click en este botón llamamos al método lanzarJuego()
        bJuego = (Button) findViewById(R.id.Boton01);
        bJuego.setOnClickListener(new OnClickListener(){
        	public void onClick(View view) {
        		lanzarJuego();
        	}
        });
        bPreferencias =(Button)findViewById(R.id.Boton02);
        bOtenerPreferencias =(Button)findViewById(R.id.MnuOpc1);
        
      }
    
    
    public boolean onCreateOptionsMenu(Menu menu){
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.main,menu);
    	return true;
    }
    //Método que activa la pantalla AcercaDe
    public void lanzarAcercaDe(){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }

   //Método que activa la pantalla Juego
    public void lanzarJuego(){
    	Intent i = new Intent(this, Juego.class);
    	startActivity(i);
    }

   
        
         // Resto de Botones
    
    }

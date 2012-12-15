package com.example.examen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.MnuOpc1:
           
            return true;
        case R.id.MnuOpc2:
        	lanzarAcercaDe();
        
            return true;
        
    default:
        return super.onOptionsItemSelected(item);
        }
    }
    
  //Método que activa la pantalla AcercaDe
    public void lanzarAcercaDe(){
    	Intent i = new Intent(this, AcercaDe.class);
    	startActivity(i);
    }
    
}

package com.ruben.trabajo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends Activity {

   

    public boolean onCreateOptionsMenu(Menu menu) {
    	
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.activity_main, menu);
    	return true;
    	}

    public boolean onOptionsItemSelected(MenuItem item) {
    	switch (item.getItemId()) {
    	case R.id.MnuOpc1:
    		Intent intent1 = new Intent (MainActivity.this,cBasicos.class);
    		startActivity(intent1);
    		return true;
    	
    	case R.id.MnuOpc2:
    		Intent intent2 = new Intent (MainActivity.this,cComplejos.class);
    		startActivity(intent2);
    		return true;
    	case R.id.MnuOpc3:
    		Intent intent3 = new Intent (MainActivity.this,acercaDe.class);
    		startActivity(intent3);
    	return true;
    	default:
    	return super.onOptionsItemSelected(item);
    	}}

   
}

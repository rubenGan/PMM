package net.sgoliver;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Estadisticas extends Activity 
{
	
	private EditText etq1;
	private EditText etq2;
	private EditText etq3;
	

	public void onCreate(Bundle saveInstance)
	{
		super.onCreate(saveInstance);
		setContentView(R.layout.estadisticas);
		
		etq1 = (EditText)findViewById(R.id.LblMensaje1);
		etq2 = (EditText)findViewById(R.id.LblMensaje2);
		etq3 = (EditText)findViewById(R.id.LblMensaje3);
		
		
        Bundle bundle = getIntent().getExtras();
        
        String str1 = bundle.getString("str1");
        String str2 = bundle.getString("str2");
        String str3 = bundle.getString("str3");
        
        etq1.setText(str1);
        etq2.setText(str2);
        etq3.setText(str3);
	}
	

	
	
	
	
	
	
	
	
	
	
	
}

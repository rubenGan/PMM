package com.example.ejerciciocontentprovider;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ModificarDatos extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.modificardatos);
final EditText editText = (EditText)findViewById(R.id.editText);
TextView textView =(TextView)findViewById(R.id.textView1);
Button btnCambiar=(Button)findViewById(R.id.btnCambiar);
Button btnCancel=(Button)findViewById(R.id.btnCancel);

Bundle extras = getIntent().getExtras();
if(extras!=null){
	editText.setText( extras.getString("seleccion"));
}


btnCambiar.setOnClickListener(new OnClickListener(){
	
	@Override
	public void onClick(View arg0){
		Intent intentSubActi1 = new Intent(ModificarDatos.this,EjerContentProvider.class);
		intentSubActi1.putExtra("modificado", editText.getText());
		setResult(Activity.RESULT_OK,intentSubActi1);
		ModificarDatos.this.finish();
	}
	
});








btnCancel.setOnClickListener(new OnClickListener(){

	@Override
	public void onClick(View arg0) {
		
		Intent intentSubActi2 = new Intent(ModificarDatos.this,ModificarDatos.class);
		intentSubActi2.putExtra("seleccion", editText.getText());
		setResult(Activity.RESULT_CANCELED,intentSubActi2);
		ModificarDatos.this.finish();
		
		
	}
	
});
	}

}

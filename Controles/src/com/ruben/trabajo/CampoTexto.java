package com.ruben.trabajo;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CampoTexto extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.campotexto);
        
        final EditText txtTexto = (EditText)findViewById(R.id.TxtTexto);
        
        final Button btnNegrita = (Button)findViewById(R.id.BtnNegrita);
        btnNegrita.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0)
			{
				Spannable texto = txtTexto.getText();
			
				int ini = txtTexto.getSelectionStart();
				int fin = txtTexto.getSelectionEnd();
				
				texto.setSpan(
						new StyleSpan(android.graphics.Typeface.BOLD), 
						ini, fin, 
						Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
			}
		});
        
        final Button btnSetText = (Button)findViewById(R.id.BtnSetText);
        btnSetText.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0)
			{
				Editable str = Editable.Factory.getInstance().newEditable("Esto es un simulacro.");
				str.setSpan(new StyleSpan(android.graphics.Typeface.BOLD), 11, 20, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
				txtTexto.setText(str);
				
				
			}
		});
    }
}
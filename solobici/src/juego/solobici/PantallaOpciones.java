package juego.solobici;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PantallaOpciones extends PreferenceActivity{
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.opciones);
	}

}

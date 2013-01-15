package net.sgoliver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class DemoListView extends Activity {

    private Titular[] datos = new Titular[4];
    private Button btn;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        btn = (Button)findViewById(R.id.button1);
        
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DemoListView.this, Estadisticas.class);
				
				String[] nombres = DemoListView.this.Operaciones();
				
				intent.putExtra("str1", nombres[0]);
				intent.putExtra("str2", nombres[1]);
				intent.putExtra("str3", nombres[2]);
				
				startActivity(intent);
				
			}
		});
        
        datos [0] = new Titular("Pablo", "Maroto", 20);
        datos [1] = new Titular("Irene", "Fernandez", 25);
        datos [2] = new Titular("Pepe", "González", 17);
        datos [3] = new Titular("Andrea", "Martínez", 67);
        
      
        AdaptadorTitulares adaptador = 
        	new AdaptadorTitulares(this);
        
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        
        lstOpciones.setAdapter(adaptador);
    }
    
	private String[] Operaciones()
	{
		 int max=Integer.MIN_VALUE;
		 int maxindex = -1;
		 
		 int min=Integer.MAX_VALUE;
		 int minindex = -1;
		 
		 float avg=0;
		
		for(int i=0; i<datos.length; i++)
		{			
			// máximo
			if(datos[i].getEdad() > max)
			{
				max=this.datos[i].getEdad();
				maxindex = i;
			}
			
			// mínimo
			if(datos[i].getEdad() < min)
			{
				min=this.datos[i].getEdad();
				minindex = i;
			}
			
			// media 
			avg += this.datos[i].getEdad();
			
		}
		
		// calculamos la media
		avg = avg /( (float)this.datos.length);
		
		
		String Min = "El menor es: " + this.datos[minindex].toString();
		String Max = "El mayor es: " + this.datos[maxindex].toString();
		String Med = "La media de edad es: " + avg;
		
		return new String[]{Min, Max, Med};
	}
    
    class AdaptadorTitulares extends ArrayAdapter {
    	
    	Activity context;
    	
    	AdaptadorTitulares(Activity context) {
    		super(context, R.layout.listitem_titular, datos);
    		this.context = context;
    	}
    	
    	public View getView(int position, View convertView, ViewGroup parent) 
    	{
			View item = convertView;
			ViewHolder holder;
    		
    		if(item == null)
    		{
    			LayoutInflater inflater = context.getLayoutInflater();
    			item = inflater.inflate(R.layout.listitem_titular, null);
    			
    			holder = new ViewHolder();
    			holder.nombre = (TextView)item.findViewById(R.id.LblTitulo);
    			holder.apellido = (TextView)item.findViewById(R.id.LblSubTitulo);
    			holder.edad = (TextView)item.findViewById(R.id.LblEdad);
    			
    			
    			holder.nombre.setText(datos[position].getNombre());
    			holder.apellido.setText(datos[position].getApellido());
    			holder.edad.setText(Integer.toString(datos[position].getEdad()));
    			
    			item.setTag(holder);
    		}
    		else
    		{
    			holder = (ViewHolder)item.getTag();
    		}
			

			
			
			return(item);
		}
    }
    
    static class ViewHolder {
    	TextView nombre;
    	TextView apellido;
    	TextView edad;
    }
}

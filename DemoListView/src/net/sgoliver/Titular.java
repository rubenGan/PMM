package net.sgoliver;

public class Titular 
{
	private String nombre;
	private String apellido;
	private int edad;

	public Titular(String nom, String ape, int ed){
		nombre = nom;
		apellido = ape;
		edad = ed;
		
		}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	public int getEdad(){
		return edad;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %s - %d", this.nombre, this.apellido, this.edad);
	}
}

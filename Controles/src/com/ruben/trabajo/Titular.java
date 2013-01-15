package com.ruben.trabajo;

public class Titular 
{
	private String titulo;
	private String subtitulo;
	private int edad;

	public Titular(String tit, String sub,int ed){
		titulo = tit;
		subtitulo = sub;
		edad=ed;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getSubtitulo(){
		return subtitulo;
	}
	
	public int getEdad(){
		return edad;
	}
}

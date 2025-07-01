package modelo;

import java.util.ArrayList;



public class Animales {
	private int id;
	private String nombre;
	private int cantidad;
	public Animales(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public static ArrayList<Animales> listaAnimales(){
		
		
		ArrayList<Animales> animales = new ArrayList<Animales>();
		
		animales.add(new Animales("pollos", 3));
		animales.add(new Animales("vacas", 5));
		animales.add(new Animales("peces", 6));

				
		return animales;
		
	}
	
	

}





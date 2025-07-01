package modelo;

import java.util.ArrayList;



public class SectorProductivo {
	private int id;
	private String nombre;
	private int extended;
	public SectorProductivo(String nombre, int extended, String direccion) {
		super();
		this.nombre = nombre;
		this.extended = extended;
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
	public int getExtended() {
		return extended;
	}
	public void setExtended(int extended) {
		this.extended = extended;
	}
	
	public int getDireccion() {
		return extended;
	}
	public void setDireccion(String direccion) {
	}
	
	public static ArrayList<SectorProductivo> listaSectorProductivo(){
		
		
		ArrayList<SectorProductivo> sectorproductivo = new ArrayList<SectorProductivo>();
		
		sectorproductivo.add(new SectorProductivo("fincas", 7,"puertovega"));
		sectorproductivo.add(new SectorProductivo("haciendas", 5, "puerto"));
		sectorproductivo.add(new SectorProductivo("granjas", 3, "puertovaga"));

				
		return sectorproductivo;
		
	}
	
	

}





package modelo;

import java.util.ArrayList;

public class Preparados {	
private int id;	
private String nombreFinca;	
private String tipo;   	
private String NombreProducto;
private int cantidad;
public Preparados(String nombreFinca, String tipo, String nombreProducto, int cantidad) {
	super();
	this.nombreFinca = nombreFinca;
	this.tipo = tipo;
	this.NombreProducto = nombreProducto;
	this.cantidad = cantidad;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNombreFinca() {
	return nombreFinca;
}
public void setNombreFinca(String nombreFinca) {
	this.nombreFinca = nombreFinca;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getNombreProducto() {
	return NombreProducto;
}
public void setNombreProducto(String nombreProducto) {
	this.NombreProducto = nombreProducto;
}
public int getCantidad() {
	return cantidad;
}
public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
}

public static  ArrayList<Preparados> listaPreparados(){
	ArrayList <Preparados> preparadosp  = new ArrayList<Preparados>();
	for(int i=1; i<=7;i++) {
	preparadosp.add(new Preparados("campestre","comestible","embuelto",10));
	preparadosp.add(new Preparados("tipicas","comestible","tortas",10));
	}
	
	
	return preparadosp;
	
	
	
	
	
}




}

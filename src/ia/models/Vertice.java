package ia.models;

import java.util.HashMap;
import java.util.Map;

public class Vertice {
	String nombre="";
	int linea=0;
	String id;
	Map<Arista,Vertice> adyacentes;
	
	public Vertice(){}
	
	public Vertice(String nombre){
		this.nombre=nombre;
		adyacentes=new HashMap<>();
	}

	public Map<Arista,Vertice> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(Map<Arista,Vertice> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
		this.id=this.nombre+this.linea;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
		this.id=this.nombre+this.linea;
	}
	
	public String getId() {
		return this.id;
	}
}

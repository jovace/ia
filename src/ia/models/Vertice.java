package ia.models;

import java.util.HashMap;
import java.util.Map;

public class Vertice<V,E> {
	V elemento;
	Map<Arista<V,E>,Vertice<V,E>> adyacentes;
	
	public Vertice(){}
	
	public Vertice(V elemento){
		this.elemento=elemento;
		adyacentes=new HashMap<>();
	}
	
	public V getElemento() {
		return elemento;
	}

	public void setElemento(V elemento) {
		this.elemento = elemento;
	}

	public Map<Arista<V,E>,Vertice<V,E>> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(Map<Arista<V,E>,Vertice<V,E>> adyacentes) {
		this.adyacentes = adyacentes;
	}
}

package ia.models;

import java.util.List;
import java.util.Map;

public class MapaMetro extends Grafo<Estacion,Conexion> {
	
	
	public List<Vertice<Estacion, Conexion>> getEstaciones(){
		return this.vertices;
	}
	
	public boolean addEstacion(String nombre, int anden) {
		Estacion estacion = new Estacion(nombre, anden);
		Vertice<Estacion,Conexion> vertice = new Vertice<>(estacion);
		return addVertice(vertice);
	}
	
	public boolean addEstacion(Estacion estacion, Map<Estacion,Conexion> conexiones) {
		Vertice<Estacion,Conexion> vertice = new Vertice<>(estacion);
		if(this.ver)
		
		return false;
	}
}

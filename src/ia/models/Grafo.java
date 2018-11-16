package ia.models;

import java.util.List;

public class Grafo<V, E> {
	List<Vertice<V,E>> vertices;
	List<Arista<V,E>> aristas;
	
	public Grafo() {}
	
	public Grafo(List<Vertice<V,E>> vertices, List<Arista<V,E>> aristas) {
		this.vertices=vertices;
		this.aristas=aristas;
	}
	
	public boolean addVertice(Vertice<V,E> vertice) {
		if(vertices.contains(vertice)) return false;
		if(!vertices.containsAll(vertice.getAdyacentes().values()))return false;
		for(Arista<V,E> arista : vertice.getAdyacentes().keySet()) {
			if(!aristas.contains(arista)) aristas.add(arista);
		}
		vertices.add(vertice);
		return true;
	}
	
	public boolean conectarVertices(Vertice<V,E> vertice1, Vertice<V,E> vertice2, Arista<V,E> arista) {
		if(!vertices.contains(vertice1))return false;
		if(!vertices.contains(vertice2))return false;
		
		vertice1.getAdyacentes().put(arista, vertice2);
		vertice2.getAdyacentes().put(arista, vertice1);
		return true;		
	}
}

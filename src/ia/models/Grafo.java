package ia.models;

import java.util.List;

public class Grafo<V, E> {
	List<Vertice> vertices;
	List<Arista> aristas;
	
	public Grafo() {}
	
	public Grafo(List<Vertice> vertices, List<Arista> aristas) {
		this.vertices=vertices;
		this.aristas=aristas;
	}
	
	public boolean addVertice(Vertice vertice) {
		if(vertices.contains(vertice)) return false;
		if(!vertices.containsAll(vertice.getAdyacentes().values()))return false;
		for(Arista arista : vertice.getAdyacentes().keySet()) {
			if(!aristas.contains(arista)) aristas.add(arista);
		}
		vertices.add(vertice);
		return true;
	}
	
	public boolean conectarVertices(Vertice vertice1, Vertice vertice2, Arista arista) {
		if(!vertices.contains(vertice1))return false;
		if(!vertices.contains(vertice2))return false;
		
		vertice1.getAdyacentes().put(arista, vertice2);
		vertice2.getAdyacentes().put(arista, vertice1);
		return true;		
	}
	
	public boolean conectarVertices(Vertice vertice1, Vertice vertice2, double peso) {
		if(!vertices.contains(vertice1))return false;
		if(!vertices.contains(vertice2))return false;
		
		vertice1.getAdyacentes().put(new Arista(peso), vertice2);
		vertice2.getAdyacentes().put(new Arista(peso), vertice1);
		return true;		
	}
}

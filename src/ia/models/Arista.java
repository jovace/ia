package ia.models;

public class Arista {
	double peso;
	Vertice nodo1;
	Vertice nodo2;
	
	public double getPeso() {
		return this.peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public Vertice getNodo1() {
		return nodo1;
	}
	public void setNodo1(Vertice nodo1) {
		this.nodo1 = nodo1;
	}
	public Vertice getNodo2() {
		return nodo2;
	}
	public void setNodo2(Vertice nodo2) {
		this.nodo2 = nodo2;
	}
	
	public Arista() {}
	
	public Arista(double peso, Vertice nodo1, Vertice nodo2) {
		this.peso=peso;
		this.nodo1=nodo1;
		this.nodo2=nodo2;
	}
	//Comentario
}

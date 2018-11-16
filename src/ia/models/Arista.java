package ia.models;

public class Arista<V,E> {
	E elemento;
	Vertice<V,E> nodo1;
	Vertice<V,E> nodo2;
	
	public E getElemento() {
		return elemento;
	}
	public void setElemento(E elemento) {
		this.elemento = elemento;
	}
	public Vertice<V, E> getNodo1() {
		return nodo1;
	}
	public void setNodo1(Vertice<V, E> nodo1) {
		this.nodo1 = nodo1;
	}
	public Vertice<V, E> getNodo2() {
		return nodo2;
	}
	public void setNodo2(Vertice<V, E> nodo2) {
		this.nodo2 = nodo2;
	}
}

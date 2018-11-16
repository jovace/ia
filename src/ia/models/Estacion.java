package ia.models;

public class Estacion {
	String nombre;
	int linea;
	String id;
	
	public Estacion() {}
	
	public Estacion(String nombre, int linea) {
		this.nombre=nombre;
		this.linea=linea;
		this.id=nombre+linea;
	}
	
	public Estacion(String nombre) {
		this.nombre=nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLinea() {
		return linea;
	}

	public void setLinea(int linea) {
		this.linea = linea;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}

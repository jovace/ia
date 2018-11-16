package ia.models;

public class Conexion{
	float tiempoViaje;
	int numEscalones;
	boolean accesoSillaRuedas;
	
	public Conexion() {}

	public float getTiempoViaje() {
		return tiempoViaje;
	}

	public void setTiempoViaje(float tiempoViaje) {
		this.tiempoViaje = tiempoViaje;
	}

	public int getNumEscalones() {
		return numEscalones;
	}

	public void setNumEscalones(int numEscalones) {
		this.numEscalones = numEscalones;
	}

	public boolean isAccesoSillaRuedas() {
		return accesoSillaRuedas;
	}

	public void setAccesoSillaRuedas(boolean accesoSillaRuedas) {
		this.accesoSillaRuedas = accesoSillaRuedas;
	}
	

	
}

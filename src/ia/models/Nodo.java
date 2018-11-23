package ia.models;

import java.util.Map;

public final class Nodo<T> { 

    private final T estacion;
    private final Map<T, Conexion> conexiones;

    private double g;  // g is distance from the source
    private double h;  // h is the heuristic of destination.
    private double f;  // f = g + h 

    public Nodo (T estacion, Map<T, Conexion> conexiones) {
        this.estacion = estacion;
        this.g = Double.MAX_VALUE; 
        this.conexiones = conexiones;
    }

    public T getNodeId() {
        return estacion;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void calcF(T destination) {
        this.h = conexiones.get(destination).getValue();
        this.f = g + h;
    } 

    public double getH() {
        return h;
    }

    public double getF() {
        return f;
    }
 }
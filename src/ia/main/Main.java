package ia.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import ia.models.Grafo;
import ia.models.Vertice;

public class Main {

	public static void main(String[] args) {
		
		//Inicializacion del grafo de red de metro
		Grafo mapaMetro = new Grafo();
		
		Map<String,Vertice> estaciones = new HashMap<>();
		
		
		try {
			String cadena;
			FileReader fr;
			fr = new FileReader("grafo.txt");

			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				//Nombre;[Ady1:dist1;ady2:dist2]
				Vertice vert;
				String nombre = cadena.split(";")[0];
				
				if(!estaciones.containsKey(nombre)) {
					vert=new Vertice(nombre);
					estaciones.put(nombre, vert);
					mapaMetro.addVertice(vert);
				}else {
					vert=estaciones.get(nombre);
				}
			
				
				String conexiones=cadena.split(";",2)[1].replace('[', ' ').replace(']',' ').trim();
				String[] adyacentes = conexiones.split(";");
				for(String ady : adyacentes) {
					String estacion=ady.split(":")[0];
					Double peso=Double.valueOf(ady.split(":")[1]);
					
					Vertice est;
					if(!estaciones.containsKey(estacion)) {
						est=new Vertice(estacion);
						estaciones.put(estacion, est);
						mapaMetro.addVertice(est);
					}else {
						est=estaciones.get(estacion);
					}
					
					if(!mapaMetro.conectarVertices(vert, est, peso)) {
						//Error
					}
				}
			}
			br.close();
			
			System.out.println("Importacion correcta");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//Inicializacion de matriz de distancias para funcion heuristica
		Map<Vertice,Map<Vertice,Double>> distancias = new HashMap<>();
		
		try {
			String cadena;
			FileReader fr;
			fr = new FileReader("distancias.txt");

			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				//Nombre;[Est1:dist1;Est2:dist2]
				String nombre = cadena.split(";")[0];
				Vertice vert=estaciones.get(nombre);
				
				String conexiones=cadena.split(";",2)[1].replace('[', ' ').replace(']',' ').trim();
				String[] adyacentes = conexiones.split(";");
				Map<Vertice,Double> distancias2 = new HashMap<>();
				for(String ady : adyacentes) {
					String estacion=ady.split(":")[0];
					Double peso=Double.valueOf(ady.split(":")[1]);
					
					Vertice est=estaciones.get(estacion);
					
					distancias2.put(est, peso);
					
				}
				distancias.put(vert,distancias2);
			}
			br.close();
			
			System.out.println("Importacion correcta");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}



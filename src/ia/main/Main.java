package ia.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import ia.models.Grafo;

public class Main {

	public static void main(String[] args) {
		Grafo mapaMetro = new Grafo();
		
		
		try {
			String cadena;
			FileReader fr;
			fr = new FileReader("data.txt");

			BufferedReader br = new BufferedReader(fr);
			while ((cadena = br.readLine()) != null) {
				System.out.println(cadena);
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

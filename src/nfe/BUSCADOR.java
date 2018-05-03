package nfe;

import java.util.ArrayList;
import java.util.Iterator;

public class BUSCADOR {
	 ArrayList<Genero> generos = new ArrayList<Genero>();

	public  Genero buscarGenero(String nombre) {
		boolean encontrado = false;
		Genero buscado = null;
		while (!encontrado){
			for (Genero g : generos) {
				if (nombre.equals(g.getNombre())){
					encontrado = true;
					buscado = g;
				}
			}
			
			encontrado = true;
		}
	
		return buscado;
		
		
	}
	
	public  ArrayList<Libro> porGenero(String g) {
		return this.buscarGenero(g).getLibros();
	}
	public  void addGenero(Genero g) {
		generos.add(g);
	}
}

package nfe;

import java.util.ArrayList;
import java.util.HashMap;



public class BUSCADOR {
	private static GrafoDirigido generos = new GrafoDirigido();

	public static void addGenero(String nombre) {
		if (generos.getGenero(nombre) == null)
			generos.addGenero(nombre);
	}
	public static Genero buscarGenero(String nombre) {
		return generos.getGenero(nombre);
		/*Genero gen = generos.getGenero(nombre);
		if (gen == null) {
			generos.addGenero(nombre);
			gen = generos.getGenero(nombre);
		}
		return gen;*/
	}

	public static ArrayList<Libro> porGenero(String g) {
		return buscarGenero(g).getLibros();
	}
	public static HashMap<Genero, Integer> masConectados(String gen, int cant) {
		return generos.masConectados(gen, cant);
	}
	public static ArrayList<Genero> conexiones(String gen) {
		return generos.todasLasConexiones(gen);
	}
	public static GrafoDirigido getAfines(String g) {
		return generos.getAfines(g);
	}
	
}

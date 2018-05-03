package nfe;

import java.util.ArrayList;

public class Genero {
	private String nombre = "";
	private ArrayList<Libro> libros = new ArrayList<Libro>();

	public Genero(String nombre) {
		this.nombre = nombre;
	}
	public void addLibro(Libro l) {
		this.libros.add(l);
	}

	public String getNombre() {
		return nombre;
	}
	public ArrayList<Libro> getLibros() {
		return this.libros;
	}
}

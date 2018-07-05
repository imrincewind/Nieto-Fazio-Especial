package nfe;

import java.util.ArrayList;
import java.util.HashMap;


public class Genero {
	private String nombre = "";
	private ArrayList<Libro> libros = new ArrayList<Libro>();
	private HashMap<Genero, Integer> conexiones = new HashMap<Genero, Integer>();
	private boolean visitado = false;
	private boolean terminado = false;
	private Genero padre = null;
	public Genero(String nombre) {
		this.nombre = nombre;
	}
	public void addLibro(Libro l) {
		this.libros.add(l);
	}

	public String getNombre() {
		return this.nombre;
	}
	public boolean getTerminado() {
		return this.terminado;
	}
	public void setTerminado(boolean term) {
		this.terminado = term;
	}
	public Genero getPadre() {
		return this.padre;
	}
	public void setPadre(Genero p) {
		this.padre = p;
	}
	public ArrayList<Libro> getLibros() {
		return this.libros;
	}
	
	public String toString() {
		return this.nombre;
	}

	public void addConexion(Genero g) {
		conexiones.put(g, conexiones.getOrDefault(g, 0)+1); //retorna el valor y si no está retorna 0
		
	}
	public int CantidadConexiones(Genero g) {
		
		return this.conexiones.getOrDefault(g, 0);
	}
	public HashMap<Genero, Integer> getConexiones(){
		return this.conexiones;
	}
	public void setVisitado(boolean v) {
		this.visitado = v;
	}
	public boolean getVisitado() {
		return this.visitado;
	}
	public void setNombre(String n) {
		this.nombre = n;
		
	}
}

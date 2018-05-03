package nfe;

import java.util.ArrayList;

public class Libro {
	private String titulo = "";
	private String autor = "";
	private int pags = 0;
	private int id = 0;
	private ArrayList<String> generos = new ArrayList<String>();

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPags() {
		return pags;
	}

	public void setPags(int pags) {
		this.pags = pags;
	}

	public ArrayList<String> getGeneros() {
		return generos;
	}

	public void addGenero(String genero) {
		this.generos.add(genero);
	}

	public int getId() {
		return id;
	}
	public String toString() {
		String retorno = this.id + "," + this.titulo + "," + this.autor + "," + this.pags ;
		for (String g : generos) {
			retorno += "," + g;
		}
		return retorno; 
	}
}

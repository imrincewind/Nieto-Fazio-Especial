package nfe;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;

public class GrafoDirigido {

	private Map<String, Genero> generos = new HashMap<String, Genero>();// parametrizar-
	private Map<String, Genero> libros = new HashMap<String, Genero>();

	public ArrayList<Genero> todasLasConexiones(String g) {
		Genero gen = this.getGenero(g);
		return DFS.DFS(gen);
	}
	public Set<Genero> conexiones(String g) {
		return this.getGenero(g).getConexiones().keySet();
	} 
	public HashMap<Genero, Integer> masConectados(String genero, Integer cantidadABuscar) {
		Genero gen = this.getGenero(genero); 
		HashMap<Genero, Integer> masConectados = new HashMap<Genero, Integer>();
		if (gen != null) {
			Genero seleccionados[] = new Genero[gen.getConexiones().size()];
			Genero todos[] = new Genero[gen.getConexiones().size()];
			int h = 0;
			for (Genero g : gen.getConexiones().keySet()) {
				todos[h] = g;
				seleccionados[h] = g;
				h++;
			}
			todos = this.ordenar(todos, gen);		
			int i = 0;
			while (i < cantidadABuscar &&i < todos.length) {
				if (todos[i] != null) {
					masConectados.put(todos[i], gen.CantidadConexiones(todos[i]));//si bien, no quedan ordenados, si son los de mayor valor
				}
				
				i++;
			}
		}

		return masConectados;
	}
	 private Genero[] ordenar(Genero[] todos, Genero g){
	        for(int i = 0 ;i< todos.length-1 ;i++){
	            for(int j = i+1 ;j< todos.length ;j++){
	                if(g.getConexiones().get(todos[i]) < g.getConexiones().get(todos[j])){	                    
	                    Genero tmp = todos[i];
	                    todos[i] = todos[j];
	                    todos[j] = tmp;
	 
	                }
	            }
	        }
	        return todos;
	    }
	public boolean existeGenero(String s) {
		return this.generos.containsKey(s);
	}

	public boolean existeLibro(String s) {
		return this.libros.containsKey(s);
	}

	public void addLibro(String s) {
		Genero vertice = new Genero(s);
		libros.put(s, vertice);
	}

	public Genero getGenero(String generoBuscado) {
		return this.generos.get(generoBuscado);
	}
	public GrafoDirigido getAfines(String gen) {
		GrafoDirigido grafo = new GrafoDirigido();
		Genero g = generos.get(gen);
		grafo.addGenero(gen);
		ArrayList<Genero> vinculados = DFS.DFSVinculados(g);
		grafo.addGenero(vinculados.get(0).getNombre());
		System.out.println(vinculados.size());
		for (int i = 1; i < vinculados.size(); i++) {
			//System.out.println(vinculados.get(i).getNombre());
			
			grafo.addGenero(vinculados.get(i).getNombre());
			grafo.getGenero(vinculados.get(i).getNombre()).addConexion(vinculados.get(i-1));
		}
		
		/*for (Genero ge : vinculados) {
			grafo.addGenero(ge.getNombre());
			ArrayList<String> tmp = new ArrayList<String>();
			tmp.add(ge.getNombre());
			grafo.setConexiones(gen, tmp);
			tmp.remove(0);
			tmp.add(gen);
			grafo.setConexiones(ge.getNombre(), tmp);
		}*/
		
		
		
		return grafo;
	}
	public void addGenero(String s) {

		this.generos.put(s, new Genero(s));
	}

	public void setConexiones(String s, ArrayList<String> generosLibro) {
		Genero g = this.libros.get(s);
		if (g == null) {
			g = new Genero(s);
		}
		generos.put(s, g);

		for (Genero gen : generos.values()) {
			if (!this.generos.containsKey(gen.getNombre())) {
				addGenero(gen.getNombre());
			}
			g.addConexion(this.generos.get(g));
			this.generos.get(s).addConexion(g);
		}

	}

	private Integer getCantidadConexiones(Genero generoInicial, Genero g) {

		Integer i = generoInicial.CantidadConexiones(g);
		if (i != null) {
			return i;
		}
		return 0;
	}

}

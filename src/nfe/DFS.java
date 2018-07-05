package nfe;

import java.util.ArrayList;
import java.util.Set;

public class DFS {
	private static Genero genero = null;

	public static ArrayList<Genero> DFS(Genero gen) {

		ArrayList<Genero> resultado = new ArrayList<Genero>();
		Set<Genero> conexiones = gen.getConexiones().keySet(); // obtengo el
																// primer nivel
		for (Genero g : conexiones) {
			if (g != null) {
				g.setTerminado(false); // ponen blanco los
				g.setVisitado(false); // se en todos generos
				g.setPadre(null);
			}

		}
		for (Genero g : conexiones) {
			if (g != null) {
				if ((g.getVisitado() == false) && (g.getTerminado() == false)) {// blanco
					resultado.addAll(DFS_Visitar(g, new ArrayList<Genero>()));
				}
			}

		}
		return resultado;
	}

	private static ArrayList<Genero> DFS_Visitar(Genero gen, ArrayList<Genero> seleccionados) {
		gen.setVisitado(true); // amarillo
		
		
		seleccionados.add(gen);
		Set<Genero> conexiones = gen.getConexiones().keySet();
		for (Genero g : conexiones) {
			
			if (g != null) {
				if (genero != null && gen.equals(genero)) {
					return seleccionados;
				}
				if ((g.getVisitado() == false) && (g.getTerminado() == false)) {// blanco
					DFS_Visitar(g, seleccionados);
				}
			}

		}
		gen.setTerminado(true); // negro
		return seleccionados;
	}

	public static ArrayList<Genero> DFSVinculados(Genero gen) {
		genero = gen;
		ArrayList<Genero> resultado = new ArrayList<Genero>();
		Set<Genero> conexiones = gen.getConexiones().keySet(); // obtengo el
																// primer nivel
		conexiones.remove(gen);
		for (Genero g : conexiones) {
			if (g != null) {
				g.setTerminado(false); // ponen blanco los
				g.setVisitado(false); // se en todos generos
				g.setPadre(null);
			}

		}
		for (Genero g : conexiones) {
			if (g != null) {
				if ((g.getVisitado() == false) && (g.getTerminado() == false)) {// blanco
					resultado.addAll(DFS_Visitar(g, new ArrayList<Genero>()));
				}
			}

		}
		return resultado;
	}

}
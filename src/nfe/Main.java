package nfe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		String pathEntrada = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/dataset4.csv";
		String pathEntrada2 = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/datasets2/dataset3.csv";
		String pathSalida = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/salida.csv";
		Timer tiempo = new Timer();
		BUSCADOR b = new BUSCADOR();
		CSVReaderBuscador.main(args, pathEntrada2);
		HashMap<Genero, Integer> conectados = BUSCADOR.masConectados("viajes", 3);// si
																					// bien,
																					// no
																					// quedan
																					// ordenados,
																					// si
																					// son
																					// los
																					// de
																					// mayor
																					// valor
		System.out.println(conectados);
		for (Genero genero : conectados.keySet()) {
			System.out.println(genero.getNombre() + " - " + conectados.get(genero));
		}
		ArrayList<Genero> conexiones = new ArrayList<Genero>();
		conexiones = BUSCADOR.conexiones("viajes");
		/*for (Genero g : conexiones) {
			System.out.println(g.getNombre());
		}*/
		GrafoDirigido grafo = BUSCADOR.getAfines("viajes");
		
		for (Genero genero : grafo.todasLasConexiones("viajes") ) {
			System.out.println(genero);
		}
		/*   //-------------PRIMERA ENTREGA DEL TP ESPECIAL-----------
		 * CSVReader.main(args, b, pathEntrada); ArrayList<Libro>
		 * librosFiltrados = new ArrayList<Libro>();
		 * System.out.println(b.generos); tiempo.start(); for (int i = 0; i <
		 * 100; i++) { //librosFiltrados = b.porGenero("terror");
		 * b.porGenero("humor"); //b.porGenero("juegos");
		 * //b.porGenero("drama"); //b.porGenero("deportes");
		 * //b.porGenero("suspenso"); //b.porGenero("policial"); }
		 * System.out.println(tiempo.stop()/100);
		 * 
		 * CSVWritter.main(args, librosFiltrados, pathSalida);
		 * 
		 */

	}

}

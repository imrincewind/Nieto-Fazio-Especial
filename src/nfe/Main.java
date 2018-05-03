package nfe;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String pathEntrada = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/dataset2.csv";
		String pathSalida = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/salida.csv";
		
		BUSCADOR b = new BUSCADOR();
		
		CSVReader.main(args, b, pathEntrada);
		ArrayList<Libro> librosFiltrados = b.porGenero("juegfgjud");
		CSVWritter.main(args, librosFiltrados, pathSalida);
	}

}

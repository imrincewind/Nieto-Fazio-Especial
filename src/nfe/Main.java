package nfe;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		String pathEntrada = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/dataset4.csv";
		String pathSalida = "C:/TUDAI-ws/Nieto-Fazio-Especial/datasets/salida.csv";
		Timer tiempo = new Timer();
		BUSCADOR b = new BUSCADOR();
		
		CSVReader.main(args, b, pathEntrada);
		tiempo.start();
		ArrayList<Libro> librosFiltrados = b.porGenero("juegos");
		System.out.println(tiempo.stop());
		CSVWritter.main(args, librosFiltrados, pathSalida);
	}

}

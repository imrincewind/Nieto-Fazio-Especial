package nfe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;





public class CSVReader {

    public static void main(String[] args, BUSCADOR b, String path) {
        String csvFile = path;
        String line = "";
        String csvSplitBy = ",";
        String csvSplitByGenero = " ";
        int numLine = 0;
       
        ArrayList<Libro> libros = new ArrayList<Libro>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                
                if(numLine > 0){
            		Libro l = new Libro();
                    String[] items = line.split(csvSplitBy);
                    l.setId(numLine + 1);
                    l.setTitulo(items[0].toString());
                    l.setAutor(items[1].toString());
                    l.setPags( Integer.parseInt(items[2].toString()) );
                    String[] generos = items[3].split(csvSplitByGenero);
                    for(int i=0; i < generos.length-1; i++){
                    	l.addGenero(generos[i].toString());
                    	Genero g = b.buscarGenero(generos[i].toString());
                    	if( g == null){ //Si no existe el genero lo crea
                    		g = new Genero(generos[i].toString());
                    		b.addGenero(g); //agrega el genero nuevo al buscador
                    	}
                    	g.addLibro(l); //agrega el libro
                    }
                    libros.add(l);
            	}
            	numLine++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

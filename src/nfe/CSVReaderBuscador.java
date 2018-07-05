package nfe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;






public class CSVReaderBuscador {

    public static void main(String[] args, String path) {
        String csvFile = path;
        String line = "";
        String csvSplitBy = ",";
     
        int numLine = 0;
       
      
        
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                
                if(numLine > 0){
            		
                    String[] busqueda = line.split(csvSplitBy);
                    
                   
                        for(int i=0; i < busqueda.length; i++){
                        	BUSCADOR.addGenero(busqueda[i]);
                        	if (i<busqueda.length-1){
                        		BUSCADOR.addGenero(busqueda[i+1]);
                        		BUSCADOR.buscarGenero(busqueda[i]).addConexion(BUSCADOR.buscarGenero(busqueda[i+1]));
                        	}
                    	
                    	
                    }
                
            	}
            	numLine++;
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}

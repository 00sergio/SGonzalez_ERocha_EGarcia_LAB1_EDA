import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CargarFichero
{
	
	public CargarFichero() {}
		
	//---------------
	
	public static void CargarListaWebs() {
		String nombreFicheroListaWebs = "webs.txt";
        try {
        	 // Crear un objeto BufferedReader al que se le pasa 
            //   un objeto FileReader con el nombre del fichero
        	Scanner entrada = new Scanner(new FileReader(nombreFicheroListaWebs));
        	String linea;
        	// Leer la primera línea, guardando en un String
        	while(entrada.hasNext()) {
        		linea=entrada.nextLine();
	        	String [] datos = linea.split(":");
	        	//En la posicion 0 el numero y en la posicion 1 el nombre de la web
	        	datos[0] = datos[0].trim();
				datos[1] = datos[1].trim();
				
				int numeroWeb = Integer.parseInt (datos[0]);
				Web w = new Web(datos[1]);
				Lista_webs.getListaWebs().anadirWeb1(numeroWeb, w);
        	}	
        	entrada.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void CargarWebs() {
		String nombreFicheroWebs = "relaciones.txt";
		try {
			Scanner entrada = new Scanner(new FileReader(nombreFicheroWebs));
        	String linea;
        	// Leer la primera línea, guardando en un String
        	while(entrada.hasNext()) {
        		linea=entrada.nextLine();
        		String [] sub1 = linea.split(" --->"+"\\s+");
                int ind = Integer.parseInt(sub1[0]);
                if(sub1.length>1) {
	                String [] sub2 = sub1[1].split(" ### ");
	                Web w = Lista_webs.getListaWebs().buscarWeb(ind);  
	                for (int n=0;n<sub2.length;n++) {
	                	int i = Integer.parseInt(sub2[n]);
	                    w.anadirIndice(i);     	
	                }
                }
        	}
        	entrada.close();	
		}
        catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	public static void CargarPalabras() {
		String nombreFicheroWebs = "palabras.txt";
		try {
			Scanner entrada = new Scanner(new FileReader(nombreFicheroWebs));
        	String linea;
        	// Leer la primera línea, guardando en un String
        	while(entrada.hasNext()) {
        		linea=entrada.nextLine();
        		Palabra p = new Palabra(linea);
        		Lista_Palabras.getListaPalabras().añadirPalabra(p);
        	}
        }
		catch (IOException e)
        {
            e.printStackTrace();
        }
	}
	
	
}
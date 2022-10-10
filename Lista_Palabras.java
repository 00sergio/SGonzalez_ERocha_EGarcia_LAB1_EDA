import java.util.HashSet;
import java.util.Iterator;

public class Lista_Palabras {
	private HashSet<Palabra> hListaPalabras;
	private static Lista_Palabras lp;

	
	private Lista_Palabras() {
		this.hListaPalabras = new HashSet<Palabra>();
	}
	
	
	public static Lista_Palabras getListaPalabras() {
		if(lp == null) {
			lp = new Lista_Palabras();
		}
		return lp;
	}
	
	public void añadirPalabra(Palabra p ) {
		if (!estaPalabra(p)) {
			hListaPalabras.add(p);}
	}
	
	public boolean estaPalabra(Palabra p) {
		boolean rdo = false;
		if(hListaPalabras.contains(p)) {
			rdo = true;
		}
		return rdo;
		
	}

	public HashSet<Palabra> getHashSet(){
		return this.hListaPalabras;
	}
	
	
	public void imprimirHasSetWebs() {
		System.out.println("Numero Palabras: " + hListaPalabras.size());
		Iterator<Palabra> itr = hListaPalabras.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next().getNombre());
		}
	}
	
	
	
	
}

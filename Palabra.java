import java.util.HashSet;
import java.util.Iterator;

public class Palabra {
	private String nombre;
	private HashSet<Web> hp;
		
	public Palabra (String pNombre) {
		this.nombre = pNombre;
		this.hp = new HashSet<Web>();
	}
	
	public void anadirPalabra(Web p) {
		if (!estaPalabra(p)) {
		hp.add(p);}
	}
	
	public boolean estaPalabra(Web p) {
		boolean rdo = false;
		if(hp.contains(p)) {
			rdo = true;
		}
		return rdo;
	}
	
	public int tamañoPalabra() {
		int x = 0;
		x = this.nombre.length();
		return x;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public HashSet<Web> getHashSet(){
		return this.hp;
	}
	
	public void imprimirHasSetPalabra() {
		System.out.println(hp.size());
		Iterator<Web> itr = hp.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	}
	
	
	
	
}

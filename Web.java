import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Web implements Comparable<Web>{
	private String nombre;
	private HashSet<Integer> hListaIndicesWebs;
	
	public Web(String pNombre) {
		this.nombre = pNombre;
		this.hListaIndicesWebs = new HashSet<Integer>();
	}
	
	public void anadirIndice(int i) {
		if (!estaIndice(i)) {
		hListaIndicesWebs.add(i);}
	}
	
	public boolean estaIndice(int i) {
		boolean rdo = false;
		if(hListaIndicesWebs.contains(i)) {
			rdo = true;
		}
		return rdo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public HashSet<Integer> getHashSet(){
		return this.hListaIndicesWebs;
	}
	
	public void imprimirHasSetWebs() {
		System.out.println(hListaIndicesWebs.size());
		Iterator<Integer> itr = hListaIndicesWebs.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
		/*Iterator<Integer> itr = hi.iterator();
		while (itr.hasNext()){
			System.out.println(itr.next());*/
		
	}

	@Override
	public int compareTo(Web w) {
		return this.getNombre().compareTo(w.getNombre());
	}
}

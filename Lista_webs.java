import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;

public class Lista_webs {
	private ArrayList<String> lWebs;
	private ArrayList<String> lPalabras;
	private ArrayList<Web> lOrdenada;
	private HashMap<Integer, Web> hwebs;
	private static Lista_webs lw;
		
	private Lista_webs(){
		this.lWebs = new ArrayList<>();
		this.lPalabras = new ArrayList<>();
		this.lOrdenada = new ArrayList<>();
		this.hwebs = new HashMap<>();
	}
	
	public static Lista_webs getListaWebs() {
		if(lw == null) {
			lw = new Lista_webs();
		}
		return lw;
	}
	
	public void anadirWeb1 (int indice, Web w) {
		if(w != null && !estaWeb(w)) {
			hwebs.put(indice, w);
		}
	}
	
	public void anadirWeb (String nom) {
		Web w = new Web(nom);
		hwebs.put(hwebs.size(), w);
	}
	
	
	
	public boolean estaWeb(Web w) {
		boolean rdo = false;
		if(hwebs.containsKey(w)) {
			rdo = true;
		}
		return rdo;
	}
	
	public Web buscarWeb(int pIndice) {
		return hwebs.get(pIndice);
	}
	
	public void eliminarWeb(String nWeb) {
		boolean enc = false;
		int ind = 0;
		Iterator<Integer> it = hwebs.keySet().iterator();
		while(it.hasNext()&&!enc) {
			ind = it.next();
			Web w = hwebs.get(ind);
			if(w.getNombre().equals(nWeb)) {
				enc = true;
				hwebs.remove(ind);
			}
		}
		if (!enc) {System.out.println("La pagina no se ha encontrado;");}
	}
	
	//-------------------------------------------------------------
	
	//creamos un arraylist con el nombre de las webs y luego con el
	public void crearArraylist(){
		if(hwebs.isEmpty() == false) {
		lOrdenada = new ArrayList<>();
		for (Integer key: hwebs.keySet()){  
			Web x = null;
			x = hwebs.get(key);
			lOrdenada.add(x);
		}
		ordenarLista(lOrdenada);
		}
		else {System.out.println("La lista no tiene ningun elemento para ordenar");}
	}
	
	public void ordenarLista(ArrayList<Web> lista){
		quickSort(lista, 0, lista.size()-1);
		}
	
	private void quickSort(ArrayList<Web> lista, int inicio, int fin){
		if ( fin - inicio > 0 ) { // hay más de un elemento en la tabla
			int indiceParticion = particion(lista, inicio, fin);
			quickSort(lista, inicio, indiceParticion - 1);
			quickSort(lista, indiceParticion + 1, fin);
		}
	}
	
	private int particion(ArrayList<Web> lista, int i, int f){
		Web pivote = lista.get(i);
		int izq = i;
		int der = f;
		while ( izq < der ){
				while ( lista.get(izq).compareTo(pivote) <= 0 && izq < der) {
					izq++;}
				while ( lista.get(der).compareTo(pivote) > 0 ) {
					der--;}
				if ( izq < der )
				Collections.swap(lista, izq, der);
				}
		lista.set(i, lista.get(der));
		lista.set(der, pivote);
		return der;
		}
	
	//-------------------------------------------------------------
	
	public void imprimirHashmapDeListaWebs () {
		for (Integer key: hwebs.keySet()){  
			System.out.println(key+ " = " + hwebs.get(key).getNombre());}
	}
	
	public void imprimirListaOrdenada () {
		 for(int i = 0; i < lOrdenada.size(); i++) {
	            System.out.println(lOrdenada.get(i).getNombre());
	        }
	}
	
	public void imprimirHashSets () {
		 for(int i = 0; i < hwebs.size(); i++) {
	            Web w = hwebs.get(i);
	            if(w!=null) {
		            System.out.println("Web: "+w.getNombre()+" Relaciones: ");
		            w.imprimirHasSetWebs();
	            }
	        }
	}
	
	//-------------------------------------------------------------
	public HashSet<Web> devolverListaWebs(Web w){
		HashSet<Web> hw = new HashSet<>();
		HashSet<Integer> hw2 = w.getHashSet();
		Iterator<Integer> itr = hw2.iterator();
		int i = 0;
		Web w1 = new Web(null);
		String s = null;
		while(itr.hasNext()) {
			i = itr.next();
			w1 = buscarWeb(i);
			s = w1.getNombre();
			Web q = new Web(s);
			hw.add(q);
		}
		Iterator<Web> it = hw.iterator();
		while(it.hasNext()) {
			w1 = it.next();
			System.out.println(w1.getNombre());
		}
		return hw;
	}
	
	
	//-------------------------------------------------------------

	public ArrayList<String> devolverWebPalabra(String pPa) {
		Lista_webs lw = Lista_webs.getListaWebs(); 
		
		for (String l : lw.getListaWebsString()) {
			if (l.contains(pPa)){
				lPalabras.add(l);
			}
		}System.out.println(lPalabras);
		return lPalabras;
	}

	public ArrayList<String> getListaWebsString() {
		return lWebs;
	}
	
	
}


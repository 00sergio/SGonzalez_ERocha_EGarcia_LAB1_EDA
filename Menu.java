import java.util.Scanner;


public class Menu 
{
	private static Menu miMenu=null;
	
	private Menu() {}
	public static Menu getMenu()
	{
		if (miMenu == null)
		{
			miMenu = new Menu();
		}
		return miMenu;
	}
	public void mostrarMenu()
	{
	Lista_webs l = Lista_webs.getListaWebs();
	Lista_Palabras lp = Lista_Palabras.getListaPalabras();
	Scanner sc = new Scanner(System.in);
	boolean salir = false;
	int num;
	
	
	while(!salir) {
	System.out.println("Escoge una opción de las siguiente: "
			+ "\n1- Cargar los datos desde los ficheros."
			+ "\n2- Buscar una página web por indice. "
			+ "\n3- Insertar una página web."
			+ "\n4- Devolver las páginas web enlazadas desde ella."
			+ "\n5- Buscar mediante una palabra clave las webs asociadas"
			+ "\n6- Borrar una página web."
			+ "\n7- Guardar la lista de webs en ficheros."
			+ "\n8- Ordenar las páginas webs."
			+ "\n9- Salir.");
	
		num = sc.nextInt();
		
		switch(num){
		case 1:
			CargarFichero.CargarListaWebs();;
			CargarFichero.CargarPalabras();;
			CargarFichero.CargarWebs();
			System.out.println("Datos cargados");
			break;
		case 2:
			System.out.println("Introduce el indice de la página Web: ");
			Scanner sc2 = new Scanner(System.in);
			String inW = sc2.next();
			int indWeb = Integer.parseInt(inW);
			Lista_webs.getListaWebs().buscarWeb(indWeb);
			break;
		
		case 3:
			System.out.println("Introduce el nombre de la página Web: ");
			Scanner sc3 = new Scanner(System.in);
			String inW3 = sc3.next();
			Lista_webs.getListaWebs().anadirWeb(inW3);
			break;
		
		case 4:
			System.out.println("Introduce el nombre de la página Web: ");
			Scanner sc4 = new Scanner(System.in);
			String inW4 = sc4.next();
			Web w = new Web(inW4);
			Lista_webs.getListaWebs().devolverListaWebs(w);
			break;

		case 5:
			System.out.println("Introduce el nombre de una palabra clave: ");
			Scanner sc5 = new Scanner(System.in);
			String u = sc5.nextLine();
			l.devolverWebPalabra(u);
			break;
		
		case 6:
			System.out.println("Introduce el nombre de una palabra clave: ");
			Scanner sc6 = new Scanner(System.in);
			String u2 = sc6.nextLine();
			l.eliminarWeb(u2);
			break;
			
		case 8:
			l.crearArraylist();
			
		case 9:
			salir=true;
			System.out.println("programa cerrado");
			break;
			
		
		default:
		System.out.println("Solo números entre 1 y 8");
	}
	}
	
}
}


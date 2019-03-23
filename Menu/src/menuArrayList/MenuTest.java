package menuArrayList;

/**
 * Un esempio: realizzare un semplice menù
 * 
 * Scrivere una classe per testare la classe Menu
 * 
 * @author francescopioscognamiglio
 *
 */
public class MenuTest
{

	public static void main(String[] args)
	{
		Menu menu = new Menu();
		
		menu.aggiungiOpzione("Inizia gioco");
		menu.aggiungiOpzione("Carica gioco");
		menu.aggiungiOpzione("Aiuto");
		menu.aggiungiOpzione("Esci");
		
		menu.togliOpzione("Esci");
		menu.aggiungiOpzione("Esci");
		
		System.out.println("Visualizzazione del menu appena creato: ");
		menu.visualizza();
		
		System.out.println("La prima opzione e': " + menu.getOpzione(1));
	}

}

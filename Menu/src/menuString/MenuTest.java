package menuString;

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
		
		menu.addOption("Inizia il gioco"); 
		menu.addOption("Carica gioco");
		menu.addOption("Aiuto");
		menu.addOption("Esci");
		
		menu.display();
		
		System.out.println("La prima opzione e': " + menu.getOption(1));
	}
	
}

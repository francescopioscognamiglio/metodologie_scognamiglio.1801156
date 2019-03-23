package menuString;

/**
 * Un esempio: realizzare un semplice menù
 * 
 * Dovete realizzare la classe Menu, in grado di visualizzare un menu' come questo:
 * 1) Inizia il gioco
 * 2) Carica gioco
 * 3) Aiuto
 * 4) Esci
 * 
 * @author francescopioscognamiglio
 *
 */
public class Menu
{
	
	/**
	 * campo di tipo stringa che contiene le opzioni
	 */
	private String menuText;
	/**
	 * campo di tipo intero che contiene il numero di opzioni
	 */
	private int optionCount;
	
	/**
	 * costruttore della classe
	 */
	public Menu()
	{
		menuText = "";
		optionCount = 0;
	}
	
	/**
	 * metodo che mostra il menu' a video
	 */
	public void display()
	{
		System.out.println(menuText);
	}
	
	/**
	 * metodo che aggiunge un'opzione alla fine del menu'
	 * @param nuovaOpzione l'opzione da aggiungere
	 */
	public void addOption(String option)
	{
		optionCount++;
		menuText += optionCount + ") " + option + "\n";
	}
	
	/**
	 * metodo che restituisce la k-esima opzione del menu'
	 * @param k il numero dell'opzione
	 * @return l'opzione corrispondente al numero k
	 */
	public String getOption(int k)
	{
		String[] opzioni = menuText.split("\n");
		String opzione = opzioni[k-1];
		int pos = opzione.indexOf(") ");
		return opzione.substring(pos + 2);
	}
		
}

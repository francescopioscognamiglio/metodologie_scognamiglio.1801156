package menuArrayList;

import java.util.ArrayList;
import java.util.List;

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
	 * campo di tipo lista di stringhe che contiene le opzioni
	 */
	private List<String> opzioni;
	
	/**
	 * Costruttore della classe vuoto
	 */
	public Menu()
	{
		opzioni = new ArrayList<String>();
	}
	
	/**
	 * metodo che aggiunge un'opzione alla fine del menu'
	 * @param nuovaOpzione l'opzione da aggiungere
	 */
	public void aggiungiOpzione(String nuovaOpzione)
	{
		opzioni.add(nuovaOpzione);
	}
	
	/**
	 * metodo che toglie un'opzione dal menu'
	 * @param togliOpzione l'opzione da togliere
	 */
	public void togliOpzione(String togliOpzione)
	{
		if (opzioni.contains(togliOpzione))
		{
			opzioni.remove(togliOpzione);
		}
	}
	
	/**
	 * metodo che restituisce la k-esima posizione del menu'
	 * @param k il numero dell'opzione
	 * @return l'opzione corrispondente al numero k
	 */
	public String getOpzione(int k)
	{
		return opzioni.get(k);
	}
	
	/**
	 * metodo che mostra il menu' a video
	 */
	public void visualizza()
	{
		String ris = "";
		for (int i = 0; i < opzioni.size(); i++)
		{
			ris += (i > 0 ? "\n" : "") + (i+1) + ") " + opzioni.get(i);
		}
		System.out.println(ris);
	}
	
}

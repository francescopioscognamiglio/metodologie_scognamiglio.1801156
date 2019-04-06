import java.util.ArrayList;

import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Fenice:
 * rappresenta l’uccello mitologico che resuscita dalle ceneri dopo la morte;
 * si preveda quindi un metodo risorgi() che ha l’effetto di far rinascere la fenice
 * 
 * @author francescopioscognamiglio
 *
 */
public class Fenice extends EssereVivente
{
	
	/**
	 * numero massimo di figli
	 */
	public static final int MAX_NUMERO_FIGLI = 1;
	
	/**
	 * costruttore che imposta il sesso e il nome della fenice
	 * @param sesso il sesso della fenice
	 * @param nome il nome della fenice
	 */
	public Fenice(Sesso sesso, String nome)
	{
		super(sesso, nome);
		maxFigli = MAX_NUMERO_FIGLI;
	}
	
	/**
	 * metodo che genera una lista di fenici create
	 * @param numFigli il numero di figli da creare
	 * @return una lista di fenici create
	 */
	@Override
	public ArrayList<EssereVivente> genera(int numFigli)
	{
		ArrayList<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
		
		Random random = new Random();
		for (int i = 0; i < numFigli; i++)
			esemplariFigli.add(new Fenice((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
		
		return esemplariFigli;
	}
	
	/**
	 * metodo che fa risorgere la fenice
	 */
	public void risorgi() { setIsVivo(true); }
	
	/**
	 * metodo che fa morire la fenice
	 */
	@Override
	public void muore()
	{
		super.muore();
		risorgi();
	}
	
	
}

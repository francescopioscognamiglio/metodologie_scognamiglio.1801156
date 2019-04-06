import java.util.ArrayList;

import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Coniglio:
 * rappresenta un coniglio, che si riproduce in al più 10 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class Coniglio extends EssereVivente
{
	
	/**
	 * numero massimo di figli
	 */
	public static final int MAX_NUMERO_FIGLI = 10;
	
	/**
	 * costruttore che imposta il sesso e il nome del coniglio
	 * @param sesso il sesso del coniglio
	 * @param nome il nome del coniglio
	 */
	public Coniglio(Sesso sesso, String nome)
	{
		super(sesso, nome);
		maxFigli = MAX_NUMERO_FIGLI;
	}
	
	/**
	 * metodo che genera una lista di conigli creati
	 * @param numFigli il numero di figli da creare
	 * @return una lista di conigli creati
	 */
	@Override
	public ArrayList<EssereVivente> genera(int numFigli)
	{
		ArrayList<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
		
		Random random = new Random();
		for (int i = 0; i < numFigli; i++)
			esemplariFigli.add(new Coniglio((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
		
		return esemplariFigli;
	}
	
}

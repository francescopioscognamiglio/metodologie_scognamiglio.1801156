import java.util.ArrayList;

import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Pesce:
 * rappresenta un pesce, che si riproduce tra 30 e 100 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class Pesce extends EssereVivente
{
	
	/**
	 * numero minimo di figli
	 */
	public static final int MIN_NUMERO_FIGLI = 30;
	
	/**
	 * numero massimo di figli
	 */
	public static final int MAX_NUMERO_FIGLI = 100;
	
	/**
	 * costruttore che imposta il sesso e il nome del pesce
	 * @param sesso il sesso del pesce
	 * @param nome il nome del pesce
	 */
	public Pesce(Sesso sesso, String nome)
	{
		super(sesso, nome);
		minFigli = MIN_NUMERO_FIGLI;
		maxFigli = MAX_NUMERO_FIGLI;
	}
	
	/**
	 * metodo che restituisce una lista di pesci creati
	 * @param numFigli il numero di figli da creare
	 * @return una lista di pesci creati
	 */
	@Override
	public ArrayList<EssereVivente> genera(int numFigli)
	{
		ArrayList<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
		
		Random random = new Random();
		for (int i = 0; i < numFigli; i++)
			esemplariFigli.add(new Pesce((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
		
		return esemplariFigli;
	}
	
}

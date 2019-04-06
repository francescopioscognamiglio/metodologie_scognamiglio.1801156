import java.util.ArrayList;

import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare Gatto:
 * rappresenta un gatto, che si riproduce in al più 5 esemplari, e che possiede 7 vite
 * (ogni volta che muore, può accedere alla vita successiva)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Gatto extends EssereVivente
{
	
	/**
	 * numero massimo di figli
	 */
	public static final int MAX_NUMERO_FIGLI = 5;
	
	/**
	 * numero massimo di vite di un gatto
	 */
	private static final int NUMERO_MASSIMO_DI_VITE = 7;
	
	/**
	 * numero di vite residue
	 */
	private int viteResidue = NUMERO_MASSIMO_DI_VITE;
	
	/**
	 * costruttore che imposta il sesso e il nome del gatto
	 * @param sesso il sesso del gatto
	 * @param nome il nome del gatto
	 */
	public Gatto(Sesso sesso, String nome)
	{
		super(sesso, nome);
		maxFigli = MAX_NUMERO_FIGLI;
	}
	
	/**
	 * metodo che restituisce una lista di gatti creati
	 * @param numFigli il numero di figli da creare
	 * @return una lista di gatti creati
	 */
	@Override
	public ArrayList<EssereVivente> genera(int numFigli)
	{
		ArrayList<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
		
		Random random = new Random();
		for (int i = 0; i < numFigli; i++)
			esemplariFigli.add(new Gatto((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
		
		return esemplariFigli;
	}
	
	/**
	 * metodo che fa morire il gatto
	 */
	@Override
	public void muore()
	{
		super.muore();
		
		viteResidue--;
		if (viteResidue > 0) setIsVivo(true);
	}
	
}

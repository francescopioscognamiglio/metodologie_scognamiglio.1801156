import java.util.ArrayList;
import java.util.Random;

/**
 * Esercizio: Esseri viventi
 * 
 * Implementare EssereUmano:
 * rappresenta un essere umano: si riproduce in un numero di 1 o 2 esemplari
 * 
 * @author francescopioscognamiglio
 *
 */
public class EssereUmano extends EssereVivente
{
	
	/**
	 * numero massimo di figli
	 */
	public static final int MAX_NUMERO_FIGLI = 2;
	
	/**
	 * costruttore che imposta il sesso e il nome dell'essere umano
	 * @param sesso il sesso dell'essere umano
	 * @param nome il nome dell'essere umano
	 */
	public EssereUmano(Sesso sesso, String nome)
	{
		super(sesso, nome);
		maxFigli = MAX_NUMERO_FIGLI;
	}
	
	/**
	 * metodo che genera una lista di esseri umani creati
	 * @param numFigli il numero di figli da creare
	 * @return una lista di esseri umani creati
	 */
	@Override
	public ArrayList<EssereVivente> genera(int numFigli)
	{
		ArrayList<EssereVivente> esemplariFigli = new ArrayList<EssereVivente>();
		
		Random random = new Random();
		for (int i = 0; i < numFigli; i++)
			esemplariFigli.add(new EssereUmano((random.nextBoolean() ? Sesso.MASCHIO : Sesso.FEMMINA), "figlio" + (i+1)));
		
		return esemplariFigli;
	}
	
}


import java.util.Arrays;
import java.util.Random;

/**
 * Esercizio: mescolare e distribuire un mazzo di carte da gioco
 * 
 * Progettare quindi una classe MazzoDiCarte che rappresenti un intero mazzo da 52 carte
 * 
 * La classe deve implementare i seguenti metodi:
 * - mescola il mazzo di carte
 * - distribuisci la prossima carta
 * 
 * @author francescopioscognamiglio
 *
 */
public class MazzoDiCarte
{
	
	/**
	 * array di tipo Carta
	 */
	private Carta[] mazzoCarte;
	/**
	 * intero che rappresenta la posizione all'interno del mazzo
	 */
	private int posizione;
	
	/**
	 * intero che definisce la dimensione del mazzo di carte
	 */
	static final int dimensione = 52;
	
	/**
	 * costruttore che permette di creare il mazzo carte
	 * @param mazzoCarte una sequenza di oggetti Carta utilizzati per creare il mazzo di carte
	 */
	public MazzoDiCarte(Carta ... mazzoCarte)
	{
		this.mazzoCarte = Arrays.copyOf(mazzoCarte, mazzoCarte.length);
		posizione = 0;
	}
	
	/**
	 * metodo che "mescola" il mazzo di carte
	 */
	public void mescola()
	{
		Carta[] mazzoCarteMescolato = new Carta[dimensione];
		
		Random random = new Random();
		for (int i = 0; i < dimensione; i++)
		{
			int num = random.nextInt(dimensione);
			while (mazzoCarteMescolato[num] != null)
			{
				num = random.nextInt(dimensione);
			}
			mazzoCarteMescolato[num] = mazzoCarte[i];
		}
		mazzoCarte = mazzoCarteMescolato;
	}
	
	/**
	 * metodo che restituisce la prossima carta
	 * @return la prossima carta di tipo Carta
	 */
	public Carta getProssimaCarta()
	{
		return posizione < dimensione ? mazzoCarte[posizione++] : null;
	}
	
}

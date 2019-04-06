import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare inoltre diversi tipi di supporto:
 * - Disco a 33 giri (14 brani)
 * - Disco a 45 giri (2 brani)
 * - Compact Disc (20 brani)
 * - Nastro (con un numero specificato di minuti, numero di brani pari al numero di minuti / 5)
 * - Memoria USB (1024 brani)
 * * Gli ultimi due supporti permettono di registrare/inserire brani nella posizione specificata
 * * Ciascun supporto può contenere il numero massimo di brani specificati tra parentesi nella precedente diapositiva
 * 	 e viene costruito con una data sequenza (eventualmente vuota) di brani
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Supporto
{
	/**
	 * numero di brani
	 */
	protected final int numeroBrani;
	/**
	 * lista di brani
	 */
	protected List<Brano> brani = new ArrayList<Brano>();
	
	/**
	 * costruttore che imposta il numero di brani e la lista di brani del supporto
	 * @param numeroBrani il numero di brani del supporto
	 * @param brani la sequenza di brani del supporto
	 */
	public Supporto(int numeroBrani, Brano ... brani)
	{
		if (brani.length > numeroBrani) brani = Arrays.copyOf(brani, numeroBrani);
		this.brani = Arrays.asList(brani);
		this.numeroBrani = numeroBrani;
	}
	
	/**
	 * metodo che restituisce true se il supporto é pieno; false altrimenti
	 * @return true se il supporto é pieno; false altrimenti
	 */
	protected boolean isPieno() { return brani.size() >= numeroBrani; }
	
	/**
	 * metodo che aggiunge il brano alla fine della lista dei brani del supporto
	 * @param brano il brano da aggiungere
	 * @return true se il brano é stato aggiunto; false altrimenti
	 */
	public boolean aggiungiBrano(Brano brano)
	{
		if (isPieno()) return false;
		return brani.add(brano);
	}
	
	/**
	 * metodo getter che restituisce il brano presente in una specifica posizione del supporto
	 * @param posizione la posizione dalla quale prendere il brano
	 * @return il brano presente in una specifica posizione del supporto
	 */
	public Brano getBrano(int posizione)
	{
		if (posizione < 0 || posizione >= brani.size()) return null;
		return brani.get(posizione);
	}
	
	/**
	 * metodo getter che restituisce il numero di brani del supporto
	 * @return il numero di brani del supporto
	 */
	public int getNumeroBrani()
	{
		return numeroBrani;
	}
}

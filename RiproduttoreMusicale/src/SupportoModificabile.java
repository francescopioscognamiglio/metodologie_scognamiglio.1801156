
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
abstract public class SupportoModificabile extends Supporto
{
	/**
	 * costruttore che imposta il numero di brani e la lista dei brani del supporto modificabile
	 * @param numeroBrani il numero di brani del supporto modificabile
	 * @param brani la lista dei brani del supporto modificabile
	 */
	public SupportoModificabile(int numeroBrani, Brano ... brani)
	{
		super(numeroBrani, brani);
	}
	
	/**
	 * metodo che aggiunge il brano in una posizione specifica della lista dei brani del supporto
	 * @param brano il brano da aggiungere
	 * @param posizione la posizione in cui aggiungere il brano
	 * @return true se il brano é stato aggiunto; false altrimenti
	 */
	public boolean aggiungiBrano(Brano brano, int posizione)
	{
		if (isPieno()) return false;
		brani.add(posizione, brano);
		return true;
	}
}

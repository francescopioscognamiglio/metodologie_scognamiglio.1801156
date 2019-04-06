
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il supporto Nastro
 * (con un numero specificato di minuti, numero di brani pari al numero di minuti / 5)
 * 
 * @author francescopioscognamiglio
 *
 */
public class Nastro extends SupportoModificabile
{
	/**
	 * costruttore che imposta il numero di minuti e la lista di brani del nastro
	 * @param numeroMinuti il numero di minuti del nastro
	 * @param brani la sequenza dei brani del nastro
	 */
	public Nastro(int numeroMinuti, Brano ... brani)
	{
		super(numeroMinuti/5, brani);
	}
}

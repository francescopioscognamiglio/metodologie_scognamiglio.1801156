
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il supporto Memoria USB (1024 brani)
 * 
 * @author francescopioscognamiglio
 *
 */
public class MemoriaUSB extends SupportoModificabile
{
	/**
	 * numero di brani della memoria USB
	 */
	private static final int NUMERO_BRANI = 1024;
	
	/**
	 * costruttore che imposta la lista di brani della memoria USB
	 * @param brani la sequenza dei brani della memoria USB
	 */
	public MemoriaUSB(Brano ... brani)
	{
		super(NUMERO_BRANI, brani);
	}
}

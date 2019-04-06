
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il supporto Compact Disc (20 brani)
 * 
 * @author francescopioscognamiglio
 *
 */
public class DiscoCompatto extends Supporto
{
	/**
	 * numero di brani del disco compatto
	 */
	private static final int NUMERO_BRANI = 20;
	
	/**
	 * costruttore che imposta la lista di brani del disco compatto
	 * @param brani la sequenza dei brani del disco compatto
	 */
	public DiscoCompatto(Brano ... brani)
	{
		super(NUMERO_BRANI, brani);
	}
}

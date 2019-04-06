
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il supporto Disco a 33 giri (14 brani)
 * 
 * @author francescopioscognamiglio
 *
 */
public class DiscoA33Giri extends Supporto
{
	/**
	 * numero di brani del disco a 33 giri
	 */
	private static final int NUMERO_BRANI = 14;
	
	/**
	 * costruttore che imposta la lista di brani del disco a 33 giri
	 * @param brani la sequenza dei brani del disco a 33 giri
	 */
	public DiscoA33Giri(Brano ... brani)
	{
		super(NUMERO_BRANI, brani);
	}
}

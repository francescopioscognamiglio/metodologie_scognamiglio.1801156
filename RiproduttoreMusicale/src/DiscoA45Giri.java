
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il supporto Disco a 45 giri (2 brani)
 * 
 * @author francescopioscognamiglio
 *
 */
public class DiscoA45Giri extends Supporto
{
	/**
	 * numero di brani del disco a 45 giri
	 */
	private static final int NUMERO_BRANI = 2;
	
	/**
	 * costruttore che imposta la lista di brani del disco a 45 giri
	 * @param brani la sequenza dei brani del disco a 45 giri
	 */
	public DiscoA45Giri(Brano ... brani)
	{
		super(NUMERO_BRANI, brani);
	}
}


/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Eccezione che viene invocata se il riproduttore musicale non supporta il supporto
 * 
 * @author francescopioscognamiglio
 *
 */
public class SupportoNonSupportatoException extends Exception
{
	/**
	 * costruttore che imposta il nome del riproduttore musicale e del supporto dell'eccezione
	 * @param riproduttoreMusicale il nome del riproduttore musicale
	 * @param supporto il nome del supporto
	 */
	public SupportoNonSupportatoException(String riproduttoreMusicale, String supporto)
	{
		super(riproduttoreMusicale + " non supporta " + supporto);
	}
}


/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il riproduttore musicale Lettore Mp3
 * 
 * @author francescopioscognamiglio
 *
 */
public class LettoreMP3 extends RiproduttoreMusicale
{
	/**
	 * metodo che inserisce il supporto utilizzato dal lettore MP3
	 * @param supporto il supporto utilizzato dal lettore MP3
	 */
	@Override
	public void inserisciSupporto(Supporto supporto) throws SupportoNonSupportatoException
	{
		if (!(supporto instanceof MemoriaUSB)) throw new SupportoNonSupportatoException(getClass().getSimpleName(), supporto.getClass().getSimpleName());
		super.supporto = supporto;
	}
}

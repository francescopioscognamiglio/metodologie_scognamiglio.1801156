
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il riproduttore musicale Lettore CD
 * 
 * @author francescopioscognamiglio
 *
 */
public class LettoreCD extends RiproduttoreMusicale
{
	/**
	 * metodo che inserisce il supporto utilizzato dal lettore CD
	 * @param supporto il supporto utilizzato dal lettore CD
	 */
	@Override
	public void inserisciSupporto(Supporto supporto) throws SupportoNonSupportatoException
	{
		if (!(supporto instanceof DiscoCompatto)) throw new SupportoNonSupportatoException(getClass().getSimpleName(), supporto.getClass().getSimpleName());
		super.supporto = supporto;
	}
}


/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il riproduttore musicale Mangianastri
 * 
 * @author francescopioscognamiglio
 *
 */
public class Mangianastri extends RiproduttoreMusicale
{
	/**
	 * metodo che inserisce il supporto utilizzato dal mangianastri
	 * @param supporto il supporto utilizzato dal mangianastri
	 */
	@Override
	public void inserisciSupporto(Supporto supporto) throws SupportoNonSupportatoException
	{
		if (!(supporto instanceof Nastro)) throw new SupportoNonSupportatoException(getClass().getSimpleName(), supporto.getClass().getSimpleName());
		super.supporto = supporto;
	}
}

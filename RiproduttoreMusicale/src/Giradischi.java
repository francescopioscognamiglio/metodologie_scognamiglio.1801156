
/**
 * Esercizio: RiproduttoreMusicale
 * 
 * Realizzare il riproduttore musicale Giradischi
 * 
 * @author francescopioscognamiglio
 *
 */
public class Giradischi extends RiproduttoreMusicale
{
	/**
	 * metodo che inserisce il supporto utilizzato dal giradischi
	 * @param supporto il supporto utilizzato dal giradischi
	 */
	@Override
	public void inserisciSupporto(Supporto supporto) throws SupportoNonSupportatoException
	{
		if (!(supporto instanceof DiscoA33Giri) && !(supporto instanceof DiscoA45Giri)) throw new SupportoNonSupportatoException(getClass().getSimpleName(), supporto.getClass().getSimpleName());
		super.supporto = supporto;
	}
}
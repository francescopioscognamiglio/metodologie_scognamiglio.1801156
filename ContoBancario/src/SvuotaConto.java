
/**
 * Esercizio: Conto bancario
 * 
 * Modellare l'operazione SvuotaConto che preleva tutto il denaro da un dato conto
 * 
 * @author francescopioscognamiglio
 *
 */
public class SvuotaConto extends Operazione
{
	
	/**
	 * costruttore che imposta il conto bancario
	 * @param contoBancario il conto bancario
	 */
	public SvuotaConto(ContoBancario contoBancario)
	{
		super(contoBancario);
	}
	
	/**
	 * metodo che esegue l'operazione
	 */
	@Override
	public void esegui()
	{
		contoBancario.setDenaro(0.0);
	}
	
	/**
	 * metodo che restituisce una rappresentazione sotto forma di stringa dell'operazione
	 * @return String una rappresentazione sotto forma di stringa dell'operazione
	 */
	@Override
	public String toString()
	{
		return "Svuotamento conto " + contoBancario.getIban();
	}
	
}

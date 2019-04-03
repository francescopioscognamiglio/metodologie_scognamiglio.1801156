
/**
 * Esercizio: Conto bancario
 * 
 * Modellare l'operazione SituazioneConto che stampa l’attuale saldo del conto
 * 
 * @author francescopioscognamiglio
 *
 */
public class SituazioneConto extends Operazione
{
	
	/**
	 * costruttore che imposta il conto bancario
	 * @param contoBancario il conto bancario
	 */
	public SituazioneConto(ContoBancario contoBancario)
	{
		super(contoBancario);
	}
	
	/**
	 * metodo che esegue l'operazione
	 */
	@Override
	public void esegui()
	{
		System.out.println("Il conto contiene " + contoBancario.getDenaro() + " euro.");
	}
	
	/**
	 * metodo che restituisce una rappresentazione sotto forma di stringa dell'operazione
	 * @return String una rappresentazione sotto forma di stringa dell'operazione
	 */
	@Override
	public String toString()
	{
		return "Situazione conto " + contoBancario.getIban();
	}
	
}

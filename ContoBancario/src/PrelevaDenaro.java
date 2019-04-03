
/**
 * Esercizio: Conto bancario
 * 
 * Modellare l'operazione PrelevaDenaro che preleva una specificata quantità di denaro da un dato conto
 * 
 * @author francescopioscognamiglio
 *
 */
public class PrelevaDenaro extends Operazione
{
	
	/**
	 * denaro da prelevare
	 */
	private double denaroDaPrelevare;
	
	/**
	 * costruttore che imposta il conto bancario e il denaro da prelevare
	 * @param contoBancario il conto bancario
	 * @param denaroDaPrelevare il denaro da prelevare
	 */
	public PrelevaDenaro(ContoBancario contoBancario, double denaroDaPrelevare)
	{
		super(contoBancario);
		this.denaroDaPrelevare = denaroDaPrelevare;
	}
	
	/**
	 * metodo che esegue l'operazione
	 */
	@Override
	public void esegui()
	{
		if (denaroDaPrelevare > contoBancario.getDenaro()) return;
		contoBancario.setDenaro(contoBancario.getDenaro()-denaroDaPrelevare);
	}
	
	/**
	 * metodo che restituisce una rappresentazione sotto forma di stringa dell'operazione
	 * @return String una rappresentazione sotto forma di stringa dell'operazione
	 */
	@Override
	public String toString()
	{
		return "Prelevamento denaro dal conto " + contoBancario.getIban();
	}
	
}

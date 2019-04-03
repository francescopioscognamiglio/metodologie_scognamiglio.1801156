
/**
 * Esercizio: Conto bancario
 * 
 * Modellare l'operazione VersaDenaro che versa del denaro sul conto specificato
 * 
 * @author francescopioscognamiglio
 *
 */
public class VersaDenaro extends Operazione
{
	
	/**
	 * denaro da versare
	 */
	private double denaroDaVersare;
	
	/**
	 * costruttore che imposta il conto bancario e il denaro da versare
	 * @param contoBancario il conto bancario
	 * @param denaroDaVersare il denaro da versare
	 */
	public VersaDenaro(ContoBancario contoBancario, double denaroDaVersare)
	{
		super(contoBancario);
		this.denaroDaVersare = denaroDaVersare;
	}
	
	/**
	 * metodo che esegue l'operazione
	 */
	@Override
	public void esegui()
	{
		contoBancario.setDenaro(contoBancario.getDenaro()+denaroDaVersare);
	}
	
	/**
	 * metodo che restituisce una rappresentazione sotto forma di stringa dell'operazione
	 * @return String una rappresentazione sotto forma di stringa dell'operazione
	 */
	@Override
	public String toString()
	{
		return "Versamento denaro sul conto " + contoBancario.getIban();
	}
	
}

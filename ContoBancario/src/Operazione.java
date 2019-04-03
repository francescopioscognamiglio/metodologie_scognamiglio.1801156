
/**
 * Esercizio: Conto bancario
 * 
 * Modellare quindi una generica operazione bancaria Operazione che disponga di un metodo esegui()
 * Modellare quindi i seguenti tipi di operazione:
 * - PrelevaDenaro: preleva una specificata quantità di denaro da un dato conto
 * - SvuotaConto: preleva tutto il denaro da un dato conto
 * - VersaDenaro: versa del denaro sul conto specificato
 * - SituazioneConto: stampa l’attuale saldo del conto
 * - Bonifico: preleva del denaro da un conto e lo versa su un altro
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Operazione
{
	
	/**
	 * conto bancario sul quale eseguire l'operazione
	 */
	protected ContoBancario contoBancario;
	
	/**
	 * costruttore che imposta il conto bancario
	 * @param contoBancario il conto bancario
	 */
	public Operazione(ContoBancario contoBancarioCorrente)
	{
		contoBancario = contoBancarioCorrente;
	}
	
	/**
	 * metodo getter che restituisce il conto bancario
	 * @return il conto bancario
	 */
	public ContoBancario getContoBancario()
	{
		return contoBancario;
	}
	
	/**
	 * metodo astratto che esegue l'operazione
	 */
	abstract public void esegui();
	
}

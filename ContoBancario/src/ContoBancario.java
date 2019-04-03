import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio: Conto bancario
 * 
 * Progettare la classe ContoBancario che rappresenti un conto con informazioni
 * relative al denaro attualmente disponibile, il codice IBAN
 * 
 * Modellare quindi una generica operazione bancaria Operazione che disponga di un metodo esegui()
 * Modellare quindi i seguenti tipi di operazione:
 * - PrelevaDenaro: preleva una specificata quantità di denaro da un dato conto
 * - SvuotaConto: preleva tutto il denaro da un dato conto
 * - VersaDenaro: versa del denaro sul conto specificato
 * - SituazioneConto: stampa l’attuale saldo del conto
 * - Bonifico: preleva del denaro da un conto e lo versa su un altro
 * 
 * Specificare un metodo nella classe ContoBancario che
 * restituisca l'elenco delle operazioni svolte in ordine temporale
 * 
 * @author francescopioscognamiglio
 *
 */
public class ContoBancario
{
	
	/**
	 * codice iban del conto bancario
	 */
	private String iban;
	
	/**
	 * denaro contenuto nel conto bancario
	 */
	private double denaro;
	
	/**
	 * storico delle operazioni effettuate dal conto bancario
	 */
	private List<Operazione> storicoOperazioni = new ArrayList<Operazione>();
	
	/**
	 * costruttore che imposta il codice iban
	 * @param iban il codice iban
	 */
	public ContoBancario(String iban)
	{
		this(iban, 0.0);
	}
	
	/**
	 * costruttore che imposta il codice iban e il denaro iniziale
	 * @param iban il codice iban
	 * @param denaroIniziale il denaro iniziale
	 */
	public ContoBancario(String iban, double denaroIniziale)
	{
		this.iban = iban;
		denaro = denaroIniziale;
	}
	
	/**
	 * metodo che restituisce il codice iban del conto bancario
	 * @return il codice iban del conto bancario
	 */
	public String getIban()
	{
		return iban;
	}
	
	/**
	 * metodo setter che imposta il denaro del conto bancario
	 * @param denaro il denaro del conto bancario
	 */
	void setDenaro(double denaro)
	{
		this.denaro = denaro;
	}
	
	/**
	 * metodo getter che restituisce il denaro presente nel conto bancario
	 * @return il denaro presente nel conto bancario
	 */
	double getDenaro()
	{
		return denaro;
	}
	
	public void eseguiOperazione(Operazione o) throws Exception
	{
		// verificare che il ContoBancario attuale sia lo stesso di quello sul quale vogliamo eseguire l'operazione
		if (!o.getContoBancario().equals(this))
			throw new Exception("Operazione svolta sul conto errato.");
		o.esegui();
		storicoOperazioni.add(o);
	}
	
	/**
	 * metodo che restituisce una lista che contiene lo storico delle operazioni effettuate dal conto bancario
	 * @return una lista che contiene lo storico delle operazioni effettuate dal conto bancario
	 */
	public List<Operazione> getStorico()
	{
		return new ArrayList<>(storicoOperazioni);
	}
	
}

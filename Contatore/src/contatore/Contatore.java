/**
 * Esercizio: Un contatore
 * Vogliamo realizzare una classe che rappresenta un contatore
 * 
 * Il contatore permette di:
 * - Incrementare il conteggio attuale
 * - Ottenere il conteggio attuale
 * - Resettare il conteggio a 0 (o a un altro valore)
 * @author francescopioscognamiglio
 *
 */
public class Contatore
{
	
	/**
	 * valore intero del contatore
	 */
	private int valore;
	
	/**
	 * costruttore della classe vuoto
	 */
	public Contatore() 
	{
		this(0);
	}
	
	/**
	 * costruttore della classe che permette di definire il valore del contatore
	 * @param valore il valore del contatore
	 */
	public Contatore(int valore)
	{
		this.valore = valore;
	}
	
	/**
	 * metodo che restituisce il valore del contatore
	 * @return valore intero del contatore
	 */
	public int getValore()
	{
		return this.valore;
	}
	
	/**
	 * metodo che incrementa il valore del contatore
	 */
	public void incrementa()
	{
		this.valore++;
	}
	
	/**
	 * metodo che decrementa il valore del contatore
	 */
	public void decrementa()
	{
		this.valore--;
	}
	
	/**
	 * metodo che resetta il valore del contatore
	 */
	public void reset()
	{
		reset(0);
	}
	
	/**
	 * metodo che reimposta il valore del contatore ad un nuovo valore
	 * @param nuovoValue il nuovo valore
	 */
	public void reset(int nuovoValue)
	{
		this.valore = nuovoValue;
	}
	
}

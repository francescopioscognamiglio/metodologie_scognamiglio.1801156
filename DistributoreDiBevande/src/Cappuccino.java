
/**
 * Esercizio: Distributore di bevande
 * 
 * Progettare una classe Cappuccino
 * 
 * @author francescopioscognamiglio
 *
 */
public class Cappuccino extends Prodotto
{
	
	/**
	 * prezzo del cappuccino
	 */
	public static final double PREZZO = 1.4;
	
	/**
	 * costruttore che imposta il prezzo del cappuccino
	 * @param prezzo il prezzo del cappuccino
	 */
	public Cappuccino()
	{
		super(PREZZO);
	}
	
}

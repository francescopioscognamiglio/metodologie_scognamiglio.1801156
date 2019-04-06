
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe EspressioneNegata
 * 
 * @author francescopioscognamiglio
 *
 */
public class EspressioneNegata extends Espressione
{
	
	/**
	 * espressione dell'espressione negata
	 */
	private Espressione espressione;
	
	/**
	 * costruttore che imposta l'espressione dell'espressione negata
	 * @param espressione l'espressione dell'espressione negata
	 */
	public EspressioneNegata(Espressione espressione)
	{
		this.espressione = espressione;
	}
	
	/**
	 * metodo getter che restituisce il valore dell'espressione negata
	 * @return il valore dell'espressione negata
	 */
	@Override
	public double getValore()
	{
		return(0-espressione.getValore());
	}
	
}

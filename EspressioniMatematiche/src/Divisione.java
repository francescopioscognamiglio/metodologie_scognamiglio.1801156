
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Divisione
 * 
 * @author francescopioscognamiglio
 *
 */
public class Divisione extends EspressioneBinaria
{
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 della divisione
	 * @param espressione1 la prima espressione della divisione
	 * @param espressione2 la seconda espressione della divisione
	 */
	public Divisione(Espressione espressione1, Espressione espressione2)
	{
		super(espressione1, espressione2);
	}
	
	/**
	 * metodo getter che restituisce il valore della divisione
	 * @return il valore della divisione
	 */
	@Override
	public double getValore()
	{
		return espressione1.getValore()/espressione2.getValore();
	}
	
}

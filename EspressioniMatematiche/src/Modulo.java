
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Modulo
 * 
 * @author francescopioscognamiglio
 *
 */
public class Modulo extends EspressioneBinaria
{
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 del modulo
	 * @param espressione1 la prima espressione del modulo
	 * @param espressione2 la seconda espressione del modulo
	 */
	public Modulo(Espressione espressione1, Espressione espressione2)
	{
		super(espressione1, espressione2);
	}
	
	/**
	 * metodo getter che restituisce il valore del modulo
	 * @return il valore del modulo
	 */
	@Override
	public double getValore()
	{
		return espressione1.getValore()%espressione2.getValore();
	}
	
}


/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Addizione
 * 
 * @author francescopioscognamiglio
 *
 */
public class Addizione extends EspressioneBinaria
{
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 dell'addizione
	 * @param espressione1 la prima espressione dell'addizione
	 * @param espressione2 la seconda espressione dell'addizione
	 */
	public Addizione(Espressione espressione1, Espressione espressione2)
	{
		super(espressione1, espressione2);
	}
	
	/**
	 * metodo getter che restituisce il valore dell'addizione
	 * @return il valore dell'addizione
	 */
	@Override
	public double getValore()
	{
		return espressione1.getValore()+espressione2.getValore();
	}
	
}

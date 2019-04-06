
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Sottrazione
 * 
 * @author francescopioscognamiglio
 *
 */
public class Sottrazione extends EspressioneBinaria
{
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 della sottrazione
	 * @param espressione1 la prima espressione della sottrazione
	 * @param espressione2 la seconda espressione della sottrazione
	 */
	public Sottrazione(Espressione espressione1, Espressione espressione2)
	{
		super(espressione1, espressione2);
	}
	
	/**
	 * metodo getter che restituisce il valore della sottrazione
	 * @return il valore della sottrazione
	 */
	@Override
	public double getValore()
	{
		return espressione1.getValore()-espressione2.getValore();
	}
	
}

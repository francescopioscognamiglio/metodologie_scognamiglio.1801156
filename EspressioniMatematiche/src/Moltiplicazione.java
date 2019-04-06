
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Moltiplicazione
 * 
 * @author francescopioscognamiglio
 *
 */
public class Moltiplicazione extends EspressioneBinaria
{
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 della moltiplicazione
	 * @param espressione1 la prima espressione della moltiplicazione
	 * @param espressione2 la seconda espressione della moltiplicazione
	 */
	public Moltiplicazione(Espressione espressione1, Espressione espressione2)
	{
		super(espressione1, espressione2);
	}
	
	/**
	 * metodo getter che restituisce il valore della moltiplicazione
	 * @return il valore della moltiplicazione
	 */
	@Override
	public double getValore()
	{
		return espressione1.getValore()*espressione2.getValore();
	}
	
}

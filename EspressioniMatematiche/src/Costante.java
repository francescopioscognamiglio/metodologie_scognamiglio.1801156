
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Costante
 * 
 * @author francescopioscognamiglio
 *
 */
public class Costante extends Espressione
{
	
	/**
	 * valore della costante
	 */
	private double valore;
	
	/**
	 * costruttore che imposta il valore della costante
	 * @param valore il valore della costante
	 */
	public Costante(double valore)
	{
		this.valore = valore;
	}
	
	/**
	 * metodo getter che restituisce il valore della costante
	 * @return il valore della costante
	 */
	@Override
	public double getValore()
	{
		return valore;
	}
	
}

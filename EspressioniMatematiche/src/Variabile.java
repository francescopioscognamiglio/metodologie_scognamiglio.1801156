
/**
 * Esercizio: Espressioni matematiche
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Progettare la classe Variabile
 * 
 * @author francescopioscognamiglio
 *
 */
public class Variabile extends Espressione
{
	
	/**
	 * nome della variabile
	 */
	private String nome;
	
	/**
	 * valore della variabile
	 */
	private double valore;
	
	/**
	 * costruttore che imposta il nome e il valore della variabile
	 * @param nome il nome della variabile
	 * @param valore il valore della variabile
	 */
	public Variabile(String nome, double valore)
	{
		this.nome = nome;
		this.valore = valore;
	}
	
	/**
	 * metodo setter che imposta il valore della variabile
	 * @param valore il valore della variabile
	 */
	public void setValore(double valore)
	{
		this.valore = valore;
	}
	
	/**
	 * metodo getter che restituisce il nome della variabile
	 * @return il nome della variabile
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * metodo getter che restituisce il valore della variabile
	 * @return il valore della variabile
	 */
	@Override
	public double getValore()
	{
		return valore;
	}
	
}

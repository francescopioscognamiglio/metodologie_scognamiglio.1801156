
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
	
	String nome;
	
	public Variabile(String nome, double valore)
	{
		super(valore);
		this.nome = nome;
	}
	
	@Override
	public void setValore(double valore)
	{
		super.setValore(valore);
	}
	
}

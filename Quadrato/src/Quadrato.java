
/**
 * Esercizi di riscaldamento
 * 
 * Progettare una classe Quadrato, i cui oggetti sono costruiti con il lato dello stesso
 * - La classe è dotata di un metodo getPerimetro che restituisce il perimetro
 * - E di un metodo main che crea un quadrato di lato 4 e ne stampa a video il perimetro
 * 
 * @author francescopioscognamiglio
 *
 */
public class Quadrato
{
	
	/**
	 * campo di tipo double che definisce il lato del quadrato
	 */
	private double lato;
	
	/**
	 * costruttore della classe che permette di definire il lato del quadrato
	 * @param lato il valore double del lato del quadrato
	 */
	public Quadrato(double lato)
	{
		this.lato = lato;
	}
	
	/**
	 * metodo che imposta il lato del quadrato al nuovo valore
	 * @param lato il nuovo valore intero del lato del quadrato
	 */
	public void setLato(double lato)
	{
		this.lato = lato;
	}
	
	/**
	 * metodo che restituisce il lato del quadrato
	 * @return il valore double del lato del quadrato
	 */
	public double getLato()
	{
		return lato;
	}
	
	/**
	 * metodo che restituisce il perimetro del quadrato
	 * @return il valore double del perimetro del quadrato
	 */
	public double getPeremitro()
	{
		return lato*4;
	}
	
	public static void main(String args[])
	{
		Quadrato quadrato = new Quadrato(4);
		
		System.out.println("Il perimetro del quadrato e': " + quadrato.getPeremitro());
		
	}
	
}

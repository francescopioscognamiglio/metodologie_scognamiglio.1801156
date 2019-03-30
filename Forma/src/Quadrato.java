
/**
 * Esempio Ereditarietà: Forma
 * 
 * Progettare una classe Quadrato che estenda la classe Forma
 * 
 * @author francescopioscognamiglio
 *
 */
public class Quadrato extends Forma
{
	
	/**
	 * lato del quadrato
	 */
	private double lato;
	
	/**
	 * costruttore che permette di definire il lato del quadrato
	 * @param lato il del quadrato
	 */
	public Quadrato(double lato)
	{
		this.lato = lato;
	}
	
	/**
	 * metodo che restituisce il lato del quadrato
	 * @return il lato del quadrato
	 */
	public double getLato()
	{
		return lato;
	}
	
	@Override
	public double getPerimetro()
	{
		return lato*4;
	}
	
	@Override
	public double getArea()
	{
		return lato*lato;
	}
	
}

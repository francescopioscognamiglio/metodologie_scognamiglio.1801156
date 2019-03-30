
/**
 * Esempio Ereditarietà: Forma
 * 
 * Progettare una classe Cerchio che estenda la classe Forma
 * 
 * @author francescopioscognamiglio
 *
 */
public class Cerchio extends Forma
{
	
	/**
	 * raggio del cerchio
	 */
	private double raggio;
	
	/**
	 * costruttore che permette di definire il raggio del cerchio
	 * @param raggio il raggio del cerchio
	 */
	public Cerchio(double raggio)
	{
		this.raggio = raggio;
	}
	
	/**
	 * metodo che restituisce il raggio del cerchio
	 * @return il raggio del cerchio
	 */
	public double getRaggio()
	{
		return raggio;
	}
	
	/**
	 * metodo che restituisce il perimetro del cerchio
	 * @return il perimetro del cerchio
	 */
	@Override
	public double getPerimetro()
	{
		return 2*Math.PI*raggio;
	}
	
	/**
	 * metodo che restituisce l'area del cerchio
	 * @return l'area del cerchio
	 */
	@Override
	public double getArea()
	{
		return Math.PI*raggio*raggio;
	}
	
}

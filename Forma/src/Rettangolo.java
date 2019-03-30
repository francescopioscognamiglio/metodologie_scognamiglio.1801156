
/**
 * Esempio Ereditarietà: Forma
 * 
 * Progettare una classe Rettangolo che estenda la classe Forma
 * 
 * @author francescopioscognamiglio
 *
 */
public class Rettangolo extends Forma
{
	
	/**
	 * base del rettangolo
	 */
	private double base;
	/**
	 * altezza del rettangolo
	 */
	private double altezza;
	
	/**
	 * costruttore che permette di definire la base e l'altezza del rettangolo
	 * @param base la base del rettangolo
	 * @param altezza l'altezza del rettangolo
	 */
	public Rettangolo(double base, double altezza)
	{
		this.base = base;
		this.altezza = altezza;
	}
	
	/**
	 * metodo che restituisce la base del rettangolo
	 * @return la base del rettangolo
	 */
	public double getBase()
	{
		return base;
	}
	
	/**
	 * metodo che restituisce l'altezza del rettangolo
	 * @return l'altezza del rettangolo
	 */
	public double getAltezza()
	{
		return altezza;
	}
	
	@Override
	public double getPerimetro()
	{
		return 2*(base+altezza);
	}
	
	@Override
	public double getArea()
	{
		return base*altezza;
	}
	
}

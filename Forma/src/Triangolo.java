
/**
 * Esempio Ereditarietà: Forma
 * 
 * Progettare una classe Triangolo che estenda la classe Forma
 * 
 * @author francescopioscognamiglio
 *
 */
public class Triangolo extends Forma
{
	
	/**
	 * lati del triangolo
	 */
	private double base;
	private double lato2;
	private double lato3;
	/**
	 * altezza del triangolo
	 */
	private double altezza;
	
	/**
	 * costruttore che permette di definire la base, gli altri due lati e l'altezza del triangolo
	 * @param base la base del triangolo
	 * @param lato2 il secondo lato
	 * @param lato3 il terzo lato
	 * @param altezza l'altezza del triangolo
	 */
	public Triangolo(double base, double lato2, double lato3, double altezza)
	{
		this.base = base;
		this.lato2 = lato2;
		this.lato3 = lato3;
		this.altezza = altezza;
	}
	
	/**
	 * metodo che restituisce la base del triangolo
	 * @return la base del triangolo
	 */
	public double getBase()
	{
		return base;
	}
	
	/**
	 * metodo che restituisce il secondo lato del triangolo
	 * @return il secondo lato del triangolo
	 */
	public double getLato2()
	{
		return lato2;
	}
	
	/**
	 * metodo che restituisce il terzo lato del triangolo
	 * @return il terzo lato del triangolo
	 */
	public double getLato3()
	{
		return lato3;
	}
	
	/**
	 * metodo che restituisce l'altezza del triangolo
	 * @return l'altezza del triangolo
	 */
	public double getAltezza()
	{
		return altezza;
	}
	
	/**
	 * metodo che restituisce il perimetro del triangolo
	 * @return il perimetro del triangolo
	 */
	@Override
	public double getPerimetro()
	{
		return base+lato2+lato3;
	}
	
	/**
	 * metodo che restituisce l'area del triangolo
	 * @return l'area del triangolo
	 */
	@Override
	public double getArea()
	{
		return base*altezza/2;
	}
	
}

package annobisestile;
/**
 * Verificare se un anno è bisestile.
 * @author francescopioscognamiglio
 *
 */
public class AnnoBisestile
{
	
	/**
	 * metodo che restituisce true se un anno è bisestile; false altrimenti
	 * @return true se un anno è bisestile; false altrimenti
	 */
	public static boolean isAnnoBisestile(String annoInput)
	{
		int anno = Integer.parseInt(annoInput);
		return (anno % 4 == 0 && anno % 100 != 0) || (anno % 400 == 0);
	}
	
	public static void main(String[] args)
	{
		for (String arg : args)
		{
			boolean bBisestile = isAnnoBisestile(arg);
			System.out.println("L'anno " + arg + " e' bisestile? " + bBisestile);
		}
	}
	
}

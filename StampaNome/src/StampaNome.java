
/**
 * Scrivere una classe StampaNome che,
 * dato in input uno o più nomi,
 * li stampi tra due righe di trattini.
 * Ad es.:
 * +---------+
 * Roberto
 * +---------+
 * @author francescopioscognamiglio
 *
 */
public class StampaNome
{
	
	public static void main(String[] args)
	{
		final String trattini = "+---------+";
		
		for (String nome : args)
		{
			System.out.println(trattini);
			System.out.println(nome);
			System.out.println(trattini);
		}
	}
	
}

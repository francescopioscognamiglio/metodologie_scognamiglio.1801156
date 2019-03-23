
/**
 * Esercizi per cominciare
 * 
 * Scrivere una classe StampaNome che, dato in input un nome,
 * lo stampi tra due righe di trattini.
 * 
 * Ad es.:
 * +---------+
 * Roberto
 * +---------+
 * 
 * @author francescopioscognamiglio
 *
 */
public class StampaNome
{
	
	public static void main(String[] args)
	{
		final String trattini = "+---------+";
		
		String nome = args[0];
		
		System.out.println(trattini);
		System.out.println(nome);
		System.out.println(trattini);
	}
	
}

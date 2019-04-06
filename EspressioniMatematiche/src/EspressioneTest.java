
/**
 * Esercizio: Espressioni matematiche
 * 
 * Costruire quindi diverse espressioni e controllarne il valore
 * 
 * @author francescopioscognamiglio
 *
 */
public class EspressioneTest
{
	
	public static void main(String[] args)
	{
		// -(5*x)+y
		// new EspressioneNegata(new Somma(new Moltiplicazione(5, new Variabile("x", 3)), new Variabile("y", 5)))
		Espressione e = new Addizione(new EspressioneNegata(new Moltiplicazione(new Costante(5), new Variabile("x", 3))), new Variabile("y", 5));
		System.out.println("Il valore dell'espressione -(5*x) + y con x=3 e y=5 e': " + e.getValore());
		
		// -(5+(3/2)-2)*x valore quando la variabile x vale 3 e quando la variabile x vale 6
		Variabile x = new Variabile("x", 3);
		Espressione e1 =
				new Moltiplicazione(
						new EspressioneNegata(
								new Sottrazione(
										new Addizione(
												new Costante(5),
												new Divisione(
														new Costante(3),
														new Costante(2))),
										new Costante(2))),
						x);
		System.out.println("Il valore dell'espressione -(5+(3/2)-2)*x con x=3 e': " + e1.getValore());
		x.setValore(6);
		System.out.println("Il valore dell'espressione -(5+(3/2)-2)*x con x=6 e': " + e1.getValore());
	}
	
}


/**
 * Esercizio: Espressioni matematiche
 * 
 * Costruire quindi l’espressione –(5+(3/2)-2)*x e calcolarne il valore quando la variabile x vale 3 e quando la variabile x vale 6
 * 
 * @author francescopioscognamiglio
 *
 */
public class EspressioneTest
{
	
	public static void main(String[] args)
	{
		Costante costante1 = new Costante(3.0);
		Costante costante2 = new Costante(2.0);
		EspressioneComposta espressioneComposta1 = new EspressioneComposta(costante1, EspressioneComposta.Operatore.DIVISIONE, costante2);
		
		Costante costante3 = new Costante(5.0);
		EspressioneComposta espressioneComposta2 = new EspressioneComposta(costante3, EspressioneComposta.Operatore.ADDIZIONE, espressioneComposta1);
		
		Costante costante4 = new Costante(2.0);
		EspressioneComposta espressioneComposta3 = new EspressioneComposta(espressioneComposta2, EspressioneComposta.Operatore.SOTTRAZIONE, costante4);
		
		Costante costante5 = new Costante(0.0);
		EspressioneComposta espressioneComposta4 = new EspressioneComposta(costante5, EspressioneComposta.Operatore.SOTTRAZIONE, espressioneComposta3);
		
		Variabile variabile1 = new Variabile("x", 3);
		EspressioneComposta espressioneComposta5 = new EspressioneComposta(espressioneComposta4, EspressioneComposta.Operatore.MOLTIPLICAZIONE, variabile1);
		
		System.out.println("Il valore dell'espressione \"–(5+(3/2)-2)*x\" con x=3 e': " + espressioneComposta5.getValore());
		variabile1.setValore(6);
		espressioneComposta5 = new EspressioneComposta(espressioneComposta4, EspressioneComposta.Operatore.MOLTIPLICAZIONE, variabile1);
		System.out.println("Il valore dell'espressione \"–(5+(3/2)-2)*x\" con x=6 e': " + espressioneComposta5.getValore());
	}
	
}

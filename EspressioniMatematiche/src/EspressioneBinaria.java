
/**
 * Esercizio: Espressioni matematiche
 * 
 * Progettare una serie di classi che modellino le espressioni matematiche secondo la seguente definizione:
 * 	- Una costante di tipo double è un’espressione
 * 	- Una variabile con nome di tipo stringa e valore double è un’espressione
 * 	- Se e1 è un’espressione, allora -e1 è un’espressione
 * 	- Se e1 , e2 sono espressioni, allora e1 op e2 è un’espressione dove op può essere l’operatore +, -, *, /, %
 * 
 * Ogni tipo di espressione (costante, variabile, espressioni composte) deve essere modellata mediante una classe separata
 * 
 * Ogni espressione dispone del metodo getValore() che restituisce il valore che quell’espressione possiede in quel momento
 * 
 * Costruire quindi l’espressione –(5+(3/2)-2)*x e calcolarne il valore quando la variabile x vale 3 e quando la variabile x vale 6
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class EspressioneBinaria extends Espressione
{
	
	/**
	 * prima espressione dell'espressione binaria
	 */
	protected Espressione espressione1;
	
	/**
	 * seconda espressione dell'espressione binaria
	 */
	protected Espressione espressione2;
	
	/**
	 * costruttore che imposta l'espressione1 e l'espressione2 dell'espressione binaria
	 * @param espressione1 la prima espressione dell'espressione binaria
	 * @param espressione2 la seconda espressione dell'espressione binaria
	 */
	public EspressioneBinaria(Espressione espressione1, Espressione espressione2)
	{
		this.espressione1 = espressione1;
		this.espressione2 = espressione2;
	}
	
}

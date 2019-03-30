
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Tigre (taglia grande)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Tigre extends Felide
{
	
	/**
	 * costruttore vuoto
	 */
	public Tigre()
	{
		super(Taglia.GRANDE);
	}
	
	/**
	 * metodo che stampa a video l'azione di fare le unghie effettuata dalla tigre
	 */
	@Override
	public void faiUnghie()
	{
		System.out.println("Vado vicino al prossimo albero e limo i miei grandi artigli.");
	}
	
	/**
	 * metodo che stampa a video il verso della tigre
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("wuuuooorrr!");
	}
	
	/**
	 * metodo che restituisce il numero di zampe della tigre
	 * @return il numero di zampe della tigre
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 4;
	}
	
}

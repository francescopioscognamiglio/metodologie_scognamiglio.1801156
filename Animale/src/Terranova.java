
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Terranova (taglia grande)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Terranova extends Canide
{
	
	/**
	 * costruttore vuoto
	 */
	public Terranova()
	{
		super(Taglia.GRANDE);
	}
	
	/**
	 * metodo che stampa a video l'azione annusa effettuata dal terranova
	 */
	@Override
	public void annusa()
	{
		System.out.println("Mi metto subito ad annusare! Sono il più bravo in questo.");
	}
	
	/**
	 * metodo che stampa a video il verso del terranova
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("super WOOOF WOOOF!");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del terranova
	 * @return il numero di zampe del terranova
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 4;
	}
	
}

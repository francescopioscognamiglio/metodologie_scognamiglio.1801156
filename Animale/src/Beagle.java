
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Beagle (taglia media)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Beagle extends Canide
{
	
	/**
	 * costruttore vuoto
	 */
	public Beagle()
	{
		super(Taglia.MEDIA);
	}
	
	/**
	 * metodo che stampa a video l'azione annusa effettuata dal beagle
	 */
	@Override
	public void annusa()
	{
		System.out.println("Che sentiero interessante! Mi metto alla ricerca.");
	}
	
	/**
	 * metodo che stampa a video il verso del beagle
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("bau bau!");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del beagle
	 * @return il numero di zampe del beagle
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 4;
	}
	
}

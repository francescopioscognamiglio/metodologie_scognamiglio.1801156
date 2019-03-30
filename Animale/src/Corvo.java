
/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Corvo (taglia media)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Corvo extends Uccello
{
	
	/**
	 * costruttore vuoto
	 */
	public Corvo()
	{
		super(Taglia.MEDIA);
	}
	
	/**
	 * metodo che stampa a video il verso del corvo
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("Cro cro cro. Cro cro cro.");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del corvo
	 * @return il numero di zampe del corvo
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 2;
	}
	
}

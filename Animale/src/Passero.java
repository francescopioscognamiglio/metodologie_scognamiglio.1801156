
/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Passero (taglia piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Passero extends Uccello
{
	
	/**
	 * costruttore vuoto
	 */
	public Passero()
	{
		super(Taglia.PICCOLA);
	}
	
	/**
	 * metodo che stampa a video il verso del passero
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("cip cip cip!");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del passero
	 * @return il numero di zampe del passero
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 2;
	}
	
}

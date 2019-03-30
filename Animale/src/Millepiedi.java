
/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Millepiedi (taglia piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Millepiedi extends Insetto
{
	
	/**
	 * costruttore vuoto
	 */
	public Millepiedi()
	{
		super(Taglia.PICCOLA);
	}
	
	/**
	 * metodo che stampa a video il verso del millepiedi
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("zzzzzzzzz");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del millepiedi
	 * @return il numero di zampe del millepiedi
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 1000;
	}
	
}

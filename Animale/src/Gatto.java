
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Gatto (taglia piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
public class Gatto extends Felide
{
	
	/**
	 * costruttore vuoto
	 */
	public Gatto()
	{
		super(Taglia.PICCOLA);
	}
	
	/**
	 * metodo che stampa a video l'azione di fare le unghie effettuata dal gatto
	 */
	@Override
	public void faiUnghie()
	{
		System.out.println("Mi avvicino alla mia zona relax e mi faccio le unghie!");
	}
	
	/**
	 * metodo che stampa a video il verso del gatto
	 */
	@Override
	public void emettiVerso()
	{
		System.out.println("miaaaao!");
	}
	
	/**
	 * metodo che restituisce il numero di zampe del gatto
	 * @return il numero di zampe del gatto
	 */
	@Override
	public int getNumeroDiZampe()
	{
		return 4;
	}
	
}

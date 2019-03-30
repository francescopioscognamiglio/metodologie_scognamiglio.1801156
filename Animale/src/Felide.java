
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Felide con le sottoclassi Gatto (taglia piccola), Tigre (grande)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Felide extends Mammifero
{
	
	/**
	 * costruttore che permette di definire la taglia del felide
	 * @param taglia la taglia del felide
	 */
	public Felide(Taglia taglia)
	{
		super(taglia);
	}
	
	/**
	 * metodo astratto che descrive l'azione fai le unghie
	 */
	abstract public void faiUnghie();
	
}


/**
 * Esercizio: Animali
 * 
 * Progettare la classe Canide con le sottoclassi Chihuahua (piccola), Beagle (media), Terranova (grande)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Canide extends Mammifero
{
	
	/**
	 * costruttore che permette di definire la taglia del canide 
	 * @param taglia la taglia del canide
	 */
	public Canide(Taglia taglia)
	{
		super(taglia);
	}
	
	/**
	 * metodo astratto che descrive l'azione annusa
	 */
	abstract public void annusa();
	
}

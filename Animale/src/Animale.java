
/**
 * Esercizio: Animali
 * 
 * Progettare la classe Animale che rappresenti un generico animale
 * 
 * La classe possiede i metodi emettiVerso() e getNumeroDiZampe()
 * Possiede inoltre il metodo getTaglia() che restituisce un valore scelto tra: piccola, media e grande.
 * 
 * Progettare quindi le classi Mammifero, Felino, Gatto (taglia piccola), Tigre (grande), Cane, Chihuahua (piccola),
 * Beagle (media), Terranova (grande), Uccello, Corvo (media), Passero (piccola), Millepiedi (piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Animale
{
	
	/**
	 * enum che descrive la taglia dell'animale
	 * @author francescopioscognamiglio
	 *
	 */
	public enum Taglia
	{
		PICCOLA,
		MEDIA,
		GRANDE
	}
	
	/**
	 * la taglia dell'animale
	 */
	private Taglia taglia;
	
	/**
	 * costruttore che permette di definire la taglia dell'animale
	 * @param taglia la taglia dell'animale
	 */
	public Animale(Taglia taglia)
	{
		this.taglia = taglia;
	}
	
	/**
	 * metodo che restituisce la taglia dell'animale
	 * @return la taglia dell'animale
	 */
	public Taglia getTaglia()
	{
		return taglia;
	}
	
	/**
	 * metodo astratto che emette il verso dell'animale
	 */
	abstract public void emettiVerso();
	/**
	 * metodo astratto che restituisce il numero di zampe dell'animale
	 * @return il numero di zampe dell'animale
	 */
	abstract public int getNumeroDiZampe();
	
}

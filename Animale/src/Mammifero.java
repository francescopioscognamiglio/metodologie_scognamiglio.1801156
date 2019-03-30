
/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Mammifero con le sottoclassi Felide che comprende Gatto (taglia piccola),
 * Tigre (grande) e Canide che comprende Chihuahua (piccola), Beagle (media), Terranova (grande)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Mammifero extends Animale
{
	
	/**
	 * il numero di figli
	 */
	protected int numeroFigli;
	
	/**
	 * costruttore che permette di definire la taglia del mammifero
	 * @param taglia la taglia del mammifero
	 */
	public Mammifero(Taglia taglia)
	{
		super(taglia);
	}
	
	/**
	 * metodo che incrementa il numero di figli dato il numero di nuovi figli
	 * @param numeroNuoviFigli il numero di nuovi figli
	 */
	public void riproduci(int numeroNuoviFigli)
	{
		this.numeroFigli += numeroNuoviFigli;
	}
	
	/**
	 * metodo che stampa a video l'azione di allattamento
	 */
	public void allatta()
	{
		System.out.println("Sto allattando i miei cuccioli.");
	}
	
	/**
	 * metodo che restituisce il numero di figli
	 * @return il numero di figli
	 */
	public int getNumeroFigli()
	{
		return numeroFigli;
	}
	
}

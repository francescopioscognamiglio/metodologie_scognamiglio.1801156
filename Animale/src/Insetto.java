
/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Insetto con la sottoclasse Millepiedi (piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Insetto extends Animale
{
	
	/**
	 * il numero di insetti figli
	 */
	protected int numeroInsetti;
	
	/**
	 * costruttore che permette di definire la taglia dell'insetto
	 * @param taglia la taglia dell'insetto
	 */
	public Insetto(Taglia taglia)
	{
		super(taglia);
	}
	
	/**
	 * metodo che incrementa il numero di insetti figli dato il numero di uova generate
	 * @param numeroUova il numero di uova generate
	 */
	public void generaUova(int numeroUova)
	{
		numeroInsetti += numeroUova;
	}
	
	/**
	 * metodo che restituisce il numero di insetti figli
	 * @return il numero di insetti figli
	 */
	public int getNumeroInsetti()
	{
		return numeroInsetti;
	}
	
}

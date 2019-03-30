import java.util.Random;

/**
 * Esercizio: Animali
 * 
 * Progettare quindi la classe Uccello con le sottoclassi Corvo (media), Passero (piccola)
 * 
 * Personalizzare in modo appropriato la taglia, il numero di zampe e il verso degli animali
 * 
 * @author francescopioscognamiglio
 *
 */
abstract public class Uccello extends Animale
{
	
	/**
	 * il numero di pulcini
	 */
	protected int numeroPulcini;
	
	/**
	 * costruttore che permette di definire la taglia dell'uccello
	 * @param taglia la taglia dell'uccello
	 */
	public Uccello(Taglia taglia)
	{
		super(taglia);
	}
	
	/**
	 * metodo che incrementa il numero di pulcini dato il numero di uova generate,
	 * tenendo conto che non tutte le uova riusciranno a schiudersi
	 * @param numeroUova il numero di uova generate
	 */
	public void generaUova(int numeroUova)
	{
		fecondaUova(numeroUova);
	}
	
	/**
	 * metodo che calcola il numero di uova che realmente si schiuderanno
	 * @param numeroUova
	 */
	private void fecondaUova(int numeroUova)
	{
		numeroPulcini = numeroUova - new Random().nextInt(numeroUova);
	}
	
	/**
	 * metodo che restituisce il numero di pulcini
	 * @return il numero di pulcini
	 */
	public int getNumeroPulcini()
	{
		return numeroPulcini;
	}
	
}

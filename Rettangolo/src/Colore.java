
import java.util.Arrays;

/**
 * Miglioria della classe con l’aggiunta del colore
 * 
 * Progettare una classe Colore i cui oggetti rappresentano
 * un colore in modalità RGB e che sono costruiti a partire da tre valori:
 * R (rosso), G (verde), B (blu), ognuno dei quali ammette un valore intero nell’intervallo 0-255.
 * 
 * La classe Colore espone anche due costanti BIANCO e NERO.
 * 
 * Fare in modo che ogni Rettangolo (vedere esercizio precedente) abbia associato un Colore di base NERO e
 * che sia possibile impostare il colore di un rettangolo mediante un apposito metodo
 * 
 * @author francescopioscognamiglio
 *
 */
public class Colore
{
	/**
	 * array di interi costante e statico che definisce il colore bianco in formato RGB
	 */
	public static final int[] BIANCO = {0, 0, 0};
	/**
	 * array di interi costante e statico che definisce il colore nero in formato RGB
	 */
	public static final int[] NERO = {255, 255, 255};
	
	/**
	 * campo di tipo array di interi che contiene il colore in formato RGB
	 */
	private int[] colore = new int[3];
	
	/**
	 * costruttore della classe che permette di impostare il colore in formato RGB
	 * @param r il colore rosso
	 * @param g il colore verde
	 * @param b il colore blu
	 */
	public Colore(int r, int g, int b)
	{
		colore[0] = (controlla(r) ? r : NERO[0]);
		colore[1] = (controlla(g) ? g : NERO[1]);
		colore[2] = (controlla(b) ? b : NERO[2]);
	}
	
	/**
	 * costruttore della classe vuoto
	 */
	public Colore()
	{
		this(NERO[0], NERO[1], NERO[2]);
	}
	
	/**
	 * metodo setter che imposta il colore in formato RGB
	 * @param r il colore rosso
	 * @param g il colore verde
	 * @param b il colore blu
	 */
	public void setColore(int r, int g, int b)
	{
		if (controlla(r)) colore[0] = r;
		if (controlla(g)) colore[1] = g;
		if (controlla(b)) colore[2] = b;
	}
	
	/**
	 * metodo getter che restituisce una copia dell'array di interi che contiene il colore
	 * @return una copia dell'array di interi che contiene il colore
	 */
	public int[] getColore()
	{
		return Arrays.copyOf(colore, colore.length);
	}
	
	/**
	 * metodo che controlla se il valore è compreso tra l'intervallo 0 e 255
	 * @param valore
	 * @return true se il valore è compreso tra l'intervallo 0 e 255; false altrimenti
	 */
	private boolean controlla(int valore)
	{
		return valore >= 0 && valore <= 255;
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta il valore del colore
	 */
	public String toString()
	{
		return "(" + colore[0] + ", " + colore[1] + ", " + colore[2] +")";
	}
	
}

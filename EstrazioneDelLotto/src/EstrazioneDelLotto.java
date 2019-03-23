import java.util.Arrays;
import java.util.Random;

/**
 * Progettare la classe EstrazioneDelLotto.
 * 
 * La classe implementa i seguenti metodi:
 * - estrai: estrae, memorizzandoli, 5 numeri tra 1 e 90 (non importa se con o senza ripetizioni);
 * - toString: restituisce l’ultima estrazione sotto forma di stringa (ad esempio, “42, 11, 78, 90, 12”);
 * - numeriContenuti: prende in input una giocata (sequenza fino a 10 numeri)
 * 		e restituisce quanti dei numeri giocati sono anche contenuti nell’ultima estrazione
 * 		(ad esempio, 2 indica un ambo, 3 un terno, ecc.);
 * - vincita: prende in input una giocata e restituisce un booleano che indica se c’è stata una vincita (dall’ambo in poi);
 * - getTotaleNumeriEstratti: restituisce la somma totale dei numeri finora estratti
 * (ad esempio, dopo le estrazioni “42, 11, 78, 90, 12” e “14, 77, 65, 32, 51”, restituisce 472).

 * @author francescopioscognamiglio
 *
 */
public class EstrazioneDelLotto
{
	
	/**
	 * matrice intera che contiene tutte le estrazioni
	 */
	private int[][] numeri;
	/**
	 * intero che contiene la somma dei numeri estratti
	 */
	private int sommaTotaleNumeriEstratti;
	
	/**
	 * costante intera che contiene il range di numeri
	 */
	private static final int rangeNumeri = 90;
	
	/**
	 * costruttore della classe
	 */
	public EstrazioneDelLotto()
	{
		numeri = new int[0][0];
	}
	
	/**
	 * metodo che genera 5 numeri che definiscono una nuova estrazione
	 */
	public void estrai()
	{
		int[] ultimaEstrazione = new int[5];
		Random random = new Random();
		for (int i = 0; i < ultimaEstrazione.length; i++)
		{
			ultimaEstrazione[i] = random.nextInt(rangeNumeri)+1;
			sommaTotaleNumeriEstratti += ultimaEstrazione[i];
		}
		
		int[][] numeriCopy = new int[numeri.length+1][5];
		for (int i = 0; i < numeri.length; i++)
			numeriCopy[i] = numeri[i];
		numeriCopy[numeriCopy.length-1] = ultimaEstrazione;
		numeri = numeriCopy;
	}
	
	/**
	 * metodo che restituisce l'ultima estrazione sotto forma di stringa
	 * @return una stringa contenente l'ultima estrazione
	 */
	public String toString()
	{
		String risultato = "";
		for (int j = 0; j < numeri[0].length; j++)
			risultato += numeri[numeri.length-1][j] + (j < numeri[0].length-1 ? ", " : "");
		return risultato;
	}
	
	/**
	 * metodo che restituisce tutte le estrazione sotto forma di stringa
	 * @return una stringa contenente tutte le estrazioni
	 */
	public String toStringCustom()
	{
		String risultato = "";
		for (int i = 0; i < numeri.length; i++)
		{
			risultato += i+1 + ") ";
			for (int j = 0; j < numeri[0].length; j++)
				risultato += numeri[i][j] + (j < numeri[0].length-1 ? ", " : "");
			risultato += "\n";
		}
		return risultato;
	}
	
	/**
	 * metodo che restituisce quanti dei numeri giocati sono anche contenuti nell'ultima estrazione
	 * @param sequenza dei numeri giocati
	 * @return quanti dei numeri giocati sono anche contenuti nell'ultima estrazione
	 */
	public int[] numeriContenuti(int... giocata)
	{
		return numeriContenuti(giocata, numeri.length-1);
	}
	
	/**
	 * metodo che restituisce quanti dei numeri giocati sono anche contenuti nelle estrazioni, partendo dall'estrazione n
	 * @param sequenza dei numeri giocati
	 * @return quanti dei numeri giocati sono anche contenuti nelle estrazioni, partendo dall'estrazione n
	 */
	public int[] numeriContenuti(int[] giocata, int n)
	{
		int[] numeriContenuti = new int[numeri.length-n];
		for (int i = n, index = 0; i < numeri.length; i++, index++)
			for (int j = 0; j < numeri[0].length; j++)
				for (int k = 0; k < giocata.length; k++)
					if (giocata[k] == numeri[i][j])
					{
						numeriContenuti[index]++;
						break;
					}
		return numeriContenuti;
	}
	
	/**
	 * metodo che restituisce true se la sequenza dei numeri giocati sono vincenti; false altrimenti
	 * @param giocata sequenza dei numeri giocati
	 * @return true se c'é stata una vincita; false altrimenti
	 */
	public boolean vincita(int... giocata)
	{
		return numeriContenuti(giocata, 0).length > 2 ? true : false;
	}
	
	/**
	 * metodo che restituisce la somma totale dei numeri estratti
	 * @return la somma totale dei numeri estratti
	 */
	public int getSommaTotaleNumeriEstratti()
	{
		return sommaTotaleNumeriEstratti;
	}
	
	public static void main(String[] args)
	{
		EstrazioneDelLotto estrazioneDelLotto = new EstrazioneDelLotto();
		estrazioneDelLotto.estrai();
		System.out.println(estrazioneDelLotto.toString());
		System.out.println(estrazioneDelLotto.toStringCustom());
		System.out.println(Arrays.toString(estrazioneDelLotto.numeriContenuti(new int[] { 23, 42, 12, 59, 81, 11, 19, 87 })));
		System.out.println(estrazioneDelLotto.vincita(new int[] { 2, 3, 1, 4 }));
		System.out.println(estrazioneDelLotto.getSommaTotaleNumeriEstratti());
		
		estrazioneDelLotto.estrai();
		System.out.println(estrazioneDelLotto.toString());
		System.out.println(estrazioneDelLotto.toStringCustom());
		System.out.println(Arrays.toString(estrazioneDelLotto.numeriContenuti(new int[] { 23, 42, 12, 59, 81, 11, 19, 87 })));
		System.out.println(Arrays.toString(estrazioneDelLotto.numeriContenuti(new int[] { 23, 42, 12, 59, 81, 11, 19, 87 }, 0)));
		System.out.println(estrazioneDelLotto.vincita(new int[] { 2, 3, 1, 4 }));
		System.out.println(estrazioneDelLotto.getSommaTotaleNumeriEstratti());
	}
	
}

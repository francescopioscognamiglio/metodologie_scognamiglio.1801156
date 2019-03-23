
/**
 * Progettare una classe GestoreArray costruita a partire da un array di interi.
 * 
 * La classe implementa i seguenti metodi:
 * -indexOf che, dato in input un intero, restituisce la posizione dell’intero
 * 		all’interno dell’array, se presente, -1 altrimenti.
 * - concat che, preso in input un altro array di interi, lo concatena in fondo
 * 		all’array dell’oggetto. Il metodo non restituisce nulla.
 * - concatNoDup che, preso in input un altro array di interi, concatena in fondo
 * 		all’array dell’oggetto solo quegli elementi dell’array in input
 * 		che non sono già presenti nell’oggetto. Il metodo restituisce il numero di elementi scartati.
 * 		Ad esempio, new GestoreArray(new int[] { 1, 2 }).concatNoDup(new int[] { 6, 2, 3 });
 * 		memorizza all’interno dell’oggetto l’array { 1, 2, 6, 3 }
 * 		perché 2 era già presente nell’array iniziale, restituendo 1.
 * - replace che, dati in input due interi x e y, sostituisce la prima occorrenza di x con il valore di y
 * 		all’interno dell’array. Se l’occorrenza viene sostituita, il metodo restituisce true, altrimenti false.
 * 
 * Per la gestione dell’espansione dell’array non è consentito l’uso dei metodi della classe Arrays.
 * 
 * @author francescopioscognamiglio
 *
 */
public class GestoreArray
{
	
	/**
	 * campo di tipo array di interi
	 */
	private int[] array;
	
	/**
	 * costruttore della classe che imposta l'array all'array passato in input
	 * @param array l'array da impostare
	 */
	public GestoreArray(int[] array)
	{
		this.array = copia(array);
	}
	
	/**
	 * metodo che restituisce la posizione della prima occorrenza dell'elemento k; -1 se non é presente
	 * @param k l'elemento k
	 * @return la posizione della prima occorrenza dell'elemento k; -1 se non é presente
	 */
	public int indexOf(int k)
	{
		for (int i = 0; i < array.length; i++)
			if (k == array[i])
				return i;
		return -1;
	}
	
	/**
	 * metodo che concatena all'array l'array passato in input
	 * @param arrayConcat l'array passato in input
	 */
	public void concat(int[] arrayConcat)
	{
		concat(arrayConcat, arrayConcat.length);
	}
	
	/**
	 * metodo che concatena all'array l'oggetto array passato in input
	 * @param array l'oggetto array passato in input
	 */
	public void concat(GestoreArray array)
	{
		concat(array.array);
	}
	
	/**
	 * metodo che concatena all'array le prime n posizioni dell'array passato in input
	 * @param arrayConcat l'array passato in input
	 * @param n il numero delle prime posizioni
	 */
	public void concat(int[] arrayConcat, int n)
	{
		int[] arrayConcatenato = new int[array.length + n];
		for (int i = 0; i < array.length; i++)
			arrayConcatenato[i] = array[i];
		for (int i = 0, j = array.length; i < n; i++, j++)
			arrayConcatenato[j] = arrayConcat[i];
		
		array = arrayConcatenato;
	}
	
	/**
	 * metodo che che concatena in fondo all’array dell’oggetto
	 * solo quegli elementi dell’array in input che non sono già presenti nell’oggetto.
	 * Il metodo restituisce il numero di elementi scartati.
	 * @param arrayConcat array passato in input
	 * @return il numero di elementi scartati
	 */
	public int concatNoDup(int[] arrayConcat)
	{
		int numeriScartati = 0;
		int[] nuovi = new int[arrayConcat.length];
		
		int j = 0;
		for (int i = 0; i < arrayConcat.length; i++)
			if (indexOf(arrayConcat[i]) != -1)
				numeriScartati++;
			else
				nuovi[j++] = arrayConcat[i];
		
		concat(nuovi, j);
		return numeriScartati;
	}
	
	/**
	 * metodo che sostituisce la prima occorrenza di x con il valore di y all’interno dell’array
	 * @param x valore da sostituire
	 * @param y valore da usare al posto di x
	 * @return true se l'occorrenza viene sostituita; false altrimenti
	 */
	public boolean replace(int x, int y)
	{
		int i = indexOf(x);
		if (i != -1)
		{
			array[i] = y;
			return true;
		}
		return false;
	}
	
	/**
	 * metodo che restituisce una copia dell'array dell'oggetto
	 * @return una copia dell'array dell'oggetto
	 */
	public int[] toArray()
	{
		return copia(array);
	}
	
	/**
	 * metodo statico che fa una copia dell'array passato in input
	 * @param array l'array passato in input
	 * @return una copia dell'array passato in input
	 */
	public static int[] copia(int[] array)
	{
		int[] arrayCopia = new int[array.length];
		for (int i = 0; i < array.length; i++)
			arrayCopia[i] = array[i];
		return arrayCopia;
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta l'array dell'oggetto
	 * @return una stringa che rappresenta l'array dell'oggetto
	 */
	public String toString()
	{
		String arrayToString = "[";
		for (int i = 0; i < array.length; i++)
			arrayToString += array[i] + (i < array.length-1 ? ", " : "]");
		return arrayToString;
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta l'array dell'oggetto
	 * utilizzando la classe StringBuilder
	 * @return una stringa che rappresenta l'array dell'oggetto
	 */
	public String toStringBuilder()
	{
		StringBuilder stringBuilder = new StringBuilder("[");
		for (int i = 0; i < array.length; i++)
			stringBuilder.append(array[i] + (i < array.length-1 ? ", " : "]"));
		return stringBuilder.toString();
	}
	
	public static void main(String[] args)
	{
		int[] array = { 2, 5, 7 };
		
		GestoreArray a = new GestoreArray(new int[] { 1, 2, 3 });
		GestoreArray b = new GestoreArray(array);
		
		System.out.println(a.toString());
		System.out.println(b.toString());
		System.out.println(a.toStringBuilder());
		System.out.println(b.toStringBuilder());
		
		a.concat(new int[] {2, 3, 5, 7});
		System.out.println(a.toString());
		
		GestoreArray c = new GestoreArray(new int[] { 1, 2});
		System.out.println(c.toString());
		c.concatNoDup(new int[] { 4, 2, 3 });
		System.out.println(c.toString());
		
		c.replace(2, 5);
		System.out.println(c.toString());
	}
	
}

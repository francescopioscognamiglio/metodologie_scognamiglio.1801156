
import java.util.Arrays;

/**
 * Esercizio: ListaDiInteri e ListaOrdinataDiInteri
 * 
 * Che cos’è una lista? E’ una sequenza di oggetti
 * 
 * Implementare una classe ListaDiInteri che permetta le seguenti operazioni:
 * 		- Restituisce l’elemento i-esimo della lista
 * 		- Restituisce l’indice della posizione dell’intero fornito in input
 * 		- Restituisce una stringa formattata contenente la lista di interi
 * 		- Restituisce la dimensione della lista
 * 		- Contiene un determinato intero (true o false)?
 * 		- Aggiungi un intero in coda alla lista
 * 		- Aggiungi un intero nella posizione specificata
 * 		- Elimina la prima occorrenza di un intero dalla lista
 * 		- Elimina l’elemento i-esimo della lista
 * 
 * @author francescopioscognamiglio
 *
 */
public class ListaDiInteri
{
	
	/**
	 * lista di interi rappresentata da un array di interi
	 */
	protected int[] listaInteri;
	
	/**
	 * costruttore che permette di definire l'array di interi
	 * @param valori sequenza di interi passati in input
	 */
	public ListaDiInteri(int ... valori)
	{
		listaInteri = Arrays.copyOf(valori, valori.length);
	}
	
	/**
	 * metodo che restituisce l’elemento i-esimo della lista
	 * o -1 se la posizione non esiste nella lista
	 * @param pos la posizione intera dell'elemento
	 * @return l'elemento i-esimo della lista; -1 se non è presente
	 */
	public int get(int pos)
	{
		return (pos < listaInteri.length ? listaInteri[pos] : -1);
	}
	
	/**
	 * metodo che restituisce l’indice della posizione dell’intero fornito in input
	 * @param k l'intero fornito in input
	 * @return l'indice della posizione dell'intero fornito in input; -1 se non è presente
	 */
	public int indexOf(int k)
	{
		for (int i = 0; i < listaInteri.length; i++)
			if (listaInteri[i] == k)
				return i;
		return -1;
	}
	
	/**
	 * metodo che restituisce una stringa formattata contenente la lista di interi usando StringBuilder
	 * @return una stringa formattata contenente la lista di interi
	 */
	public String toString()
	{
		StringBuilder ris = new StringBuilder("[");
		for (int i = 0; i < listaInteri.length; i++)
			ris.append(listaInteri[i] + (i < listaInteri.length-1 ? ", " : "]"));
		return ris.toString();
	}
	
	/**
	 * metodo che restituisce la dimensione della lista
	 * @return la dimensione della lista
	 */
	public int size()
	{
		return listaInteri.length;
	}
	
	/**
	 * metodo che restituisce true se la lista contiene il numero intero fornito in input; false altrimenti
	 * @param k il numero intero passato in input
	 * @return true se la lista contiene il numero intero fornito in input; false altrimenti
	 */
	public boolean contains(int k)
	{
		return indexOf(k) != -1;
	}
	
	/**
	 * metodo che aggiunge il numero intero fornito in input alla fine della lista
	 * @param k il numero intero fornito in input
	 */
	public void add(int k)
	{
		add(k, listaInteri.length);
	}
	
	/**
	 * metodo che aggiunge il numero intero fornito in input nella posizione specificata in input
	 * @param k il numero intero fornito in input
	 * @param pos la posizione intera fornita in input
	 */
	public void add(int k, int pos)
	{
		if (pos <= listaInteri.length)
		{
			int[] arrayAppoggio = new int[listaInteri.length+1];
			
			for (int i = 0; i < pos; i++)
				arrayAppoggio[i] = listaInteri[i];
			
			arrayAppoggio[pos] = k;
			
			for (int i = pos; i < listaInteri.length; i++)
				arrayAppoggio[i+1] = listaInteri[i];
			
			listaInteri = arrayAppoggio;
		}
	}
	
	/**
	 * metodo che elimina la prima occorrenza del numero intero fornito in input dalla lista
	 * @param k il numero intero fornito in input
	 */
	public void removeElement(int k)
	{
		removeIndex(indexOf(k));
	}
	
	/**
	 * metodo che elimina l’elemento i-esimo della lista
	 * @param pos la posizione dell'elemento
	 */
	public void removeIndex(int pos)
	{
		if (pos < listaInteri.length)
		{
			for (int i = pos; i < listaInteri.length-1; i++)
				listaInteri[i] = listaInteri[i+1];
			int[] listaInteriCopia = new int[listaInteri.length-1];
			for (int z = 0; z < listaInteriCopia.length; z++)
				listaInteriCopia[z] = listaInteri[z];
			listaInteri = listaInteriCopia;
		}
	}
	
	public static void main(String[] args)
	{
		ListaDiInteri listaMedianteArray1 = new ListaDiInteri(1, 2, 3, 2, 1, 8, 0, 10);
		ListaDiInteri listaMedianteArray2 = new ListaDiInteri();
		ListaDiInteri listaMedianteArray3 = new ListaDiInteri(new int[] { 4, 5, 6 });
		
		System.out.println("L'elemento in posizione 2 dell'array e': " + listaMedianteArray1.get(2));
		System.out.println("L'elemento 3 dell'array e' in posizione: " + listaMedianteArray1.indexOf(3));
		System.out.println("La rappresentazione dell'array e': " + listaMedianteArray1.toString());
		System.out.println("La dimensione dell'array e': " + listaMedianteArray1.size());
		System.out.println("L'array contiene il numero 2 ? : " + listaMedianteArray1.contains(2));

		listaMedianteArray1.add(30);
		System.out.println("La rappresentazione dell'array con l'aggiunta del numero 30 e' : " + listaMedianteArray1.toString());
		listaMedianteArray1.add(3, 0);
		System.out.println("La rappresentazione dell'array con l'aggiunta del numero 3 in posizione 0 e' : " + listaMedianteArray1.toString());
		
		listaMedianteArray1.removeElement(2);
		System.out.println("La rappresentazione dell'array senza la prima occorrenza del numero 2 e' : " + listaMedianteArray1.toString());
		
		listaMedianteArray1.removeIndex(3);
		System.out.println("La rappresentazione dell'array senza il numero in posizione 3 e' : " + listaMedianteArray1.toString());
	}
	
}

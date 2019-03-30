
/**
 * Esercizio: ListaDiInteri e ListaOrdinataDiInteri
 * 
 * Implementare quindi una classe ListaOrdinataDiInteri per creare liste di interi ordinati in modo crescente.
 * La classe ridefinisce i seguenti 3 metodi di aggiunta:
 * - aggiungiInCoda(k): Aggiungi un intero in coda alla lista: l'aggiunta avviene solo se l'intero preserva l'ordine della lista
 * - aggiungi(k, j): Aggiungi un intero nella posizione specificata: come sopra, l'aggiunta avviene solo se l'intero preserva
 * 	 l'ordine degli interi della lista
 * - aggiungi(k): Aggiungi un intero: l'intero viene inserito nella posizione appropriata, in modo da preservare
 * 	 l'ordine degli interi della lista
 * 
 * L'array non deve essere ordinato con metodi di sorting, quali Arrays.sort (né vostri metodi di sorting *completo* dell'array)
 * 
 * Extra: permettere di specificare un parametro da passare opzionalmente al costruttore di ListaOrdinataDiInteri
 * per stabilire l'ordine della lista (crescente o decrescente; per default, crescente)
 * 
 * @author francescopioscognamiglio
 *
 */
public class ListaOrdinataDiInteri extends ListaDiInteri
{
	
	/**
	 * enum che definisce il tipo di ordinamento
	 * @author francescopioscognamilio
	 *
	 */
	public enum Ordine
	{
		CRESCENTE,
		DECRESCENTE
	}
	
	/**
	 * campo che contiene il tipo di ordinamento scelto
	 */
	private Ordine ordine;
	
	/**
	 * costruttore che permette di definire il tipo di ordinamento e i valori della lista
	 * @param ordine il tipo di ordinamento
	 * @param valori sequenza di interi passati in input
	 */
	public ListaOrdinataDiInteri(Ordine ordine, int... valori)
	{
		super(valori);
		this.ordine = ordine;
	}
	
	/**
	 * costruttore che permette di definire i valori della lista
	 * @param valori sequenza di interi passati in input
	 */
	public ListaOrdinataDiInteri(int... valori)
	{
		this(Ordine.CRESCENTE, valori);
	}
	
	/**
	 * metodo che aggiunge un intero in coda alla lista: l'aggiunta avviene solo se l'intero preserva l'ordine della lista
	 * @param k il numero intero fornito in input
	 */
	@Override
	public void add(int k)
	{
		add(k, listaInteri.length);
	}
	
	/**
	 * metodo che aggiunge un intero nella posizione specificata: l'aggiunta avviene solo se l'intero preserva l'ordine della lista
	 * @param k il numero intero fornito in input
	 * @param pos la posizione intera fornita in input
	 */
	@Override
	public void add(int k, int pos)
	{
		if (isPreservaOrdine(k, pos)) super.add(k, pos);
	}
	
	/**
	 * metodo che restituisce true se il numero k in posizione pos preserva l'ordine della lista
	 * @param k il numero intero fornito in input
	 * @param pos la posizione intera fornita in input
	 * @return true se il numero k in posizione pos preserva l'ordine della lista
	 */
	private boolean isPreservaOrdine(int k, int pos)
	{
		if (listaInteri.length == 0) return true;
		switch(ordine)
		{
		case CRESCENTE:
			if ((pos == 0 && listaInteri[pos+1] >= k) ||
					(pos == listaInteri.length && listaInteri[pos-1] <= k) ||
					(pos > 0 && pos < listaInteri.length && listaInteri.length > 1 && listaInteri[pos-1] <= k && listaInteri[pos] >= k))
				return true;
			break;
		case DECRESCENTE:
			if ((pos == 0 && listaInteri[pos+1] <= k) ||
					(pos == listaInteri.length && listaInteri[pos-1] >= k) ||
					(pos > 0 && pos < listaInteri.length && listaInteri.length > 1 && listaInteri[pos-1] >= k && listaInteri[pos] <= k))
				return true;
			break;
		}
		return false;
	}
	
	/**
	 * metodo che aggiunge un intero: l'intero viene inserito nella posizione appropriata,
	 * in modo da preservare l'ordine degli interi della lista
	 * @param k il numero intero fornito in input
	 */
	public void addManieraCorretta(int k)
	{
		for (int i = 0; i < listaInteri.length; i++)
			if (isPreservaOrdine(k, i))
			{
				super.add(k, i);
				break;
			}
	}
	
	public static void main(String[] args)
	{
		ListaOrdinataDiInteri listaOrdinataDiInteri1 = new ListaOrdinataDiInteri(new int[] { 2, 3, 4, 6, 9 });
		listaOrdinataDiInteri1.add(2);
		System.out.println("Aggiunta del numero 2 alla fine della lista solo se rispetta l'ordine: " + listaOrdinataDiInteri1.toString());
		listaOrdinataDiInteri1.add(12);
		System.out.println("Aggiunta del numero 12 alla fine della lista solo se rispetta l'ordine: " + listaOrdinataDiInteri1.toString());
		listaOrdinataDiInteri1.add(0, 0);
		System.out.println("Aggiunta del numero 0 in posizione 0 solo se rispetta l'ordine: " + listaOrdinataDiInteri1.toString());
		listaOrdinataDiInteri1.add(3, 2);
		System.out.println("Aggiunta del numero 3 in posizione 2 solo se rispetta l'ordine: " + listaOrdinataDiInteri1.toString());
		listaOrdinataDiInteri1.addManieraCorretta(5);
		System.out.println("Aggiunta del numero 5 nella posizione corretta: " + listaOrdinataDiInteri1.toString());
		
		System.out.println("---------------------------------------------");
		
		ListaOrdinataDiInteri listaOrdinataDiInteri2 = new ListaOrdinataDiInteri(Ordine.DECRESCENTE, new int[] { 8, 7, 4 });
		listaOrdinataDiInteri2.add(2);
		System.out.println("Aggiunta del numero 2 alla fine della lista solo se rispetta l'ordine: " + listaOrdinataDiInteri2.toString());
		listaOrdinataDiInteri2.add(12);
		System.out.println("Aggiunta del numero 12 alla fine della lista solo se rispetta l'ordine: " + listaOrdinataDiInteri2.toString());
		listaOrdinataDiInteri2.add(0, 0);
		System.out.println("Aggiunta del numero 0 in posizione 0 solo se rispetta l'ordine: " + listaOrdinataDiInteri2.toString());
		listaOrdinataDiInteri2.add(3, 3);
		System.out.println("Aggiunta del numero 3 in posizione 3 solo se rispetta l'ordine: " + listaOrdinataDiInteri2.toString());
		listaOrdinataDiInteri2.addManieraCorretta(5);
		System.out.println("Aggiunta del numero 5 nella posizione corretta: " + listaOrdinataDiInteri2.toString());
	}
	
}

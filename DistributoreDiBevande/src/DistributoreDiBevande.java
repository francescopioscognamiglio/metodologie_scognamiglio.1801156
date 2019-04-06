import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Esercizio: Distributore di bevande
 * 
 * Progettare la classe DistributoreDiBevande che rappresenti un distributore automatico costruito
 * con un intero N che determina il numero di prodotti nel distributore
 * 
 * La classe prevede i seguenti metodi:
 * 	- un metodo carica() che inserisce N prodotti di tipo e ordine casuale
 * 	- un metodo inserisciImporto() che permette di inserire un importo nella macchinetta
 * 	- un metodo getProdotto() che, dato in ingresso un numero di prodotto, restituisca il prodotto associato a quel numero
 * 	  e decrementi il saldo disponibile nel distributore
 * 	- Un metodo getSaldo() che restituisca il saldo attuale del distributore
 * 	- un metodo getResto() che restituisca il resto dovuto e azzeri il saldo
 * 
 * @author francescopioscognamiglio
 *
 */
public class DistributoreDiBevande
{
	
	/**
	 * saldo del distributore di bevande
	 */
	private double saldo;
	
	/**
	 * prodotti presenti nel distributore di bevande
	 */
	private List<Prodotto> prodotti;
	
	/**
	 * numero di prodotti presenti nel distributore di bevande
	 */
	private int numeroProdotti;
	
	/**
	 * costruttore che riceve in input il numero di prodotti che contiene il distributore di bevande
	 * @param N il numero di prodotti che contiene il distributore di bevande
	 */
	public DistributoreDiBevande(final int N)
	{
		saldo = 0.0;
		prodotti = new ArrayList<Prodotto>();
		numeroProdotti = N;
	}
	
	/**
	 * metodo che inserisce n prodotti di tipo e ordine casuale
	 */
	public void carica()
	{
		Random random = new Random();
		for (int i = 0; i < numeroProdotti; i++)
		{
			Prodotto p = null;
			switch(random.nextInt(3))
			{
			case 0: p = new Caffe(); break;
			case 1: p = new Cappuccino(); break;
			case 2: p = new Cioccolato(); break;
			}
			prodotti.add(p);
		}
	}
	
	/**
	 * metodo che permette di inserire un importo nel distributore di bevande
	 * @param importo l'importo inserito nel distributore di bevande
	 */
	public void inserisciImporto(double importo)
	{
		setSaldo(saldo + importo);
	}
	
	/**
	 * metodo che restituisce il prodotto associato al numero del prodotto fornito in input
	 * e decrementa il saldo disponibile nel distributore di bevande
	 * @param k il numero del prodotto
	 * @return il prodotto associato al numero k
	 */
	public Prodotto getProdotto(int k)
	{
		// un modo: per mantenere l'ordine degli elementi settiamo null alla posizione da cui abbiamo prelevato
		/*Prodotto p = prodotti.get(k);
		prodotti.set(k, null);
		return prodotto;*/
		// altro modo: il metodo set() mi restituisce l'elemento che era presente prima di settarlo a null
		return prodotti.set(k, null);
	}
	
	/**
	 * metodo setter che imposta il saldo del distributore di bevande
	 * @param nuovoSaldo il nuovo saldo del distributore di bevande
	 */
	private void setSaldo(double nuovoSaldo)
	{
		if (nuovoSaldo < 0.0) this.saldo = 0.0;
		else this.saldo = nuovoSaldo;
	}
	
	/**
	 * metodo getter che restituisce il saldo attuale del distributore di bevande
	 * @return il saldo attuale del distributore di bevande
	 */
	public double getSaldo()
	{
		return saldo;
	}
	
	/**
	 * metodo getter che restituisce il resto dovuto e azzera il saldo attuale del distributore di bevande
	 * @return il resto dovuto
	 */
	public double getResto()
	{
		double resto = saldo;
		setSaldo(0.0);
		return resto;
	}
	
}

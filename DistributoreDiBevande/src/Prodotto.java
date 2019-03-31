
/**
 * Esercizio: Distributore di bevande
 * 
 * Progettare una classe Prodotto con un prezzo e tre tipi diversi di prodotto: Caffè, Cappuccino, Cioccolato
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
abstract public class Prodotto
{
	
	/**
	 * prezzo del prodotto
	 */
	protected double prezzo;
	
	/**
	 * costruttore che imposta il prezzo del prodotto
	 * @param prezzo il prezzo del prodotto
	 */
	public Prodotto(double prezzo)
	{
		this.prezzo = prezzo;
	}
	
	/**
	 * metodo getter che restituisce il prezzo del prodotto
	 * @return il prezzo del prodotto
	 */
	public double getPrezzo()
	{
		return prezzo;
	}
	
}

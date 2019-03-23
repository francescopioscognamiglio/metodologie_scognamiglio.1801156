
/**
 * Esercizio: Calcolatrice (Preparazione esonero)
 * 
 * Progettare una classe Calcolatrice i cui oggetti rappresentano una calcolatrice con memoria espandibile.
 * Ogni oggetto calcolatrice è posto a un valore iniziale pari a 0.0 e possiede una memoria inizialmente vuota.
 * 
 * La classe implementa i seguenti metodi:
 * - somma che, dato in input un valore, lo somma al valore memorizzato nella calcolatrice, aggiornandone il valore.
 * - memorizza che memorizza l’attuale valore della calcolatrice nella prossima cella di memoria della calcolatrice.
 * - azzera che pone a 0.0 il valore della calcolatrice.
 * - recupera che, dato in input un intero k, recupera dalla memoria il valore associato
 * 		alla cella di memoria k, se essa esiste, e lo imposta come attuale valore della calcolatrice, restituendo true.
 * 		Se la cella di memoria non è mai stata usata il metodo restituisce false.
 * - toString che restituisce una stringa che esprime la sequenza delle somme effettuate.
 * 
 * Ad esempio, il seguente codice:
 * Calcolatrice c = new Calcolatrice();
 * c.somma(5); c.somma(3);
 * System.out.println(c.toString());
 * c.memorizza(); c.azzera(); c.recupera(0); c.somma(1);
 * System.out.println(c.toString());
 * c.memorizza(); c.azzera(); c.recupera(1);
 * System.out.println(c.toString());
 * stampa prima 0+5+3, poi 8+1 e poi 9.

 * @author francescopioscognamiglio
 *
 */
public class Calcolatrice
{
	
	/**
	 * valore double che contiene il valore corrente della calcolatrice
	 */
	private double valore;
	/**
	 * array di double che simula una memoria espandibile della calcolatrice
	 */
	private double[] memoria;
	/**
	 * stringa che contiene una rappresentazione delle somme effettuate
	 */
	private String sommeEffettuate;
	
	/**
	 * costruttore della classe vuoto
	 */
	public Calcolatrice()
	{
		valore = 0;
		memoria = new double[] {};
		reimpostaSommeEffettuate();
	}
	
	private void reimpostaSommeEffettuate()
	{
		reimpostaSommeEffettuate("" + valore);
	}
	
	private void reimpostaSommeEffettuate(String s)
	{
		sommeEffettuate = s;
	}
	
	/**
	 * metodo che somma il valore passato in input al valore memorizzato nella calcolatrice
	 * @param valore il valore passato in input
	 */
	public void somma(double valore)
	{
		this.valore += valore;
		reimpostaSommeEffettuate(sommeEffettuate + "+" + valore);
	}
	
	/**
	 * metodo che memorizza l'attuale valore della calcolatrice
	 */
	public void memorizza()
	{
		double[] memoriaCopia = new double[memoria.length+1];
		for (int i = 0; i < memoria.length; i++)
			memoriaCopia[i] = memoria[i];
		memoriaCopia[memoriaCopia.length-1] = valore;
		
		memoria = memoriaCopia;
	}
	
	/**
	 * metodo che azzera il valore della calcolatrice
	 */
	public void azzera()
	{
		valore = 0;
		reimpostaSommeEffettuate();
	}
	
	/**
	 * metodo che imposta il valore della calcolatrice al valore della memoria
	 * in posizione k e restituisce true se esiste la posizione k; false altrimenti
	 * @param k la posizione
	 * @return true se esiste la posizione k; false altrimenti
	 */
	public boolean recupera(int k)
	{
		if (k < memoria.length)
		{
			valore = memoria[k];
			reimpostaSommeEffettuate();
			return true;
		}
		return false;
	}
	
	/**
	 * metodo che restituisce una stringa che esprime la sequenza di somme effettuate
	 */
	public String toString()
	{
		return sommeEffettuate;
	}
	
	public static void main(String[] args)
	{
		Calcolatrice c = new Calcolatrice();
		
		c.somma(5); c.somma(3);
		System.out.println(c.toString());
		
		c.memorizza(); c.azzera(); c.recupera(0); c.somma(1);
		System.out.println(c.toString());
		
		c.memorizza(); c.azzera(); c.recupera(1);
		System.out.println(c.toString());
	}
	
}

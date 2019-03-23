
/**
 * Esercizio: StringaMangiona (Preparazione esonero)
 * 
 * Progettare la classe StringaMangiona.
 * Un oggetto della classe viene costruito passando in ingresso una stringa di tipo String
 * (ad esempio, new StringaMangiona(“aiuola”)).
 * 
 * La classe implementa i seguenti metodi:
 * - toString: restituisce la stringa;
 * - length: restituisce la lunghezza della stringa;
 * - getCarattere: prende in input una posizione k
 * 		e restituisce in output il carattere della stringa nella posizione k;
 * - mangiaLettera: modifica la stringa dell’oggetto eliminando tutte le occorrenze
 * 		della lettera passata in input
 * 		(es. new StringaMangiona(“aiuola”).mangiaLettera(’a’) modifica la stringa interna dell’oggetto in “iuol”);
 * - slurp: mangia tutte le lettere della stringa interna dell’oggetto;
 * - mangiaStringaMangiona: data in input un’altra StringaMangiona s,
 * 		mangia tutti i propri caratteri contenuti anche nella stringa mangiona s
 * 		(ad esempio, l’esecuzione di: new StringaMangiona("aiuola").mangiaStringaMangiona(new StringaMangiona("ala"));
 * 		modifica la stringa interna del primo oggetto in “iuo”).
 * - getTotaleMangiate: restituisce la somma delle occorrenze di lettere mangiate finora dall’oggetto
 * 		(ad esempio, a seguito dell’esecuzione di:
 * 		StringaMangiona s = new StringaMangiona("aabcbbb");
 * 		s.mangiaLettera(’a’);
 * 		s.mangiaLettera(’b’);
 * 		s.slurp();
 * 		getTotaleMangiate()
 * 		restituirà 7).

 * @author francescopioscognamiglio
 *
 */
public class StringaMangiona
{
	
	/**
	 * campo di tipo String dell'oggetto
	 */
	private String stringa;
	/**
	 * campo di tipo int dell'oggetto che rappresenta il numero totale di lettere mangiate
	 */
	private int totaleMangiate = 0;
	
	/**
	 * costruttore che permette di impostare la stringa dell'oggetto
	 * @param stringa
	 */
	public StringaMangiona(String stringa)
	{
		this.stringa = stringa;
	}
	
	/**
	 * metodo che restituisce la stringa dell'oggetto
	 * @return la stringa dell'oggetto
	 */
	public String toString()
	{
		return stringa;
	}
	
	/**
	 * metodo che restituisce la lunghezza della stringa dell'oggetto
	 * @return la lunghezza della stringa dell'oggetto
	 */
	public int length()
	{
		return stringa.length();
	}
	
	/**
	 * metodo che restituisce il carattere presente in posizione k
	 * @param k la posizione k
	 * @return il carattere presente in posizione k
	 */
	public char getCarattere(int k)
	{
		return stringa.charAt(k);
	}
	
	/**
	 * metodo che elimina tutte le occorrenze della lettera passata in input dalla stringa dell'oggetto
	 * @param lettera la lettera passata in input
	 */
	public void mangiaLettera(char lettera)
	{
		contaMangiate(lettera);
		stringa = stringa.replace("" + lettera, "");
	}
	
	/**
	 * metodo che mangia tutte le lettere della stringa dell'oggetto
	 */
	public void slurp()
	{
		totaleMangiate += stringa.length();
		stringa = "";
	}
	
	/**
	 * metodo che elimina tutte le occorrenze delle lettere dell'oggetto passato in input dalla stringa dell'oggetto
	 * @param s l'oggetto passato in input
	 */
	public void mangiaStringaMangiona(StringaMangiona s)
	{
		for (int i = 0; i < s.length(); i++)
			mangiaLettera(s.getCarattere(i));
	}
	
	/**
	 * metodo che conta quante volte la lettera é presente nella stringa dell'oggetto
	 * @param lettera la lettera da controllare
	 */
	private void contaMangiate(char lettera)
	{
		for (int i = 0; i < stringa.length(); i++)
			if (lettera == stringa.charAt(i))
				totaleMangiate++;
	}
	
	/**
	 * metodo che restituisce il numero totale di lettere eliminate
	 * @return il numero totale di lettere eliminate
	 */
	public int getTotaleMangiate()
	{
		return totaleMangiate;
	}
	
	public static void main(String[] args)
	{
		StringaMangiona stringaMangiona1 = new StringaMangiona("aiuola");
		stringaMangiona1.mangiaLettera('a');
		System.out.println(stringaMangiona1.toString());
		
		StringaMangiona stringaMangiona2 = new StringaMangiona("aiuola");
		stringaMangiona2.mangiaStringaMangiona(new StringaMangiona("ala"));
		System.out.println(stringaMangiona2.toString());
		
		StringaMangiona stringaMangiona3 = new StringaMangiona("aabcbbb");
		stringaMangiona3.mangiaLettera('a');
		stringaMangiona3.mangiaLettera('b');
		stringaMangiona3.slurp();
		System.out.println(stringaMangiona3.getTotaleMangiate());
	}
	
}

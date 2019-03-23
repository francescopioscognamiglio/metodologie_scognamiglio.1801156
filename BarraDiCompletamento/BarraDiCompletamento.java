
/**
 * Esercizi di riscaldamento
 * 
 * Progettare una classe BarraDiCompletamento i cui oggetti rappresentano una barra di caricamento
 * - Gli oggetti vengono costruiti con la percentuale di partenza
 * - La classe espone un metodo incrementa che, data una percentuale in input,
 * 		incrementa la percentuale di partenza con quella fornita in input
 * 		(ad es. new BarraDiCompletamento(5).incrementa(10) porta la barra al 15%
 * - Il metodo toString dell’oggetto restituisce una stringa contenente
 * 		la percentuale di completamento arrotondata con Math.round().
 * - Un metodo che restituisce tanti > quanto sono le decine e tanti = quanto fa (10 - decina)
 * - Il metodo main che crea una barra di completamento che parte da 0,
 * 		la incrementa prima di 20 punti percentuale e poi di altri 25
 * 		e quindi stampa la rappresentazione stringa della barra
 * 
 * @author francescopioscognamiglio
 *
 */
public class BarraDiCompletamento
{
	
	/**
	 * campo di tipo double che rappresenta la percentuale della barra di caricamento
	 */
	private double percentualeBarraDiCaricamento;
	
	/**
	 * costruttore della classe che permette di impostare la percentuale della barra di caricamento
	 * @param percentualeBarraDiCaricamento la percentuale della barra di caricamento
	 */
	public BarraDiCompletamento(double percentualeBarraDiCaricamento)
	{
		this.percentualeBarraDiCaricamento = percentualeBarraDiCaricamento;
	}
	
	/**
	 * costruttore della classe vuoto
	 */
	public BarraDiCompletamento()
	{
		this(0);
	}
	
	/**
	 * metodo setter che imposta la percentuale della barra di caricamento
	 * @param percentualeBarraDiCaricamento la percentuale della barra di caricamento
	 */
	public void setPercentualeBarraDiCaricamento(double percentualeBarraDiCaricamento)
	{
		this.percentualeBarraDiCaricamento = percentualeBarraDiCaricamento;
	}
	
	/**
	 * metodo getter che restituisce la percentuale della barra di caricamento
	 * @return la percentuale della barra di caricamento
	 */
	public double getPercentualeBarraDiCaricamento()
	{
		return percentualeBarraDiCaricamento;
	}
	
	/**
	 * metodo che incrementa la percentuale della barra di caricamento avendo una percentuale in input
	 * @param incremento la percentuale in input
	 */
	public void incrementa(double incremento)
	{
		percentualeBarraDiCaricamento += incremento;
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta la percentuale della barra di caricamento
	 */
	public String toString()
	{
		return "" + Math.round(percentualeBarraDiCaricamento);
	}
	
	/**
	 * metodo che restituisce una stringa che rappresenta graficamente la percentuale della barra di caricamento
	 * secondo le seguenti regole:
	 * la stringa é formata da tanti ">" quante sono le decine e tanti "=" quanto fa (10 - decine)
	 * @return stringa che rappresenta graficamente la percentuale della barra di caricamento
	 */
	public String rappPercentualeBarraDiCaricamento()
	{
		String risultato = "";
		int decine = (int)(percentualeBarraDiCaricamento / 10);
		for (int i = 0; i < decine; i++)
		{
			risultato += ">";
		}
		
		for (int i = 0; i < (10-decine); i++)
		{
			risultato += "=";
		}
		
		return risultato;
	}
	
	public static void main(String args[])
	{
		BarraDiCompletamento barraDiCompletamento = new BarraDiCompletamento();
		barraDiCompletamento.incrementa(20);
		barraDiCompletamento.incrementa(25);
		System.out.println("La stringa della barra di completamento e': " + barraDiCompletamento.toString());
		System.out.println("La rappresentazione grafica della barra di completamento e': " + barraDiCompletamento.rappPercentualeBarraDiCaricamento());
	}
	
}

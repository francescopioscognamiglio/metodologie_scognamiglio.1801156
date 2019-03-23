/**
 * Esercizi per cominciare
 * 
 * Scrivere una classe Variabili che, all’interno del metodo main,
 * dichiari una variabile intera i, una variabile di tipo stringa s
 * e una variabile double d.
 * Quindi vengono svolte le seguenti tre operazioni:
 * - La stringa viene inizializzata al valore del primo argomento fornito in input al main
 * - All’intero viene assegnato il valore intero della stringa
 * - Al double viene assegnata la metà del valore di i (ad es. se i è pari a 3, d sarà pari a 1.5)
 * - I valori di s, i e d vengono stampati a video
 * 
 * @author francescopioscognamiglio
 * 
 */
public class Variabili
{
	
	public static void main(String[] args)
	{
		String s = args[0];
		int i = Integer.parseInt(s);
		
		// cast implicito - viene fatta la conversione al tipo più potente
		double d = i / 2.0;
		
		System.out.println("Il valore in input e': " + s);
		System.out.println("Il valore in input convertito in intero e': " + i);
		System.out.println("Il valore della divisione tra " + i + " e 2.0 e': " + d);
	}
	
}

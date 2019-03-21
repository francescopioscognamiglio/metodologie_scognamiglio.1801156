package phraseomatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Esercizio: Phrase-O-Matic
 * Progettare una classe i cui oggetti contengono tre elenchi di parole l1 , l2 e l3
 * La classe è in grado di emettere nuove espressioni costruite creando stringhe del tipo "a b c"
 * scegliendo casualmente dai tre rispettivi elenchi a ε l1, b ε l2, c ε l3
 * 
 * Ad esempio, dati i seguenti elenchi:
 * l1 = { "salve", "ciao", "hello", "buongiorno", "scialla" }
 * l2 = { "egregio", "eclettico", "intelligentissimo", "astutissimo" }
 * l3 = { "studente", "ragazzo", "giovane", "scapestrato", "fannullone", "studioso" }
 * 
 * Esempi di output sono:
 * "salve egregio fannullone"
 * "ciao eclettico scapestrato"
 * "scialla astutissimo studente"
 * @author francescopioscognamiglio
 *
 */
public class PhraseOMatic
{
	
	private String[] elencoParole;
	
	public PhraseOMatic(String[] elencoParole)
	{
		this.elencoParole = Arrays.copyOf(elencoParole, elencoParole.length);
	}
	
	public void setEspressioneCasuale(String[] elencoParole)
	{
		this.elencoParole = Arrays.copyOf(elencoParole, elencoParole.length);
	}
	
	public String[] getEspressioneCasuale()
	{
		return Arrays.copyOf(elencoParole, elencoParole.length);
	}
	
	public String getParolaRandom()
	{
		int pos = (int)(Math.random() * elencoParole.length);
		return elencoParole[pos];
	}
	
	public String toString()
	{
		String risultato = "[";
		for (int i = 0; i < elencoParole.length; i++)
			risultato += elencoParole[i] + (i < elencoParole.length-1 ? ", " : "]");
		return risultato;
	}
	
	public static void main(String[] args)
	{
		String[] elencoParole1 = { "salve", "ciao", "hello", "buongiorno", "scialla" };
		String[] elencoParole2 = { "egregio", "eclettico", "intelligentissimo", "astutissimo" };
		String[] elencoParole3 = { "studente", "ragazzo", "giovane", "scapestrato", "fannullone", "studioso" };
		
		PhraseOMatic espressioneCasuale1 = new PhraseOMatic(elencoParole1);
		PhraseOMatic espressioneCasuale2 = new PhraseOMatic(elencoParole2);
		PhraseOMatic espressioneCasuale3 = new PhraseOMatic(elencoParole3);
		
		System.out.println("Il primo elenco di parole contiene: " + espressioneCasuale1.toString());
		System.out.println("Il secondo elenco di parole contiene: " + espressioneCasuale2.toString());
		System.out.println("Il terzo elenco di parole contiene: " + espressioneCasuale3.toString());
		
		System.out.println("------------------------------------------------------------------------------");
		System.out.println("Di seguito vi sono tutte le possibili combinazioni tra i tre elenchi di parole:");
		List<String> alreadyFounded = new ArrayList<String>();
		while(alreadyFounded.size() < espressioneCasuale1.getEspressioneCasuale().length * espressioneCasuale2.getEspressioneCasuale().length * espressioneCasuale3.getEspressioneCasuale().length)
		{
			String espressioneCasualeOutput = espressioneCasuale1.getParolaRandom() + " " + espressioneCasuale2.getParolaRandom() + " " + espressioneCasuale3.getParolaRandom();
			if (!alreadyFounded.contains(espressioneCasualeOutput))
			{
				System.out.println(espressioneCasualeOutput);
				alreadyFounded.add(espressioneCasualeOutput);
			}
		}
	}
	
}

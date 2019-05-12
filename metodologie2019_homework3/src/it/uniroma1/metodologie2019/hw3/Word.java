package it.uniroma1.metodologie2019.hw3;

import java.util.ArrayList;
import java.util.List;

/**
 * Una classe che rappresenta una parola presente nel file index.POS in WordNet.
 * Ogni parola é scritta in minuscolo ed é formata dal lemma, dalla parte del discorso e dalla lista degli offsets dei Synset che contengono il lemma.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class Word extends WordNetData
{
	/**
	 * La lista degli offsets dei Synset che contengono il lemma
	 */
	private List<String> offsets = new ArrayList<String>();
	
	/**
	 * Costruttore che prende in input una riga del file index.POS divisa dagli spazi.
	 * @param textSplitted la riga del file index.POS divisa dagli spazi
	 */
	public Word(String[] textSplitted)
	{
		super(textSplitted[0], POS.fromValue(textSplitted[1]));
		
		int i = textSplitted.length-1;
		while (textSplitted[i].matches("\\d{8}")) offsets.add(textSplitted[i--]);
	}
	
	/**
	 * Restituisce la lista degli offsets dei Synset che contengono il lemma.
	 * @return la lista degli offsets dei Synset che contengono il lemma.
	 */
	public List<String> getOffsets()
	{
		return offsets;
	}
	
	/**
	 * Restituisce l'identificativo univoco della parola dato dall'unione del lemma e della parte del discorso.
	 * @return l'identificativo univoco della parola dato dall'unione del lemma e della parte del discorso.
	 */
	public String getID()
	{
		return getKeyword() + "[" + getPOS().getValue() + "]";
	}
}

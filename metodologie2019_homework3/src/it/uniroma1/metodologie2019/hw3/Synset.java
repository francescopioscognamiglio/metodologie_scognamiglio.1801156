package it.uniroma1.metodologie2019.hw3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Una classe che rappresenta un Synset presente nel file data.POS in WordNet.
 * Ogni Synset é formato dall'offset, dalla parte del discorso, dai sinonimi, dai Synset correlati, dalla definizione e dagli esempi.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class Synset extends WordNetData
{
	/**
	 * I sinonimi del Synset
	 */
	private List<String> synonyms = new ArrayList<String>();
	
	/**
	 * I Synset correlati al Synset
	 */
	private Map<String, List<String>> pointers = new HashMap<String, List<String>>();
	
	/**
	 * La definizione del Synset
	 */
	private String gloss;
	/**
	 * Gli esempi del Synset
	 */
	private List<String> examples = new ArrayList<String>();
	
	/**
	 * Costruttore che prende in input una riga del file data.POS divisa dagli spazi e l'intera glossa comprendente anche gli esempi.
	 * @param textSplitted la riga del file data.POS divisa dagli spazi
	 * @param fullGloss l'intera glossa comprendente anche gli esempi
	 */
	public Synset(String[] textSplitted, String fullGloss)
	{
		super(textSplitted[0], POS.fromValue(textSplitted[2]));
		
		int i = 3;
		int synonymsNumber = Integer.parseInt(textSplitted[i++], 16);
		for (int j = 0; j < synonymsNumber; i+=2, j++) synonyms.add(textSplitted[i]);
		if (getPOS().equals(POS.ADJECTIVE)) synonyms.replaceAll(e -> e.replaceAll("\\(.*?\\)", ""));
		
		int pointersNumber = Integer.parseInt(textSplitted[i++]);
		for (int j = 0; j < pointersNumber; j++)
		{
			pointers.merge(textSplitted[i++], new ArrayList<>(List.of(textSplitted[i] + textSplitted[i+1])), (eOld, eNew) -> { eOld.addAll(eNew); return eOld; });
			i+=3;
		}
		
		String regex = "\"(.*?)\"+(?:;|)";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(fullGloss);
		while (m.find())
		{
			examples.add(m.group(1));
			fullGloss = fullGloss.replace("\"" + m.group(1) + "\"", "");
			fullGloss = fullGloss.trim();
			if (fullGloss.endsWith(";")) fullGloss = fullGloss.substring(0, fullGloss.length()-1);
		}
		
		gloss = fullGloss.trim();
		if (gloss.endsWith(";")) gloss = gloss.substring(0, gloss.length()-1);
	}
	
	/**
	 * Restituisce la lista dei sinonimi del Synset.
	 * @return la lista dei sinonimi del Synset.
	 */
	public List<String> getSynonyms()
	{
		return synonyms;
	}
	
	/**
	 * Data in input una parola, restituisce true se il Synset la contiene tra i suoi sinonimi, false altrimenti.
	 * @param word la parola
	 * @return true se il Synset contiene la parola tra i suoi sinonimi, false altrimenti.
	 */
	public boolean contains(String word)
	{
		return synonyms.contains(word);
	}
	
	/**
	 * Restituisce la glossa del Synset.
	 * @return la glossa del Synset.
	 */
	public String getGloss()
	{
		return gloss;
	}
	
	/**
	 * Restituisce la lista degli esempi del Synset, vuota se non li contiene.
	 * @return la lista degli esempi del Synset, vuota se non li contiene.
	 */
	public List<String> getExamples()
	{
		return examples;
	}
	
	/**
	 * Restituisce l'offset del Synset.
	 * @return l'offset del Synset.
	 */
	public String getOffset()
	{
		return getKeyword();
	}
	
	/**
	 * Restituisce l'identificativo univoco del Synset dato dall'unione dell'offset e della parte del discorso.
	 * @return l'identificativo univoco del Synset dato dall'unione dell'offset e della parte del discorso.
	 */
	public String getID()
	{
		return getKeyword() + getPOS().getValue();
	}
	
	/**
	 * Restituisce la lista dei Synset correlati al Synset.
	 * @return la lista dei Synset correlati al Synset.
	 */
	public Map<String, List<String>> getPointers()
	{
		return pointers;
	}
}

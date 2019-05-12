package it.uniroma1.metodologie2019.hw3;

import java.util.List;
import java.util.Optional;

/**
 * Una classe che crea la mappatura tra due versioni di WordNet, una sorgente ed una destinazione.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class WordNetMapping
{
	/**
	 * La versione WordNet sorgente
	 */
	private WordNet source;
	/**
	 * La versione WordNet destinazione
	 */
	private WordNet target;
	
	/**
	 * Costruttore che prende in input due versioni di WordNet, una sorgente e l'altra destinazione.
	 * @param source la versione di WordNet sorgente
	 * @param target la versione di WordNet destinazione
	 */
	public WordNetMapping(WordNet source, WordNet target)
	{
		this.source = source;
		this.target = target;
	}
	
	/**
	 * Dato in input un Synset sorgente, restituisce un Optional contenente il SynsetPairing che mappa il Synset sorgente con il miglior Synset destinazione.
	 * @param synsetSource il Synset sorgente
	 * @return un Optional contenente il SynsetPairing che mappa il Synset sorgente con il miglior Synset destinazione.
	 */
	public Optional<SynsetPairing> getMapping(Synset synsetSource)
	{
		String pos = synsetSource.getPOS().getValue();
		
		List<String> synonymsSource = synsetSource.getSynonyms();
		for (String synonym : synonymsSource)
		{
			Word wordIndex = target.getWordFromID(synonym.toLowerCase() + "[" + pos + "]");
			if (wordIndex != null)
			{
				iOffset : for (String offset : wordIndex.getOffsets())
				{
					Synset synsetTarget = target.getSynsetFromID(offset + pos);
					if (synsetSource.getGloss().equals(synsetTarget.getGloss()))
					{
						List<String> synonymsTarget = synsetTarget.getSynonyms();
						for (String synonymTarget : synonymsTarget)
							if (!synonymsSource.contains(synonymTarget)) continue iOffset;
						
						for (String synonymSource : synonymsSource)
							if (!synonymsTarget.contains(synonymSource)) continue iOffset;
						
						return Optional.of(new SynsetPairing(synsetSource, synsetTarget, 1.0));
					}
				}
			}
		}
		return Optional.empty();
	}
}

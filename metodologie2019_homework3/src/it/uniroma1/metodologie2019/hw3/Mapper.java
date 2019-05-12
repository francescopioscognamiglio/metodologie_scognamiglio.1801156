package it.uniroma1.metodologie2019.hw3;

/**
 * Una classe che fornisce le mappature tra due versioni di WordNet, una sorgente ed una destinazione.
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class Mapper
{
	/**
	 * Date in input due versioni di WordNet, una sorgente e l'altra destinazione, restituisce un oggetto WordNetMapping che fornisce le mappature dalla versione di WordNet di partenza a quella di destinazione.
	 * @param source la versione di WordNet sorgente
	 * @param target la versione di WordNet destinazione
	 * @return un oggetto WordNetMapping che fornisce le mappature dalla versione di WordNet di partenza a quella di destinazione.
	 */
	public static WordNetMapping map(WordNet source, WordNet target)
	{
		return new WordNetMapping(source, target);
	}
}

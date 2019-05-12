package it.uniroma1.metodologie2019.hw3;

/**
 * Una classe che rappresenta la coppia Synset sorgente e Synset destinazione con associato il valore di confidenza della coppia. 
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public class SynsetPairing
{
	/**
	 * Il Synset sorgente
	 */
	private Synset source;
	/**
	 * Il Synset destinazione
	 */
	private Synset target;
	/**
	 * Il valore di confidenza della coppia
	 */
	private double score;
	
	/**
	 * Costruttore che prende in input il Synset sorgente, il Synset destinazione e lo score di confidenza della coppia.
	 * @param source il Synset sorgente
	 * @param target il Synset destinazione
	 * @param score lo score di confidenza della coppia
	 */
	public SynsetPairing(Synset source, Synset target, double score)
	{
		this.source = source;
		this.target = target;
		this.score = score;
	}
	
	/**
	 * Restituisce il Synset sorgente.
	 * @return il Synset sorgente.
	 */
	public Synset getSource()
	{
		return source;
	}
	
	/**
	 * Restituisce il Synset destinazione.
	 * @return il Synset destinazione.
	 */
	public Synset getTarget()
	{
		return target;
	}
	
	/**
	 * Restituisce il valore di confidenza della coppia compreso tra 0.0 e 1.0.
	 * @return il valore di confidenza della coppia compreso tra 0.0 e 1.0.
	 */
	public double getScore()
	{
		return score;
	}
}

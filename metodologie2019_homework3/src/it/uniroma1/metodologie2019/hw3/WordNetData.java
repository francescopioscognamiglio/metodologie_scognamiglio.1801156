package it.uniroma1.metodologie2019.hw3;

/**
 * Una classe che rappresenta un dato generico di WordNet.
 * Un dato generico é formato da una parola chiave (keyword) e dalla parte del discorso (type).
 * 
 * @author Francesco Pio Scognamiglio
 *
 */
public abstract class WordNetData
{
	/**
	 * La parola chiave del dato
	 */
	private String keyword;
	/**
	 * La parte del discorso del dato
	 */
	private POS type;
	
	/**
	 * Costruttore che prende in input la parola chiave e la parte del discorso
	 * @param keyword la parola chiave
	 * @param type la parte del discorso
	 */
	public WordNetData(String keyword, POS type)
	{
		this.keyword = keyword;
		this.type = type;
	}
	
	/**
	 * Restituisce la parola chiave del dato
	 * @return la parola chiave del dato
	 */
	public String getKeyword()
	{
		return keyword;
	}
	
	/**
	 * Restituisce la parte del discorso del dato
	 * @return la parte del discorso del dato
	 */
	public POS getPOS()
	{
		return type;
	}
	
	/**
	 * Restituisce l'identificativo univoco del dato
	 * @return l'identificativo univoco del dato
	 */
	abstract String getID();
}
